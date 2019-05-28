package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class f<T> implements Queue<T> {
    static final int ksY = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kte = new Object();
    final AtomicLong consumerIndex;
    long ksW;
    int ksZ;
    int kta;
    AtomicReferenceArray<Object> ktb;
    int ktc;
    AtomicReferenceArray<Object> ktd;
    final AtomicLong producerIndex;

    public f(int i) {
        int Em = h.Em(Math.max(8, i));
        int i2 = Em - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Em + 1);
        this.ktb = atomicReferenceArray;
        this.kta = i2;
        Ek(Em);
        this.ktd = atomicReferenceArray;
        this.ktc = i2;
        this.ksW = i2 - 1;
        eO(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.ktb;
        long cMo = cMo();
        int i = this.kta;
        int x = x(cMo, i);
        if (cMo < this.ksW) {
            return a(atomicReferenceArray, t, cMo, x);
        }
        int i2 = this.ksZ;
        if (a(atomicReferenceArray, x(i2 + cMo, i)) == null) {
            this.ksW = (i2 + cMo) - 1;
            return a(atomicReferenceArray, t, cMo, x);
        } else if (a(atomicReferenceArray, x(1 + cMo, i)) != null) {
            return a(atomicReferenceArray, t, cMo, x);
        } else {
            a(atomicReferenceArray, cMo, x, t, i);
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
        this.ktb = atomicReferenceArray2;
        this.ksW = (j + j2) - 1;
        eO(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, kte);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, El(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, El(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.ktd;
        long cMp = cMp();
        int i = this.ktc;
        int x = x(cMp, i);
        T t = (T) a(atomicReferenceArray, x);
        boolean z = t == kte;
        if (t != null && !z) {
            eP(cMp + 1);
            a(atomicReferenceArray, x, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), cMp, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.ktd = atomicReferenceArray;
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.ktd;
        long cMp = cMp();
        int i = this.ktc;
        T t = (T) a(atomicReferenceArray, x(cMp, i));
        if (t == kte) {
            return b(a(atomicReferenceArray), cMp, i);
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
        this.ktd = atomicReferenceArray;
        return (T) a(atomicReferenceArray, x(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cMm = cMm();
        while (true) {
            long cMn = cMn();
            long cMm2 = cMm();
            if (cMm == cMm2) {
                return (int) (cMn - cMm2);
            }
            cMm = cMm2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cMn() == cMm();
    }

    private void Ek(int i) {
        this.ksZ = Math.min(i / 4, ksY);
    }

    private long cMn() {
        return this.producerIndex.get();
    }

    private long cMm() {
        return this.consumerIndex.get();
    }

    private long cMo() {
        return this.producerIndex.get();
    }

    private long cMp() {
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
