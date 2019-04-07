package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class f<T> implements Queue<T> {
    static final int kaH = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kaN = new Object();
    final AtomicLong consumerIndex;
    long kaF;
    int kaI;
    int kaJ;
    AtomicReferenceArray<Object> kaK;
    int kaL;
    AtomicReferenceArray<Object> kaM;
    final AtomicLong producerIndex;

    public f(int i) {
        int Dk = h.Dk(Math.max(8, i));
        int i2 = Dk - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Dk + 1);
        this.kaK = atomicReferenceArray;
        this.kaJ = i2;
        Di(Dk);
        this.kaM = atomicReferenceArray;
        this.kaL = i2;
        this.kaF = i2 - 1;
        ep(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.kaK;
        long cEG = cEG();
        int i = this.kaJ;
        int z = z(cEG, i);
        if (cEG < this.kaF) {
            return a(atomicReferenceArray, t, cEG, z);
        }
        int i2 = this.kaI;
        if (a(atomicReferenceArray, z(i2 + cEG, i)) == null) {
            this.kaF = (i2 + cEG) - 1;
            return a(atomicReferenceArray, t, cEG, z);
        } else if (a(atomicReferenceArray, z(1 + cEG, i)) != null) {
            return a(atomicReferenceArray, t, cEG, z);
        } else {
            a(atomicReferenceArray, cEG, z, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        ep(1 + j);
        a(atomicReferenceArray, i, t);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kaK = atomicReferenceArray2;
        this.kaF = (j + j2) - 1;
        ep(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, kaN);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Dj(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, Dj(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kaM;
        long cEH = cEH();
        int i = this.kaL;
        int z = z(cEH, i);
        T t = (T) a(atomicReferenceArray, z);
        boolean z2 = t == kaN;
        if (t != null && !z2) {
            eq(cEH + 1);
            a(atomicReferenceArray, z, (Object) null);
            return t;
        } else if (z2) {
            return a(a(atomicReferenceArray), cEH, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.kaM = atomicReferenceArray;
        int z = z(j, i);
        T t = (T) a(atomicReferenceArray, z);
        if (t == null) {
            return null;
        }
        eq(1 + j);
        a(atomicReferenceArray, z, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kaM;
        long cEH = cEH();
        int i = this.kaL;
        T t = (T) a(atomicReferenceArray, z(cEH, i));
        if (t == kaN) {
            return b(a(atomicReferenceArray), cEH, i);
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
        this.kaM = atomicReferenceArray;
        return (T) a(atomicReferenceArray, z(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cEE = cEE();
        while (true) {
            long cEF = cEF();
            long cEE2 = cEE();
            if (cEE == cEE2) {
                return (int) (cEF - cEE2);
            }
            cEE = cEE2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cEF() == cEE();
    }

    private void Di(int i) {
        this.kaI = Math.min(i / 4, kaH);
    }

    private long cEF() {
        return this.producerIndex.get();
    }

    private long cEE() {
        return this.consumerIndex.get();
    }

    private long cEG() {
        return this.producerIndex.get();
    }

    private long cEH() {
        return this.consumerIndex.get();
    }

    private void ep(long j) {
        this.producerIndex.lazySet(j);
    }

    private void eq(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int z(long j, int i) {
        return Dj(((int) j) & i);
    }

    private static int Dj(int i) {
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
