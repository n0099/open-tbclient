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
    AtomicReferenceArray<Object> iDA;
    int iDB;
    AtomicReferenceArray<Object> iDC;
    long iDv;
    int iDy;
    int iDz;
    final AtomicLong producerIndex;
    static final int iDx = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object iDD = new Object();

    public f(int i) {
        int yE = h.yE(Math.max(8, i));
        int i2 = yE - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(yE + 1);
        this.iDA = atomicReferenceArray;
        this.iDz = i2;
        yC(yE);
        this.iDC = atomicReferenceArray;
        this.iDB = i2;
        this.iDv = i2 - 1;
        dM(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.iDA;
        long cdd = cdd();
        int i = this.iDz;
        int u = u(cdd, i);
        if (cdd < this.iDv) {
            return a(atomicReferenceArray, t, cdd, u);
        }
        int i2 = this.iDy;
        if (a(atomicReferenceArray, u(i2 + cdd, i)) == null) {
            this.iDv = (i2 + cdd) - 1;
            return a(atomicReferenceArray, t, cdd, u);
        } else if (a(atomicReferenceArray, u(1 + cdd, i)) != null) {
            return a(atomicReferenceArray, t, cdd, u);
        } else {
            a(atomicReferenceArray, cdd, u, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        dM(1 + j);
        a(atomicReferenceArray, i, t);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.iDA = atomicReferenceArray2;
        this.iDv = (j + j2) - 1;
        dM(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, iDD);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, yD(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, yD(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.iDC;
        long cde = cde();
        int i = this.iDB;
        int u = u(cde, i);
        T t = (T) a(atomicReferenceArray, u);
        boolean z = t == iDD;
        if (t != null && !z) {
            dN(cde + 1);
            a(atomicReferenceArray, u, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), cde, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.iDC = atomicReferenceArray;
        int u = u(j, i);
        T t = (T) a(atomicReferenceArray, u);
        if (t == null) {
            return null;
        }
        dN(1 + j);
        a(atomicReferenceArray, u, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.iDC;
        long cde = cde();
        int i = this.iDB;
        T t = (T) a(atomicReferenceArray, u(cde, i));
        if (t == iDD) {
            return b(a(atomicReferenceArray), cde, i);
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
        this.iDC = atomicReferenceArray;
        return (T) a(atomicReferenceArray, u(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cdb = cdb();
        while (true) {
            long cdc = cdc();
            long cdb2 = cdb();
            if (cdb == cdb2) {
                return (int) (cdc - cdb2);
            }
            cdb = cdb2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cdc() == cdb();
    }

    private void yC(int i) {
        this.iDy = Math.min(i / 4, iDx);
    }

    private long cdc() {
        return this.producerIndex.get();
    }

    private long cdb() {
        return this.consumerIndex.get();
    }

    private long cdd() {
        return this.producerIndex.get();
    }

    private long cde() {
        return this.consumerIndex.get();
    }

    private void dM(long j) {
        this.producerIndex.lazySet(j);
    }

    private void dN(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int u(long j, int i) {
        return yD(((int) j) & i);
    }

    private static int yD(int i) {
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
