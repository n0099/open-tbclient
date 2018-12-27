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
    int iPA;
    int iPB;
    AtomicReferenceArray<Object> iPC;
    int iPD;
    AtomicReferenceArray<Object> iPE;
    long iPx;
    final AtomicLong producerIndex;
    static final int iPz = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object iPF = new Object();

    public f(int i) {
        int zG = h.zG(Math.max(8, i));
        int i2 = zG - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(zG + 1);
        this.iPC = atomicReferenceArray;
        this.iPB = i2;
        zE(zG);
        this.iPE = atomicReferenceArray;
        this.iPD = i2;
        this.iPx = i2 - 1;
        dT(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.iPC;
        long cft = cft();
        int i = this.iPB;
        int u = u(cft, i);
        if (cft < this.iPx) {
            return a(atomicReferenceArray, t, cft, u);
        }
        int i2 = this.iPA;
        if (a(atomicReferenceArray, u(i2 + cft, i)) == null) {
            this.iPx = (i2 + cft) - 1;
            return a(atomicReferenceArray, t, cft, u);
        } else if (a(atomicReferenceArray, u(1 + cft, i)) != null) {
            return a(atomicReferenceArray, t, cft, u);
        } else {
            a(atomicReferenceArray, cft, u, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        dT(1 + j);
        a(atomicReferenceArray, i, t);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.iPC = atomicReferenceArray2;
        this.iPx = (j + j2) - 1;
        dT(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, iPF);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, zF(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, zF(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.iPE;
        long cfu = cfu();
        int i = this.iPD;
        int u = u(cfu, i);
        T t = (T) a(atomicReferenceArray, u);
        boolean z = t == iPF;
        if (t != null && !z) {
            dU(cfu + 1);
            a(atomicReferenceArray, u, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), cfu, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.iPE = atomicReferenceArray;
        int u = u(j, i);
        T t = (T) a(atomicReferenceArray, u);
        if (t == null) {
            return null;
        }
        dU(1 + j);
        a(atomicReferenceArray, u, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.iPE;
        long cfu = cfu();
        int i = this.iPD;
        T t = (T) a(atomicReferenceArray, u(cfu, i));
        if (t == iPF) {
            return b(a(atomicReferenceArray), cfu, i);
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
        this.iPE = atomicReferenceArray;
        return (T) a(atomicReferenceArray, u(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cfr = cfr();
        while (true) {
            long cfs = cfs();
            long cfr2 = cfr();
            if (cfr == cfr2) {
                return (int) (cfs - cfr2);
            }
            cfr = cfr2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cfs() == cfr();
    }

    private void zE(int i) {
        this.iPA = Math.min(i / 4, iPz);
    }

    private long cfs() {
        return this.producerIndex.get();
    }

    private long cfr() {
        return this.consumerIndex.get();
    }

    private long cft() {
        return this.producerIndex.get();
    }

    private long cfu() {
        return this.consumerIndex.get();
    }

    private void dT(long j) {
        this.producerIndex.lazySet(j);
    }

    private void dU(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int u(long j, int i) {
        return zF(((int) j) & i);
    }

    private static int zF(int i) {
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
