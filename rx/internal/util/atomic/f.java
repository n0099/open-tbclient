package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class f<T> implements Queue<T> {
    static final int iMp = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object iMv = new Object();
    final AtomicLong consumerIndex;
    long iMn;
    int iMq;
    int iMr;
    AtomicReferenceArray<Object> iMs;
    int iMt;
    AtomicReferenceArray<Object> iMu;
    final AtomicLong producerIndex;

    public f(int i) {
        int zt = h.zt(Math.max(8, i));
        int i2 = zt - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(zt + 1);
        this.iMs = atomicReferenceArray;
        this.iMr = i2;
        zr(zt);
        this.iMu = atomicReferenceArray;
        this.iMt = i2;
        this.iMn = i2 - 1;
        dO(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.iMs;
        long ceD = ceD();
        int i = this.iMr;
        int u = u(ceD, i);
        if (ceD < this.iMn) {
            return a(atomicReferenceArray, t, ceD, u);
        }
        int i2 = this.iMq;
        if (a(atomicReferenceArray, u(i2 + ceD, i)) == null) {
            this.iMn = (i2 + ceD) - 1;
            return a(atomicReferenceArray, t, ceD, u);
        } else if (a(atomicReferenceArray, u(1 + ceD, i)) != null) {
            return a(atomicReferenceArray, t, ceD, u);
        } else {
            a(atomicReferenceArray, ceD, u, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        dO(1 + j);
        a(atomicReferenceArray, i, t);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.iMs = atomicReferenceArray2;
        this.iMn = (j + j2) - 1;
        dO(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, iMv);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, zs(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, zs(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.iMu;
        long ceE = ceE();
        int i = this.iMt;
        int u = u(ceE, i);
        T t = (T) a(atomicReferenceArray, u);
        boolean z = t == iMv;
        if (t != null && !z) {
            dP(ceE + 1);
            a(atomicReferenceArray, u, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), ceE, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.iMu = atomicReferenceArray;
        int u = u(j, i);
        T t = (T) a(atomicReferenceArray, u);
        if (t == null) {
            return null;
        }
        dP(1 + j);
        a(atomicReferenceArray, u, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.iMu;
        long ceE = ceE();
        int i = this.iMt;
        T t = (T) a(atomicReferenceArray, u(ceE, i));
        if (t == iMv) {
            return b(a(atomicReferenceArray), ceE, i);
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
        this.iMu = atomicReferenceArray;
        return (T) a(atomicReferenceArray, u(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long ceB = ceB();
        while (true) {
            long ceC = ceC();
            long ceB2 = ceB();
            if (ceB == ceB2) {
                return (int) (ceC - ceB2);
            }
            ceB = ceB2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return ceC() == ceB();
    }

    private void zr(int i) {
        this.iMq = Math.min(i / 4, iMp);
    }

    private long ceC() {
        return this.producerIndex.get();
    }

    private long ceB() {
        return this.consumerIndex.get();
    }

    private long ceD() {
        return this.producerIndex.get();
    }

    private long ceE() {
        return this.consumerIndex.get();
    }

    private void dO(long j) {
        this.producerIndex.lazySet(j);
    }

    private void dP(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int u(long j, int i) {
        return zs(((int) j) & i);
    }

    private static int zs(int i) {
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
