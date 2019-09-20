package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class f<T> implements Queue<T> {
    static final int kDY = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kEe = new Object();
    final AtomicLong consumerIndex;
    long kDW;
    int kDZ;
    int kEa;
    AtomicReferenceArray<Object> kEb;
    int kEc;
    AtomicReferenceArray<Object> kEd;
    final AtomicLong producerIndex;

    public f(int i) {
        int Fb = h.Fb(Math.max(8, i));
        int i2 = Fb - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Fb + 1);
        this.kEb = atomicReferenceArray;
        this.kEa = i2;
        EZ(Fb);
        this.kEd = atomicReferenceArray;
        this.kEc = i2;
        this.kDW = i2 - 1;
        fa(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.kEb;
        long cRk = cRk();
        int i = this.kEa;
        int x = x(cRk, i);
        if (cRk < this.kDW) {
            return a(atomicReferenceArray, t, cRk, x);
        }
        int i2 = this.kDZ;
        if (a(atomicReferenceArray, x(i2 + cRk, i)) == null) {
            this.kDW = (i2 + cRk) - 1;
            return a(atomicReferenceArray, t, cRk, x);
        } else if (a(atomicReferenceArray, x(1 + cRk, i)) != null) {
            return a(atomicReferenceArray, t, cRk, x);
        } else {
            a(atomicReferenceArray, cRk, x, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        fa(1 + j);
        a(atomicReferenceArray, i, t);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kEb = atomicReferenceArray2;
        this.kDW = (j + j2) - 1;
        fa(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, kEe);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Fa(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, Fa(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kEd;
        long cRl = cRl();
        int i = this.kEc;
        int x = x(cRl, i);
        T t = (T) a(atomicReferenceArray, x);
        boolean z = t == kEe;
        if (t != null && !z) {
            fb(cRl + 1);
            a(atomicReferenceArray, x, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), cRl, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.kEd = atomicReferenceArray;
        int x = x(j, i);
        T t = (T) a(atomicReferenceArray, x);
        if (t == null) {
            return null;
        }
        fb(1 + j);
        a(atomicReferenceArray, x, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kEd;
        long cRl = cRl();
        int i = this.kEc;
        T t = (T) a(atomicReferenceArray, x(cRl, i));
        if (t == kEe) {
            return b(a(atomicReferenceArray), cRl, i);
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
        this.kEd = atomicReferenceArray;
        return (T) a(atomicReferenceArray, x(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cRi = cRi();
        while (true) {
            long cRj = cRj();
            long cRi2 = cRi();
            if (cRi == cRi2) {
                return (int) (cRj - cRi2);
            }
            cRi = cRi2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cRj() == cRi();
    }

    private void EZ(int i) {
        this.kDZ = Math.min(i / 4, kDY);
    }

    private long cRj() {
        return this.producerIndex.get();
    }

    private long cRi() {
        return this.consumerIndex.get();
    }

    private long cRk() {
        return this.producerIndex.get();
    }

    private long cRl() {
        return this.consumerIndex.get();
    }

    private void fa(long j) {
        this.producerIndex.lazySet(j);
    }

    private void fb(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int x(long j, int i) {
        return Fa(((int) j) & i);
    }

    private static int Fa(int i) {
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
