package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class d<T> implements Queue<T> {
    static final int kDO = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kDU = new Object();
    final AtomicLong consumerIndex;
    long kDM;
    int kDP;
    int kDQ;
    AtomicReferenceArray<Object> kDR;
    int kDS;
    AtomicReferenceArray<Object> kDT;
    final AtomicLong producerIndex;

    public d(int i) {
        int Dx = h.Dx(i);
        int i2 = Dx - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Dx + 1);
        this.kDR = atomicReferenceArray;
        this.kDQ = i2;
        Dv(Dx);
        this.kDT = atomicReferenceArray;
        this.kDS = i2;
        this.kDM = i2 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kDR;
        long cPn = cPn();
        int i = this.kDQ;
        int y = y(cPn, i);
        if (cPn < this.kDM) {
            return a(atomicReferenceArray, t, cPn, y);
        }
        int i2 = this.kDP;
        if (a(atomicReferenceArray, y(i2 + cPn, i)) == null) {
            this.kDM = (i2 + cPn) - 1;
            return a(atomicReferenceArray, t, cPn, y);
        } else if (a(atomicReferenceArray, y(1 + cPn, i)) == null) {
            return a(atomicReferenceArray, t, cPn, y);
        } else {
            a(atomicReferenceArray, cPn, y, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        a(atomicReferenceArray, i, t);
        eu(1 + j);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kDR = atomicReferenceArray2;
        this.kDM = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, kDU);
        eu(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Dw(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, Dw(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kDT;
        long cPo = cPo();
        int i = this.kDS;
        int y = y(cPo, i);
        T t = (T) a(atomicReferenceArray, y);
        boolean z = t == kDU;
        if (t != null && !z) {
            a(atomicReferenceArray, y, (Object) null);
            ev(1 + cPo);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), cPo, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.kDT = atomicReferenceArray;
        int y = y(j, i);
        T t = (T) a(atomicReferenceArray, y);
        if (t == null) {
            return null;
        }
        a(atomicReferenceArray, y, (Object) null);
        ev(1 + j);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kDT;
        long cPo = cPo();
        int i = this.kDS;
        T t = (T) a(atomicReferenceArray, y(cPo, i));
        if (t == kDU) {
            return b(a(atomicReferenceArray), cPo, i);
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
        this.kDT = atomicReferenceArray;
        return (T) a(atomicReferenceArray, y(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cPl = cPl();
        while (true) {
            long cPm = cPm();
            long cPl2 = cPl();
            if (cPl == cPl2) {
                return (int) (cPm - cPl2);
            }
            cPl = cPl2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cPm() == cPl();
    }

    private void Dv(int i) {
        this.kDP = Math.min(i / 4, kDO);
    }

    private long cPm() {
        return this.producerIndex.get();
    }

    private long cPl() {
        return this.consumerIndex.get();
    }

    private long cPn() {
        return this.producerIndex.get();
    }

    private long cPo() {
        return this.consumerIndex.get();
    }

    private void eu(long j) {
        this.producerIndex.lazySet(j);
    }

    private void ev(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int y(long j, int i) {
        return Dw(((int) j) & i);
    }

    private static int Dw(int i) {
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

    public boolean j(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kDR;
        long cPm = cPm();
        int i = this.kDQ;
        if (a(atomicReferenceArray, y(cPm + 2, i)) == null) {
            int y = y(cPm, i);
            a(atomicReferenceArray, y + 1, t2);
            a(atomicReferenceArray, y, t);
            eu(cPm + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kDR = atomicReferenceArray2;
        int y2 = y(cPm, i);
        a(atomicReferenceArray2, y2 + 1, t2);
        a(atomicReferenceArray2, y2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, y2, kDU);
        eu(cPm + 2);
        return true;
    }
}
