package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class f<T> implements Queue<T> {
    static final int iFi = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object iFo = new Object();
    final AtomicLong consumerIndex;
    long iFg;
    int iFj;
    int iFk;
    AtomicReferenceArray<Object> iFl;
    int iFm;
    AtomicReferenceArray<Object> iFn;
    final AtomicLong producerIndex;

    public f(int i) {
        int yX = h.yX(Math.max(8, i));
        int i2 = yX - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(yX + 1);
        this.iFl = atomicReferenceArray;
        this.iFk = i2;
        yV(yX);
        this.iFn = atomicReferenceArray;
        this.iFm = i2;
        this.iFg = i2 - 1;
        dH(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.iFl;
        long ccA = ccA();
        int i = this.iFk;
        int u = u(ccA, i);
        if (ccA < this.iFg) {
            return a(atomicReferenceArray, t, ccA, u);
        }
        int i2 = this.iFj;
        if (a(atomicReferenceArray, u(i2 + ccA, i)) == null) {
            this.iFg = (i2 + ccA) - 1;
            return a(atomicReferenceArray, t, ccA, u);
        } else if (a(atomicReferenceArray, u(1 + ccA, i)) != null) {
            return a(atomicReferenceArray, t, ccA, u);
        } else {
            a(atomicReferenceArray, ccA, u, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        dH(1 + j);
        a(atomicReferenceArray, i, t);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.iFl = atomicReferenceArray2;
        this.iFg = (j + j2) - 1;
        dH(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, iFo);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, yW(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, yW(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.iFn;
        long ccB = ccB();
        int i = this.iFm;
        int u = u(ccB, i);
        T t = (T) a(atomicReferenceArray, u);
        boolean z = t == iFo;
        if (t != null && !z) {
            dI(ccB + 1);
            a(atomicReferenceArray, u, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), ccB, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.iFn = atomicReferenceArray;
        int u = u(j, i);
        T t = (T) a(atomicReferenceArray, u);
        if (t == null) {
            return null;
        }
        dI(1 + j);
        a(atomicReferenceArray, u, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.iFn;
        long ccB = ccB();
        int i = this.iFm;
        T t = (T) a(atomicReferenceArray, u(ccB, i));
        if (t == iFo) {
            return b(a(atomicReferenceArray), ccB, i);
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
        this.iFn = atomicReferenceArray;
        return (T) a(atomicReferenceArray, u(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long ccy = ccy();
        while (true) {
            long ccz = ccz();
            long ccy2 = ccy();
            if (ccy == ccy2) {
                return (int) (ccz - ccy2);
            }
            ccy = ccy2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return ccz() == ccy();
    }

    private void yV(int i) {
        this.iFj = Math.min(i / 4, iFi);
    }

    private long ccz() {
        return this.producerIndex.get();
    }

    private long ccy() {
        return this.consumerIndex.get();
    }

    private long ccA() {
        return this.producerIndex.get();
    }

    private long ccB() {
        return this.consumerIndex.get();
    }

    private void dH(long j) {
        this.producerIndex.lazySet(j);
    }

    private void dI(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int u(long j, int i) {
        return yW(((int) j) & i);
    }

    private static int yW(int i) {
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
