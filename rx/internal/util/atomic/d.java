package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
public final class d<T> implements Queue<T> {
    static final int kAA = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kAG = new Object();
    final AtomicLong consumerIndex;
    int kAB;
    int kAC;
    AtomicReferenceArray<Object> kAD;
    int kAE;
    AtomicReferenceArray<Object> kAF;
    long kAy;
    final AtomicLong producerIndex;

    public d(int i) {
        int EV = h.EV(i);
        int i2 = EV - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(EV + 1);
        this.kAD = atomicReferenceArray;
        this.kAC = i2;
        ET(EV);
        this.kAF = atomicReferenceArray;
        this.kAE = i2;
        this.kAy = i2 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kAD;
        long cQd = cQd();
        int i = this.kAC;
        int x = x(cQd, i);
        if (cQd < this.kAy) {
            return a(atomicReferenceArray, t, cQd, x);
        }
        int i2 = this.kAB;
        if (a(atomicReferenceArray, x(i2 + cQd, i)) == null) {
            this.kAy = (i2 + cQd) - 1;
            return a(atomicReferenceArray, t, cQd, x);
        } else if (a(atomicReferenceArray, x(1 + cQd, i)) == null) {
            return a(atomicReferenceArray, t, cQd, x);
        } else {
            a(atomicReferenceArray, cQd, x, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        a(atomicReferenceArray, i, t);
        eX(1 + j);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kAD = atomicReferenceArray2;
        this.kAy = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, kAG);
        eX(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, EU(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) a(atomicReferenceArray, EU(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kAF;
        long cQe = cQe();
        int i = this.kAE;
        int x = x(cQe, i);
        T t = (T) a(atomicReferenceArray, x);
        boolean z = t == kAG;
        if (t != null && !z) {
            a(atomicReferenceArray, x, (Object) null);
            eY(1 + cQe);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), cQe, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.kAF = atomicReferenceArray;
        int x = x(j, i);
        T t = (T) a(atomicReferenceArray, x);
        if (t == null) {
            return null;
        }
        a(atomicReferenceArray, x, (Object) null);
        eY(1 + j);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.kAF;
        long cQe = cQe();
        int i = this.kAE;
        T t = (T) a(atomicReferenceArray, x(cQe, i));
        if (t == kAG) {
            return b(a(atomicReferenceArray), cQe, i);
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
        this.kAF = atomicReferenceArray;
        return (T) a(atomicReferenceArray, x(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long cQb = cQb();
        while (true) {
            long cQc = cQc();
            long cQb2 = cQb();
            if (cQb == cQb2) {
                return (int) (cQc - cQb2);
            }
            cQb = cQb2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return cQc() == cQb();
    }

    private void ET(int i) {
        this.kAB = Math.min(i / 4, kAA);
    }

    private long cQc() {
        return this.producerIndex.get();
    }

    private long cQb() {
        return this.consumerIndex.get();
    }

    private long cQd() {
        return this.producerIndex.get();
    }

    private long cQe() {
        return this.consumerIndex.get();
    }

    private void eX(long j) {
        this.producerIndex.lazySet(j);
    }

    private void eY(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int x(long j, int i) {
        return EU(((int) j) & i);
    }

    private static int EU(int i) {
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.kAD;
        long cQc = cQc();
        int i = this.kAC;
        if (a(atomicReferenceArray, x(cQc + 2, i)) == null) {
            int x = x(cQc, i);
            a(atomicReferenceArray, x + 1, t2);
            a(atomicReferenceArray, x, t);
            eX(cQc + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.kAD = atomicReferenceArray2;
        int x2 = x(cQc, i);
        a(atomicReferenceArray2, x2 + 1, t2);
        a(atomicReferenceArray2, x2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, x2, kAG);
        eX(cQc + 2);
        return true;
    }
}
