package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes6.dex */
public final class f<T> implements Queue<T> {
    static final int nUZ = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nVf = new Object();
    final AtomicLong consumerIndex;
    int nVa;
    int nVb;
    AtomicReferenceArray<Object> nVc;
    int nVd;
    AtomicReferenceArray<Object> nVe;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public f(int i) {
        int Lo = h.Lo(Math.max(8, i));
        int i2 = Lo - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Lo + 1);
        this.nVc = atomicReferenceArray;
        this.nVb = i2;
        Ll(Lo);
        this.nVe = atomicReferenceArray;
        this.nVd = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.nVc;
        long dTi = dTi();
        int i = this.nVb;
        int C = C(dTi, i);
        if (dTi < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dTi, C);
        }
        int i2 = this.nVa;
        if (b(atomicReferenceArray, C(i2 + dTi, i)) == null) {
            this.producerLookAhead = (i2 + dTi) - 1;
            return a(atomicReferenceArray, t, dTi, C);
        } else if (b(atomicReferenceArray, C(1 + dTi, i)) != null) {
            return a(atomicReferenceArray, t, dTi, C);
        } else {
            a(atomicReferenceArray, dTi, C, t, i);
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
        this.nVc = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nVf);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Lm(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, Lm(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nVe;
        long dTj = dTj();
        int i = this.nVd;
        int C = C(dTj, i);
        T t = (T) b(atomicReferenceArray, C);
        boolean z = t == nVf;
        if (t != null && !z) {
            soConsumerIndex(dTj + 1);
            a(atomicReferenceArray, C, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), dTj, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nVe = atomicReferenceArray;
        int C = C(j, i);
        T t = (T) b(atomicReferenceArray, C);
        if (t == null) {
            return null;
        }
        soConsumerIndex(1 + j);
        a(atomicReferenceArray, C, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nVe;
        long dTj = dTj();
        int i = this.nVd;
        T t = (T) b(atomicReferenceArray, C(dTj, i));
        if (t == nVf) {
            return b(a(atomicReferenceArray), dTj, i);
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
        this.nVe = atomicReferenceArray;
        return (T) b(atomicReferenceArray, C(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long dTh = dTh();
        while (true) {
            long dTg = dTg();
            long dTh2 = dTh();
            if (dTh == dTh2) {
                return (int) (dTg - dTh2);
            }
            dTh = dTh2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return dTg() == dTh();
    }

    private void Ll(int i) {
        this.nVa = Math.min(i / 4, nUZ);
    }

    private long dTg() {
        return this.producerIndex.get();
    }

    private long dTh() {
        return this.consumerIndex.get();
    }

    private long dTi() {
        return this.producerIndex.get();
    }

    private long dTj() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int C(long j, int i) {
        return Lm(((int) j) & i);
    }

    private static int Lm(int i) {
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
