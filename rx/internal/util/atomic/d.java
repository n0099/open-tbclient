package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class d<T> implements Queue<T> {
    static final int kaI = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kaO = new Object();
    final AtomicLong consumerIndex;
    long kaG;
    int kaJ;
    int kaK;
    AtomicReferenceArray<Object> kaL;
    int kaM;
    AtomicReferenceArray<Object> kaN;
    final AtomicLong producerIndex;

    public d(int i) {
        int Dk = h.Dk(i);
        int i2 = Dk - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Dk + 1);
        this.kaL = atomicReferenceArray;
        this.kaK = i2;
        Di(Dk);
        this.kaN = atomicReferenceArray;
        this.kaM = i2;
        this.kaG = i2 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kaL;
        long cEG = cEG();
        int i = this.kaK;
        int z = z(cEG, i);
        if (cEG < this.kaG) {
            return a(atomicReferenceArray, t, cEG, z);
        }
        int i2 = this.kaJ;
        if (a(atomicReferenceArray, z(i2 + cEG, i)) == null) {
            this.kaG = (i2 + cEG) - 1;
            return a(atomicReferenceArray, t, cEG, z);
        } else if (a(atomicReferenceArray, z(1 + cEG, i)) == null) {
            return a(atomicReferenceArray, t, cEG, z);
        } else {
            a(atomicReferenceArray, cEG, z, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        a(atomicReferenceArray, i, t);
        ep(1 + j);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kaL = atomicReferenceArray2;
        this.kaG = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, kaO);
        ep(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Dj(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, Dj(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kaN;
        long cEH = cEH();
        int i = this.kaM;
        int z = z(cEH, i);
        T t = (T) a(atomicReferenceArray, z);
        boolean z2 = t == kaO;
        if (t != null && !z2) {
            a(atomicReferenceArray, z, (Object) null);
            eq(1 + cEH);
            return t;
        } else if (z2) {
            return a(a(atomicReferenceArray), cEH, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.kaN = atomicReferenceArray;
        int z = z(j, i);
        T t = (T) a(atomicReferenceArray, z);
        if (t == null) {
            return null;
        }
        a(atomicReferenceArray, z, (Object) null);
        eq(1 + j);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kaN;
        long cEH = cEH();
        int i = this.kaM;
        T t = (T) a(atomicReferenceArray, z(cEH, i));
        if (t == kaO) {
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
        this.kaN = atomicReferenceArray;
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
        this.kaJ = Math.min(i / 4, kaI);
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

    public boolean l(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kaL;
        long cEF = cEF();
        int i = this.kaK;
        if (a(atomicReferenceArray, z(cEF + 2, i)) == null) {
            int z = z(cEF, i);
            a(atomicReferenceArray, z + 1, t2);
            a(atomicReferenceArray, z, t);
            ep(cEF + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kaL = atomicReferenceArray2;
        int z2 = z(cEF, i);
        a(atomicReferenceArray2, z2 + 1, t2);
        a(atomicReferenceArray2, z2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, z2, kaO);
        ep(cEF + 2);
        return true;
    }
}
