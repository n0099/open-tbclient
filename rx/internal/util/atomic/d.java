package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes6.dex */
public final class d<T> implements Queue<T> {
    static final int npr = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object npx = new Object();
    final AtomicLong consumerIndex;
    int nps;
    int npt;
    AtomicReferenceArray<Object> npu;
    int npv;
    AtomicReferenceArray<Object> npw;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public d(int i) {
        int JL = h.JL(i);
        int i2 = JL - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(JL + 1);
        this.npu = atomicReferenceArray;
        this.npt = i2;
        JI(JL);
        this.npw = atomicReferenceArray;
        this.npv = i2;
        this.producerLookAhead = i2 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.npu;
        long dKO = dKO();
        int i = this.npt;
        int B = B(dKO, i);
        if (dKO < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dKO, B);
        }
        int i2 = this.nps;
        if (b(atomicReferenceArray, B(i2 + dKO, i)) == null) {
            this.producerLookAhead = (i2 + dKO) - 1;
            return a(atomicReferenceArray, t, dKO, B);
        } else if (b(atomicReferenceArray, B(1 + dKO, i)) == null) {
            return a(atomicReferenceArray, t, dKO, B);
        } else {
            a(atomicReferenceArray, dKO, B, t, i);
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
        this.npu = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, npx);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, JJ(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, JJ(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.npw;
        long dKP = dKP();
        int i = this.npv;
        int B = B(dKP, i);
        T t = (T) b(atomicReferenceArray, B);
        boolean z = t == npx;
        if (t != null && !z) {
            a(atomicReferenceArray, B, (Object) null);
            soConsumerIndex(1 + dKP);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), dKP, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.npw = atomicReferenceArray;
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.npw;
        long dKP = dKP();
        int i = this.npv;
        T t = (T) b(atomicReferenceArray, B(dKP, i));
        if (t == npx) {
            return b(a(atomicReferenceArray), dKP, i);
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
        this.npw = atomicReferenceArray;
        return (T) b(atomicReferenceArray, B(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long dKN = dKN();
        while (true) {
            long dKM = dKM();
            long dKN2 = dKN();
            if (dKN == dKN2) {
                return (int) (dKM - dKN2);
            }
            dKN = dKN2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return dKM() == dKN();
    }

    private void JI(int i) {
        this.nps = Math.min(i / 4, npr);
    }

    private long dKM() {
        return this.producerIndex.get();
    }

    private long dKN() {
        return this.consumerIndex.get();
    }

    private long dKO() {
        return this.producerIndex.get();
    }

    private long dKP() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int B(long j, int i) {
        return JJ(((int) j) & i);
    }

    private static int JJ(int i) {
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.npu;
        long dKM = dKM();
        int i = this.npt;
        if (b(atomicReferenceArray, B(dKM + 2, i)) == null) {
            int B = B(dKM, i);
            a(atomicReferenceArray, B + 1, t2);
            a(atomicReferenceArray, B, t);
            soProducerIndex(dKM + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.npu = atomicReferenceArray2;
        int B2 = B(dKM, i);
        a(atomicReferenceArray2, B2 + 1, t2);
        a(atomicReferenceArray2, B2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, B2, npx);
        soProducerIndex(dKM + 2);
        return true;
    }
}
