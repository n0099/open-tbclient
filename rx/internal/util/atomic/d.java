package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class d<T> implements Queue<T> {
    static final int kbp = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kbv = new Object();
    final AtomicLong consumerIndex;
    long kbn;
    int kbq;
    int kbr;
    AtomicReferenceArray<Object> kbs;
    int kbt;
    AtomicReferenceArray<Object> kbu;
    final AtomicLong producerIndex;

    public d(int i) {
        int Du = h.Du(i);
        int i2 = Du - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Du + 1);
        this.kbs = atomicReferenceArray;
        this.kbr = i2;
        Ds(Du);
        this.kbu = atomicReferenceArray;
        this.kbt = i2;
        this.kbn = i2 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kbs;
        long cER = cER();
        int i = this.kbr;
        int z = z(cER, i);
        if (cER < this.kbn) {
            return a(atomicReferenceArray, t, cER, z);
        }
        int i2 = this.kbq;
        if (a(atomicReferenceArray, z(i2 + cER, i)) == null) {
            this.kbn = (i2 + cER) - 1;
            return a(atomicReferenceArray, t, cER, z);
        } else if (a(atomicReferenceArray, z(1 + cER, i)) == null) {
            return a(atomicReferenceArray, t, cER, z);
        } else {
            a(atomicReferenceArray, cER, z, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        a(atomicReferenceArray, i, t);
        eq(1 + j);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kbs = atomicReferenceArray2;
        this.kbn = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, kbv);
        eq(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Dt(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, Dt(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kbu;
        long cES = cES();
        int i = this.kbt;
        int z = z(cES, i);
        T t = (T) a(atomicReferenceArray, z);
        boolean z2 = t == kbv;
        if (t != null && !z2) {
            a(atomicReferenceArray, z, (Object) null);
            er(1 + cES);
            return t;
        } else if (z2) {
            return a(a(atomicReferenceArray), cES, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.kbu = atomicReferenceArray;
        int z = z(j, i);
        T t = (T) a(atomicReferenceArray, z);
        if (t == null) {
            return null;
        }
        a(atomicReferenceArray, z, (Object) null);
        er(1 + j);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kbu;
        long cES = cES();
        int i = this.kbt;
        T t = (T) a(atomicReferenceArray, z(cES, i));
        if (t == kbv) {
            return b(a(atomicReferenceArray), cES, i);
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
        this.kbu = atomicReferenceArray;
        return (T) a(atomicReferenceArray, z(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cEP = cEP();
        while (true) {
            long cEQ = cEQ();
            long cEP2 = cEP();
            if (cEP == cEP2) {
                return (int) (cEQ - cEP2);
            }
            cEP = cEP2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cEQ() == cEP();
    }

    private void Ds(int i) {
        this.kbq = Math.min(i / 4, kbp);
    }

    private long cEQ() {
        return this.producerIndex.get();
    }

    private long cEP() {
        return this.consumerIndex.get();
    }

    private long cER() {
        return this.producerIndex.get();
    }

    private long cES() {
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

    public boolean l(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kbs;
        long cEQ = cEQ();
        int i = this.kbr;
        if (a(atomicReferenceArray, z(cEQ + 2, i)) == null) {
            int z = z(cEQ, i);
            a(atomicReferenceArray, z + 1, t2);
            a(atomicReferenceArray, z, t);
            eq(cEQ + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kbs = atomicReferenceArray2;
        int z2 = z(cEQ, i);
        a(atomicReferenceArray2, z2 + 1, t2);
        a(atomicReferenceArray2, z2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, z2, kbv);
        eq(cEQ + 2);
        return true;
    }
}
