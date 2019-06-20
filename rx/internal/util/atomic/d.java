package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class d<T> implements Queue<T> {
    static final int ktb = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kth = new Object();
    final AtomicLong consumerIndex;
    long ksZ;
    int ktc;
    int ktd;
    AtomicReferenceArray<Object> kte;
    int ktf;
    AtomicReferenceArray<Object> ktg;
    final AtomicLong producerIndex;

    public d(int i) {
        int Em = h.Em(i);
        int i2 = Em - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Em + 1);
        this.kte = atomicReferenceArray;
        this.ktd = i2;
        Ek(Em);
        this.ktg = atomicReferenceArray;
        this.ktf = i2;
        this.ksZ = i2 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kte;
        long cMn = cMn();
        int i = this.ktd;
        int x = x(cMn, i);
        if (cMn < this.ksZ) {
            return a(atomicReferenceArray, t, cMn, x);
        }
        int i2 = this.ktc;
        if (a(atomicReferenceArray, x(i2 + cMn, i)) == null) {
            this.ksZ = (i2 + cMn) - 1;
            return a(atomicReferenceArray, t, cMn, x);
        } else if (a(atomicReferenceArray, x(1 + cMn, i)) == null) {
            return a(atomicReferenceArray, t, cMn, x);
        } else {
            a(atomicReferenceArray, cMn, x, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        a(atomicReferenceArray, i, t);
        eO(1 + j);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kte = atomicReferenceArray2;
        this.ksZ = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, kth);
        eO(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, El(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, El(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.ktg;
        long cMo = cMo();
        int i = this.ktf;
        int x = x(cMo, i);
        T t = (T) a(atomicReferenceArray, x);
        boolean z = t == kth;
        if (t != null && !z) {
            a(atomicReferenceArray, x, (Object) null);
            eP(1 + cMo);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), cMo, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.ktg = atomicReferenceArray;
        int x = x(j, i);
        T t = (T) a(atomicReferenceArray, x);
        if (t == null) {
            return null;
        }
        a(atomicReferenceArray, x, (Object) null);
        eP(1 + j);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.ktg;
        long cMo = cMo();
        int i = this.ktf;
        T t = (T) a(atomicReferenceArray, x(cMo, i));
        if (t == kth) {
            return b(a(atomicReferenceArray), cMo, i);
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
        this.ktg = atomicReferenceArray;
        return (T) a(atomicReferenceArray, x(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cMl = cMl();
        while (true) {
            long cMm = cMm();
            long cMl2 = cMl();
            if (cMl == cMl2) {
                return (int) (cMm - cMl2);
            }
            cMl = cMl2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cMm() == cMl();
    }

    private void Ek(int i) {
        this.ktc = Math.min(i / 4, ktb);
    }

    private long cMm() {
        return this.producerIndex.get();
    }

    private long cMl() {
        return this.consumerIndex.get();
    }

    private long cMn() {
        return this.producerIndex.get();
    }

    private long cMo() {
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

    public boolean l(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kte;
        long cMm = cMm();
        int i = this.ktd;
        if (a(atomicReferenceArray, x(cMm + 2, i)) == null) {
            int x = x(cMm, i);
            a(atomicReferenceArray, x + 1, t2);
            a(atomicReferenceArray, x, t);
            eO(cMm + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kte = atomicReferenceArray2;
        int x2 = x(cMm, i);
        a(atomicReferenceArray2, x2 + 1, t2);
        a(atomicReferenceArray2, x2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, x2, kth);
        eO(cMm + 2);
        return true;
    }
}
