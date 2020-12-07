package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes12.dex */
public final class d<T> implements Queue<T> {
    final AtomicLong consumerIndex;
    AtomicReferenceArray<Object> pHA;
    int pHw;
    int pHx;
    AtomicReferenceArray<Object> pHy;
    int pHz;
    final AtomicLong producerIndex;
    long producerLookAhead;
    static final int pHv = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object pHB = new Object();

    public d(int i) {
        int RR = h.RR(i);
        int i2 = RR - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(RR + 1);
        this.pHy = atomicReferenceArray;
        this.pHx = i2;
        RO(RR);
        this.pHA = atomicReferenceArray;
        this.pHz = i2;
        this.producerLookAhead = i2 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pHy;
        long eDj = eDj();
        int i = this.pHx;
        int O = O(eDj, i);
        if (eDj < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eDj, O);
        }
        int i2 = this.pHw;
        if (b(atomicReferenceArray, O(i2 + eDj, i)) == null) {
            this.producerLookAhead = (i2 + eDj) - 1;
            return a(atomicReferenceArray, t, eDj, O);
        } else if (b(atomicReferenceArray, O(1 + eDj, i)) == null) {
            return a(atomicReferenceArray, t, eDj, O);
        } else {
            a(atomicReferenceArray, eDj, O, t, i);
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
        this.pHy = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, pHB);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, RP(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, RP(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pHA;
        long eDk = eDk();
        int i = this.pHz;
        int O = O(eDk, i);
        T t = (T) b(atomicReferenceArray, O);
        boolean z = t == pHB;
        if (t != null && !z) {
            a(atomicReferenceArray, O, (Object) null);
            soConsumerIndex(1 + eDk);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), eDk, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.pHA = atomicReferenceArray;
        int O = O(j, i);
        T t = (T) b(atomicReferenceArray, O);
        if (t == null) {
            return null;
        }
        a(atomicReferenceArray, O, (Object) null);
        soConsumerIndex(1 + j);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pHA;
        long eDk = eDk();
        int i = this.pHz;
        T t = (T) b(atomicReferenceArray, O(eDk, i));
        if (t == pHB) {
            return b(a(atomicReferenceArray), eDk, i);
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
        this.pHA = atomicReferenceArray;
        return (T) b(atomicReferenceArray, O(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long eDi = eDi();
        while (true) {
            long eDh = eDh();
            long eDi2 = eDi();
            if (eDi == eDi2) {
                return (int) (eDh - eDi2);
            }
            eDi = eDi2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return eDh() == eDi();
    }

    private void RO(int i) {
        this.pHw = Math.min(i / 4, pHv);
    }

    private long eDh() {
        return this.producerIndex.get();
    }

    private long eDi() {
        return this.consumerIndex.get();
    }

    private long eDj() {
        return this.producerIndex.get();
    }

    private long eDk() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int O(long j, int i) {
        return RP(((int) j) & i);
    }

    private static int RP(int i) {
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.pHy;
        long eDh = eDh();
        int i = this.pHx;
        if (b(atomicReferenceArray, O(eDh + 2, i)) == null) {
            int O = O(eDh, i);
            a(atomicReferenceArray, O + 1, t2);
            a(atomicReferenceArray, O, t);
            soProducerIndex(eDh + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.pHy = atomicReferenceArray2;
        int O2 = O(eDh, i);
        a(atomicReferenceArray2, O2 + 1, t2);
        a(atomicReferenceArray2, O2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, O2, pHB);
        soProducerIndex(eDh + 2);
        return true;
    }
}
