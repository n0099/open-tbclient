package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes6.dex */
public final class d<T> implements Queue<T> {
    static final int nqB = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nqH = new Object();
    final AtomicLong consumerIndex;
    int nqC;
    int nqD;
    AtomicReferenceArray<Object> nqE;
    int nqF;
    AtomicReferenceArray<Object> nqG;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public d(int i) {
        int JN = h.JN(i);
        int i2 = JN - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(JN + 1);
        this.nqE = atomicReferenceArray;
        this.nqD = i2;
        JK(JN);
        this.nqG = atomicReferenceArray;
        this.nqF = i2;
        this.producerLookAhead = i2 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nqE;
        long dLc = dLc();
        int i = this.nqD;
        int B = B(dLc, i);
        if (dLc < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dLc, B);
        }
        int i2 = this.nqC;
        if (b(atomicReferenceArray, B(i2 + dLc, i)) == null) {
            this.producerLookAhead = (i2 + dLc) - 1;
            return a(atomicReferenceArray, t, dLc, B);
        } else if (b(atomicReferenceArray, B(1 + dLc, i)) == null) {
            return a(atomicReferenceArray, t, dLc, B);
        } else {
            a(atomicReferenceArray, dLc, B, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        a(atomicReferenceArray, i, t);
        soProducerIndex(1 + j);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.nqE = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nqH);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, JL(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, JL(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nqG;
        long dLd = dLd();
        int i = this.nqF;
        int B = B(dLd, i);
        T t = (T) b(atomicReferenceArray, B);
        boolean z = t == nqH;
        if (t != null && !z) {
            a(atomicReferenceArray, B, (Object) null);
            soConsumerIndex(1 + dLd);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), dLd, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nqG = atomicReferenceArray;
        int B = B(j, i);
        T t = (T) b(atomicReferenceArray, B);
        if (t == null) {
            return null;
        }
        a(atomicReferenceArray, B, (Object) null);
        soConsumerIndex(1 + j);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nqG;
        long dLd = dLd();
        int i = this.nqF;
        T t = (T) b(atomicReferenceArray, B(dLd, i));
        if (t == nqH) {
            return b(a(atomicReferenceArray), dLd, i);
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
        this.nqG = atomicReferenceArray;
        return (T) b(atomicReferenceArray, B(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long dLb = dLb();
        while (true) {
            long dLa = dLa();
            long dLb2 = dLb();
            if (dLb == dLb2) {
                return (int) (dLa - dLb2);
            }
            dLb = dLb2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return dLa() == dLb();
    }

    private void JK(int i) {
        this.nqC = Math.min(i / 4, nqB);
    }

    private long dLa() {
        return this.producerIndex.get();
    }

    private long dLb() {
        return this.consumerIndex.get();
    }

    private long dLc() {
        return this.producerIndex.get();
    }

    private long dLd() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int B(long j, int i) {
        return JL(((int) j) & i);
    }

    private static int JL(int i) {
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

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nqE;
        long dLa = dLa();
        int i = this.nqD;
        if (b(atomicReferenceArray, B(dLa + 2, i)) == null) {
            int B = B(dLa, i);
            a(atomicReferenceArray, B + 1, t2);
            a(atomicReferenceArray, B, t);
            soProducerIndex(dLa + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.nqE = atomicReferenceArray2;
        int B2 = B(dLa, i);
        a(atomicReferenceArray2, B2 + 1, t2);
        a(atomicReferenceArray2, B2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, B2, nqH);
        soProducerIndex(dLa + 2);
        return true;
    }
}
