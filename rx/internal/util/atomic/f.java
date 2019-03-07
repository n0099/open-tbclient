package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class f<T> implements Queue<T> {
    static final int kbe = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kbk = new Object();
    final AtomicLong consumerIndex;
    long kbc;
    int kbf;
    int kbg;
    AtomicReferenceArray<Object> kbh;
    int kbi;
    AtomicReferenceArray<Object> kbj;
    final AtomicLong producerIndex;

    public f(int i) {
        int Dt = h.Dt(Math.max(8, i));
        int i2 = Dt - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Dt + 1);
        this.kbh = atomicReferenceArray;
        this.kbg = i2;
        Dr(Dt);
        this.kbj = atomicReferenceArray;
        this.kbi = i2;
        this.kbc = i2 - 1;
        eq(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.kbh;
        long cEE = cEE();
        int i = this.kbg;
        int z = z(cEE, i);
        if (cEE < this.kbc) {
            return a(atomicReferenceArray, t, cEE, z);
        }
        int i2 = this.kbf;
        if (a(atomicReferenceArray, z(i2 + cEE, i)) == null) {
            this.kbc = (i2 + cEE) - 1;
            return a(atomicReferenceArray, t, cEE, z);
        } else if (a(atomicReferenceArray, z(1 + cEE, i)) != null) {
            return a(atomicReferenceArray, t, cEE, z);
        } else {
            a(atomicReferenceArray, cEE, z, t, i);
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
        this.kbh = atomicReferenceArray2;
        this.kbc = (j + j2) - 1;
        eq(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, kbk);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Ds(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, Ds(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kbj;
        long cEF = cEF();
        int i = this.kbi;
        int z = z(cEF, i);
        T t = (T) a(atomicReferenceArray, z);
        boolean z2 = t == kbk;
        if (t != null && !z2) {
            er(cEF + 1);
            a(atomicReferenceArray, z, (Object) null);
            return t;
        } else if (z2) {
            return a(a(atomicReferenceArray), cEF, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.kbj = atomicReferenceArray;
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.kbj;
        long cEF = cEF();
        int i = this.kbi;
        T t = (T) a(atomicReferenceArray, z(cEF, i));
        if (t == kbk) {
            return b(a(atomicReferenceArray), cEF, i);
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
        this.kbj = atomicReferenceArray;
        return (T) a(atomicReferenceArray, z(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cEC = cEC();
        while (true) {
            long cED = cED();
            long cEC2 = cEC();
            if (cEC == cEC2) {
                return (int) (cED - cEC2);
            }
            cEC = cEC2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cED() == cEC();
    }

    private void Dr(int i) {
        this.kbf = Math.min(i / 4, kbe);
    }

    private long cED() {
        return this.producerIndex.get();
    }

    private long cEC() {
        return this.consumerIndex.get();
    }

    private long cEE() {
        return this.producerIndex.get();
    }

    private long cEF() {
        return this.consumerIndex.get();
    }

    private void eq(long j) {
        this.producerIndex.lazySet(j);
    }

    private void er(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int z(long j, int i) {
        return Ds(((int) j) & i);
    }

    private static int Ds(int i) {
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
