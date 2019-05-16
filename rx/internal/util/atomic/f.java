package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class f<T> implements Queue<T> {
    static final int ksX = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object ktd = new Object();
    final AtomicLong consumerIndex;
    long ksV;
    int ksY;
    int ksZ;
    AtomicReferenceArray<Object> kta;
    int ktb;
    AtomicReferenceArray<Object> ktc;
    final AtomicLong producerIndex;

    public f(int i) {
        int Em = h.Em(Math.max(8, i));
        int i2 = Em - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Em + 1);
        this.kta = atomicReferenceArray;
        this.ksZ = i2;
        Ek(Em);
        this.ktc = atomicReferenceArray;
        this.ktb = i2;
        this.ksV = i2 - 1;
        eO(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.kta;
        long cMm = cMm();
        int i = this.ksZ;
        int x = x(cMm, i);
        if (cMm < this.ksV) {
            return a(atomicReferenceArray, t, cMm, x);
        }
        int i2 = this.ksY;
        if (a(atomicReferenceArray, x(i2 + cMm, i)) == null) {
            this.ksV = (i2 + cMm) - 1;
            return a(atomicReferenceArray, t, cMm, x);
        } else if (a(atomicReferenceArray, x(1 + cMm, i)) != null) {
            return a(atomicReferenceArray, t, cMm, x);
        } else {
            a(atomicReferenceArray, cMm, x, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        eO(1 + j);
        a(atomicReferenceArray, i, t);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kta = atomicReferenceArray2;
        this.ksV = (j + j2) - 1;
        eO(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, ktd);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, El(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, El(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.ktc;
        long cMn = cMn();
        int i = this.ktb;
        int x = x(cMn, i);
        T t = (T) a(atomicReferenceArray, x);
        boolean z = t == ktd;
        if (t != null && !z) {
            eP(cMn + 1);
            a(atomicReferenceArray, x, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), cMn, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.ktc = atomicReferenceArray;
        int x = x(j, i);
        T t = (T) a(atomicReferenceArray, x);
        if (t == null) {
            return null;
        }
        eP(1 + j);
        a(atomicReferenceArray, x, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.ktc;
        long cMn = cMn();
        int i = this.ktb;
        T t = (T) a(atomicReferenceArray, x(cMn, i));
        if (t == ktd) {
            return b(a(atomicReferenceArray), cMn, i);
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
        this.ktc = atomicReferenceArray;
        return (T) a(atomicReferenceArray, x(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cMk = cMk();
        while (true) {
            long cMl = cMl();
            long cMk2 = cMk();
            if (cMk == cMk2) {
                return (int) (cMl - cMk2);
            }
            cMk = cMk2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cMl() == cMk();
    }

    private void Ek(int i) {
        this.ksY = Math.min(i / 4, ksX);
    }

    private long cMl() {
        return this.producerIndex.get();
    }

    private long cMk() {
        return this.consumerIndex.get();
    }

    private long cMm() {
        return this.producerIndex.get();
    }

    private long cMn() {
        return this.consumerIndex.get();
    }

    private void eO(long j) {
        this.producerIndex.lazySet(j);
    }

    private void eP(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int x(long j, int i) {
        return El(((int) j) & i);
    }

    private static int El(int i) {
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
