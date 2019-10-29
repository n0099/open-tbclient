package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class d<T> implements Queue<T> {
    static final int kEF = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kEL = new Object();
    final AtomicLong consumerIndex;
    long kED;
    int kEG;
    int kEH;
    AtomicReferenceArray<Object> kEI;
    int kEJ;
    AtomicReferenceArray<Object> kEK;
    final AtomicLong producerIndex;

    public d(int i) {
        int Dy = h.Dy(i);
        int i2 = Dy - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Dy + 1);
        this.kEI = atomicReferenceArray;
        this.kEH = i2;
        Dw(Dy);
        this.kEK = atomicReferenceArray;
        this.kEJ = i2;
        this.kED = i2 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kEI;
        long cPp = cPp();
        int i = this.kEH;
        int y = y(cPp, i);
        if (cPp < this.kED) {
            return a(atomicReferenceArray, t, cPp, y);
        }
        int i2 = this.kEG;
        if (a(atomicReferenceArray, y(i2 + cPp, i)) == null) {
            this.kED = (i2 + cPp) - 1;
            return a(atomicReferenceArray, t, cPp, y);
        } else if (a(atomicReferenceArray, y(1 + cPp, i)) == null) {
            return a(atomicReferenceArray, t, cPp, y);
        } else {
            a(atomicReferenceArray, cPp, y, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        a(atomicReferenceArray, i, t);
        ev(1 + j);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kEI = atomicReferenceArray2;
        this.kED = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, kEL);
        ev(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Dx(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, Dx(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kEK;
        long cPq = cPq();
        int i = this.kEJ;
        int y = y(cPq, i);
        T t = (T) a(atomicReferenceArray, y);
        boolean z = t == kEL;
        if (t != null && !z) {
            a(atomicReferenceArray, y, (Object) null);
            ew(1 + cPq);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), cPq, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.kEK = atomicReferenceArray;
        int y = y(j, i);
        T t = (T) a(atomicReferenceArray, y);
        if (t == null) {
            return null;
        }
        a(atomicReferenceArray, y, (Object) null);
        ew(1 + j);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kEK;
        long cPq = cPq();
        int i = this.kEJ;
        T t = (T) a(atomicReferenceArray, y(cPq, i));
        if (t == kEL) {
            return b(a(atomicReferenceArray), cPq, i);
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
        this.kEK = atomicReferenceArray;
        return (T) a(atomicReferenceArray, y(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cPn = cPn();
        while (true) {
            long cPo = cPo();
            long cPn2 = cPn();
            if (cPn == cPn2) {
                return (int) (cPo - cPn2);
            }
            cPn = cPn2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cPo() == cPn();
    }

    private void Dw(int i) {
        this.kEG = Math.min(i / 4, kEF);
    }

    private long cPo() {
        return this.producerIndex.get();
    }

    private long cPn() {
        return this.consumerIndex.get();
    }

    private long cPp() {
        return this.producerIndex.get();
    }

    private long cPq() {
        return this.consumerIndex.get();
    }

    private void ev(long j) {
        this.producerIndex.lazySet(j);
    }

    private void ew(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int y(long j, int i) {
        return Dx(((int) j) & i);
    }

    private static int Dx(int i) {
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.kEI;
        long cPo = cPo();
        int i = this.kEH;
        if (a(atomicReferenceArray, y(cPo + 2, i)) == null) {
            int y = y(cPo, i);
            a(atomicReferenceArray, y + 1, t2);
            a(atomicReferenceArray, y, t);
            ev(cPo + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kEI = atomicReferenceArray2;
        int y2 = y(cPo, i);
        a(atomicReferenceArray2, y2 + 1, t2);
        a(atomicReferenceArray2, y2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, y2, kEL);
        ev(cPo + 2);
        return true;
    }
}
