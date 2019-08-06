package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class f<T> implements Queue<T> {
    static final int kBG = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kBM = new Object();
    final AtomicLong consumerIndex;
    long kBE;
    int kBH;
    int kBI;
    AtomicReferenceArray<Object> kBJ;
    int kBK;
    AtomicReferenceArray<Object> kBL;
    final AtomicLong producerIndex;

    public f(int i) {
        int EX = h.EX(Math.max(8, i));
        int i2 = EX - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(EX + 1);
        this.kBJ = atomicReferenceArray;
        this.kBI = i2;
        EV(EX);
        this.kBL = atomicReferenceArray;
        this.kBK = i2;
        this.kBE = i2 - 1;
        eX(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.kBJ;
        long cQy = cQy();
        int i = this.kBI;
        int x = x(cQy, i);
        if (cQy < this.kBE) {
            return a(atomicReferenceArray, t, cQy, x);
        }
        int i2 = this.kBH;
        if (a(atomicReferenceArray, x(i2 + cQy, i)) == null) {
            this.kBE = (i2 + cQy) - 1;
            return a(atomicReferenceArray, t, cQy, x);
        } else if (a(atomicReferenceArray, x(1 + cQy, i)) != null) {
            return a(atomicReferenceArray, t, cQy, x);
        } else {
            a(atomicReferenceArray, cQy, x, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        eX(1 + j);
        a(atomicReferenceArray, i, t);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kBJ = atomicReferenceArray2;
        this.kBE = (j + j2) - 1;
        eX(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, kBM);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, EW(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, EW(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kBL;
        long cQz = cQz();
        int i = this.kBK;
        int x = x(cQz, i);
        T t = (T) a(atomicReferenceArray, x);
        boolean z = t == kBM;
        if (t != null && !z) {
            eY(cQz + 1);
            a(atomicReferenceArray, x, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), cQz, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.kBL = atomicReferenceArray;
        int x = x(j, i);
        T t = (T) a(atomicReferenceArray, x);
        if (t == null) {
            return null;
        }
        eY(1 + j);
        a(atomicReferenceArray, x, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kBL;
        long cQz = cQz();
        int i = this.kBK;
        T t = (T) a(atomicReferenceArray, x(cQz, i));
        if (t == kBM) {
            return b(a(atomicReferenceArray), cQz, i);
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
        this.kBL = atomicReferenceArray;
        return (T) a(atomicReferenceArray, x(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cQw = cQw();
        while (true) {
            long cQx = cQx();
            long cQw2 = cQw();
            if (cQw == cQw2) {
                return (int) (cQx - cQw2);
            }
            cQw = cQw2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cQx() == cQw();
    }

    private void EV(int i) {
        this.kBH = Math.min(i / 4, kBG);
    }

    private long cQx() {
        return this.producerIndex.get();
    }

    private long cQw() {
        return this.consumerIndex.get();
    }

    private long cQy() {
        return this.producerIndex.get();
    }

    private long cQz() {
        return this.consumerIndex.get();
    }

    private void eX(long j) {
        this.producerIndex.lazySet(j);
    }

    private void eY(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int x(long j, int i) {
        return EW(((int) j) & i);
    }

    private static int EW(int i) {
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
