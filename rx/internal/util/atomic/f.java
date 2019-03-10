package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class f<T> implements Queue<T> {
    final AtomicLong consumerIndex;
    AtomicReferenceArray<Object> kbA;
    int kbB;
    AtomicReferenceArray<Object> kbC;
    long kbv;
    int kby;
    int kbz;
    final AtomicLong producerIndex;
    static final int kbx = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kbD = new Object();

    public f(int i) {
        int Du = h.Du(Math.max(8, i));
        int i2 = Du - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Du + 1);
        this.kbA = atomicReferenceArray;
        this.kbz = i2;
        Ds(Du);
        this.kbC = atomicReferenceArray;
        this.kbB = i2;
        this.kbv = i2 - 1;
        eq(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.kbA;
        long cEO = cEO();
        int i = this.kbz;
        int z = z(cEO, i);
        if (cEO < this.kbv) {
            return a(atomicReferenceArray, t, cEO, z);
        }
        int i2 = this.kby;
        if (a(atomicReferenceArray, z(i2 + cEO, i)) == null) {
            this.kbv = (i2 + cEO) - 1;
            return a(atomicReferenceArray, t, cEO, z);
        } else if (a(atomicReferenceArray, z(1 + cEO, i)) != null) {
            return a(atomicReferenceArray, t, cEO, z);
        } else {
            a(atomicReferenceArray, cEO, z, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        eq(1 + j);
        a(atomicReferenceArray, i, t);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kbA = atomicReferenceArray2;
        this.kbv = (j + j2) - 1;
        eq(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, kbD);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Dt(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, Dt(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kbC;
        long cEP = cEP();
        int i = this.kbB;
        int z = z(cEP, i);
        T t = (T) a(atomicReferenceArray, z);
        boolean z2 = t == kbD;
        if (t != null && !z2) {
            er(cEP + 1);
            a(atomicReferenceArray, z, (Object) null);
            return t;
        } else if (z2) {
            return a(a(atomicReferenceArray), cEP, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.kbC = atomicReferenceArray;
        int z = z(j, i);
        T t = (T) a(atomicReferenceArray, z);
        if (t == null) {
            return null;
        }
        er(1 + j);
        a(atomicReferenceArray, z, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kbC;
        long cEP = cEP();
        int i = this.kbB;
        T t = (T) a(atomicReferenceArray, z(cEP, i));
        if (t == kbD) {
            return b(a(atomicReferenceArray), cEP, i);
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
        this.kbC = atomicReferenceArray;
        return (T) a(atomicReferenceArray, z(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cEM = cEM();
        while (true) {
            long cEN = cEN();
            long cEM2 = cEM();
            if (cEM == cEM2) {
                return (int) (cEN - cEM2);
            }
            cEM = cEM2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cEN() == cEM();
    }

    private void Ds(int i) {
        this.kby = Math.min(i / 4, kbx);
    }

    private long cEN() {
        return this.producerIndex.get();
    }

    private long cEM() {
        return this.consumerIndex.get();
    }

    private long cEO() {
        return this.producerIndex.get();
    }

    private long cEP() {
        return this.consumerIndex.get();
    }

    private void eq(long j) {
        this.producerIndex.lazySet(j);
    }

    private void er(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int z(long j, int i) {
        return Dt(((int) j) & i);
    }

    private static int Dt(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
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
