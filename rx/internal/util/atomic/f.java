package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes15.dex */
public final class f<T> implements Queue<T> {
    static final int qkI = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qkO = new Object();
    final AtomicLong consumerIndex;
    final AtomicLong producerIndex;
    long producerLookAhead;
    int qkJ;
    int qkK;
    AtomicReferenceArray<Object> qkL;
    int qkM;
    AtomicReferenceArray<Object> qkN;

    public f(int i) {
        int TA = h.TA(Math.max(8, i));
        int i2 = TA - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(TA + 1);
        this.qkL = atomicReferenceArray;
        this.qkK = i2;
        Tx(TA);
        this.qkN = atomicReferenceArray;
        this.qkM = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.qkL;
        long eLW = eLW();
        int i = this.qkK;
        int Q = Q(eLW, i);
        if (eLW < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eLW, Q);
        }
        int i2 = this.qkJ;
        if (b(atomicReferenceArray, Q(i2 + eLW, i)) == null) {
            this.producerLookAhead = (i2 + eLW) - 1;
            return a(atomicReferenceArray, t, eLW, Q);
        } else if (b(atomicReferenceArray, Q(1 + eLW, i)) != null) {
            return a(atomicReferenceArray, t, eLW, Q);
        } else {
            a(atomicReferenceArray, eLW, Q, t, i);
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
        this.qkL = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, qkO);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Ty(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, Ty(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qkN;
        long eLX = eLX();
        int i = this.qkM;
        int Q = Q(eLX, i);
        T t = (T) b(atomicReferenceArray, Q);
        boolean z = t == qkO;
        if (t != null && !z) {
            soConsumerIndex(eLX + 1);
            a(atomicReferenceArray, Q, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), eLX, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qkN = atomicReferenceArray;
        int Q = Q(j, i);
        T t = (T) b(atomicReferenceArray, Q);
        if (t == null) {
            return null;
        }
        soConsumerIndex(1 + j);
        a(atomicReferenceArray, Q, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qkN;
        long eLX = eLX();
        int i = this.qkM;
        T t = (T) b(atomicReferenceArray, Q(eLX, i));
        if (t == qkO) {
            return b(a(atomicReferenceArray), eLX, i);
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
        this.qkN = atomicReferenceArray;
        return (T) b(atomicReferenceArray, Q(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long eLV = eLV();
        while (true) {
            long eLU = eLU();
            long eLV2 = eLV();
            if (eLV == eLV2) {
                return (int) (eLU - eLV2);
            }
            eLV = eLV2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return eLU() == eLV();
    }

    private void Tx(int i) {
        this.qkJ = Math.min(i / 4, qkI);
    }

    private long eLU() {
        return this.producerIndex.get();
    }

    private long eLV() {
        return this.consumerIndex.get();
    }

    private long eLW() {
        return this.producerIndex.get();
    }

    private long eLX() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int Q(long j, int i) {
        return Ty(((int) j) & i);
    }

    private static int Ty(int i) {
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
