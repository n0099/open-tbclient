package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes14.dex */
public final class f<T> implements Queue<T> {
    static final int qgg = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qgm = new Object();
    final AtomicLong consumerIndex;
    final AtomicLong producerIndex;
    long producerLookAhead;
    int qgh;
    int qgi;
    AtomicReferenceArray<Object> qgj;
    int qgk;
    AtomicReferenceArray<Object> qgl;

    public f(int i) {
        int RT = h.RT(Math.max(8, i));
        int i2 = RT - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(RT + 1);
        this.qgj = atomicReferenceArray;
        this.qgi = i2;
        RQ(RT);
        this.qgl = atomicReferenceArray;
        this.qgk = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.qgj;
        long eIg = eIg();
        int i = this.qgi;
        int Q = Q(eIg, i);
        if (eIg < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eIg, Q);
        }
        int i2 = this.qgh;
        if (b(atomicReferenceArray, Q(i2 + eIg, i)) == null) {
            this.producerLookAhead = (i2 + eIg) - 1;
            return a(atomicReferenceArray, t, eIg, Q);
        } else if (b(atomicReferenceArray, Q(1 + eIg, i)) != null) {
            return a(atomicReferenceArray, t, eIg, Q);
        } else {
            a(atomicReferenceArray, eIg, Q, t, i);
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
        this.qgj = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, qgm);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, RR(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, RR(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qgl;
        long eIh = eIh();
        int i = this.qgk;
        int Q = Q(eIh, i);
        T t = (T) b(atomicReferenceArray, Q);
        boolean z = t == qgm;
        if (t != null && !z) {
            soConsumerIndex(eIh + 1);
            a(atomicReferenceArray, Q, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), eIh, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qgl = atomicReferenceArray;
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.qgl;
        long eIh = eIh();
        int i = this.qgk;
        T t = (T) b(atomicReferenceArray, Q(eIh, i));
        if (t == qgm) {
            return b(a(atomicReferenceArray), eIh, i);
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
        this.qgl = atomicReferenceArray;
        return (T) b(atomicReferenceArray, Q(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long eIf = eIf();
        while (true) {
            long eIe = eIe();
            long eIf2 = eIf();
            if (eIf == eIf2) {
                return (int) (eIe - eIf2);
            }
            eIf = eIf2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return eIe() == eIf();
    }

    private void RQ(int i) {
        this.qgh = Math.min(i / 4, qgg);
    }

    private long eIe() {
        return this.producerIndex.get();
    }

    private long eIf() {
        return this.consumerIndex.get();
    }

    private long eIg() {
        return this.producerIndex.get();
    }

    private long eIh() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int Q(long j, int i) {
        return RR(((int) j) & i);
    }

    private static int RR(int i) {
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
