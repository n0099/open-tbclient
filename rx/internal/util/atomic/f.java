package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes6.dex */
public final class f<T> implements Queue<T> {
    static final int nMo = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nMu = new Object();
    final AtomicLong consumerIndex;
    int nMp;
    int nMq;
    AtomicReferenceArray<Object> nMr;
    int nMs;
    AtomicReferenceArray<Object> nMt;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public f(int i) {
        int KU = h.KU(Math.max(8, i));
        int i2 = KU - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(KU + 1);
        this.nMr = atomicReferenceArray;
        this.nMq = i2;
        KR(KU);
        this.nMt = atomicReferenceArray;
        this.nMs = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.nMr;
        long dPI = dPI();
        int i = this.nMq;
        int B = B(dPI, i);
        if (dPI < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dPI, B);
        }
        int i2 = this.nMp;
        if (b(atomicReferenceArray, B(i2 + dPI, i)) == null) {
            this.producerLookAhead = (i2 + dPI) - 1;
            return a(atomicReferenceArray, t, dPI, B);
        } else if (b(atomicReferenceArray, B(1 + dPI, i)) != null) {
            return a(atomicReferenceArray, t, dPI, B);
        } else {
            a(atomicReferenceArray, dPI, B, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        soProducerIndex(1 + j);
        a(atomicReferenceArray, i, t);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.nMr = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nMu);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, KS(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, KS(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nMt;
        long dPJ = dPJ();
        int i = this.nMs;
        int B = B(dPJ, i);
        T t = (T) b(atomicReferenceArray, B);
        boolean z = t == nMu;
        if (t != null && !z) {
            soConsumerIndex(dPJ + 1);
            a(atomicReferenceArray, B, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), dPJ, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nMt = atomicReferenceArray;
        int B = B(j, i);
        T t = (T) b(atomicReferenceArray, B);
        if (t == null) {
            return null;
        }
        soConsumerIndex(1 + j);
        a(atomicReferenceArray, B, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nMt;
        long dPJ = dPJ();
        int i = this.nMs;
        T t = (T) b(atomicReferenceArray, B(dPJ, i));
        if (t == nMu) {
            return b(a(atomicReferenceArray), dPJ, i);
        }
        return t;
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nMt = atomicReferenceArray;
        return (T) b(atomicReferenceArray, B(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long dPH = dPH();
        while (true) {
            long dPG = dPG();
            long dPH2 = dPH();
            if (dPH == dPH2) {
                return (int) (dPG - dPH2);
            }
            dPH = dPH2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return dPG() == dPH();
    }

    private void KR(int i) {
        this.nMp = Math.min(i / 4, nMo);
    }

    private long dPG() {
        return this.producerIndex.get();
    }

    private long dPH() {
        return this.consumerIndex.get();
    }

    private long dPI() {
        return this.producerIndex.get();
    }

    private long dPJ() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int B(long j, int i) {
        return KS(((int) j) & i);
    }

    private static int KS(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }
}
