package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class d<T> implements Queue<T> {
    static final int iQH = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object iQN = new Object();
    final AtomicLong consumerIndex;
    long iQF;
    int iQI;
    int iQJ;
    AtomicReferenceArray<Object> iQK;
    int iQL;
    AtomicReferenceArray<Object> iQM;
    final AtomicLong producerIndex;

    public d(int i) {
        int zI = h.zI(i);
        int i2 = zI - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(zI + 1);
        this.iQK = atomicReferenceArray;
        this.iQJ = i2;
        zG(zI);
        this.iQM = atomicReferenceArray;
        this.iQL = i2;
        this.iQF = i2 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.iQK;
        long cgb = cgb();
        int i = this.iQJ;
        int u = u(cgb, i);
        if (cgb < this.iQF) {
            return a(atomicReferenceArray, t, cgb, u);
        }
        int i2 = this.iQI;
        if (a(atomicReferenceArray, u(i2 + cgb, i)) == null) {
            this.iQF = (i2 + cgb) - 1;
            return a(atomicReferenceArray, t, cgb, u);
        } else if (a(atomicReferenceArray, u(1 + cgb, i)) == null) {
            return a(atomicReferenceArray, t, cgb, u);
        } else {
            a(atomicReferenceArray, cgb, u, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        a(atomicReferenceArray, i, t);
        dT(1 + j);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.iQK = atomicReferenceArray2;
        this.iQF = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, iQN);
        dT(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, zH(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, zH(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.iQM;
        long cgc = cgc();
        int i = this.iQL;
        int u = u(cgc, i);
        T t = (T) a(atomicReferenceArray, u);
        boolean z = t == iQN;
        if (t != null && !z) {
            a(atomicReferenceArray, u, (Object) null);
            dU(1 + cgc);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), cgc, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.iQM = atomicReferenceArray;
        int u = u(j, i);
        T t = (T) a(atomicReferenceArray, u);
        if (t == null) {
            return null;
        }
        a(atomicReferenceArray, u, (Object) null);
        dU(1 + j);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.iQM;
        long cgc = cgc();
        int i = this.iQL;
        T t = (T) a(atomicReferenceArray, u(cgc, i));
        if (t == iQN) {
            return b(a(atomicReferenceArray), cgc, i);
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
        this.iQM = atomicReferenceArray;
        return (T) a(atomicReferenceArray, u(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cfZ = cfZ();
        while (true) {
            long cga = cga();
            long cfZ2 = cfZ();
            if (cfZ == cfZ2) {
                return (int) (cga - cfZ2);
            }
            cfZ = cfZ2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cga() == cfZ();
    }

    private void zG(int i) {
        this.iQI = Math.min(i / 4, iQH);
    }

    private long cga() {
        return this.producerIndex.get();
    }

    private long cfZ() {
        return this.consumerIndex.get();
    }

    private long cgb() {
        return this.producerIndex.get();
    }

    private long cgc() {
        return this.consumerIndex.get();
    }

    private void dT(long j) {
        this.producerIndex.lazySet(j);
    }

    private void dU(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int u(long j, int i) {
        return zH(((int) j) & i);
    }

    private static int zH(int i) {
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.iQK;
        long cga = cga();
        int i = this.iQJ;
        if (a(atomicReferenceArray, u(cga + 2, i)) == null) {
            int u = u(cga, i);
            a(atomicReferenceArray, u + 1, t2);
            a(atomicReferenceArray, u, t);
            dT(cga + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.iQK = atomicReferenceArray2;
        int u2 = u(cga, i);
        a(atomicReferenceArray2, u2 + 1, t2);
        a(atomicReferenceArray2, u2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, u2, iQN);
        dT(cga + 2);
        return true;
    }
}
