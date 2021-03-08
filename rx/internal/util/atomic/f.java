package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes4.dex */
public final class f<T> implements Queue<T> {
    static final int qrn = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qrt = new Object();
    final AtomicLong consumerIndex;
    final AtomicLong producerIndex;
    long producerLookAhead;
    int qro;
    int qrp;
    AtomicReferenceArray<Object> qrq;
    int qrr;
    AtomicReferenceArray<Object> qrs;

    public f(int i) {
        int So = h.So(Math.max(8, i));
        int i2 = So - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(So + 1);
        this.qrq = atomicReferenceArray;
        this.qrp = i2;
        Sl(So);
        this.qrs = atomicReferenceArray;
        this.qrr = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.qrq;
        long eKm = eKm();
        int i = this.qrp;
        int O = O(eKm, i);
        if (eKm < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eKm, O);
        }
        int i2 = this.qro;
        if (b(atomicReferenceArray, O(i2 + eKm, i)) == null) {
            this.producerLookAhead = (i2 + eKm) - 1;
            return a(atomicReferenceArray, t, eKm, O);
        } else if (b(atomicReferenceArray, O(1 + eKm, i)) != null) {
            return a(atomicReferenceArray, t, eKm, O);
        } else {
            a(atomicReferenceArray, eKm, O, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        soProducerIndex(1 + j);
        a(atomicReferenceArray, i, t);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.qrq = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, qrt);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Sm(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, Sm(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qrs;
        long eKn = eKn();
        int i = this.qrr;
        int O = O(eKn, i);
        T t = (T) b(atomicReferenceArray, O);
        boolean z = t == qrt;
        if (t != null && !z) {
            soConsumerIndex(eKn + 1);
            a(atomicReferenceArray, O, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), eKn, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qrs = atomicReferenceArray;
        int O = O(j, i);
        T t = (T) b(atomicReferenceArray, O);
        if (t == null) {
            return null;
        }
        soConsumerIndex(1 + j);
        a(atomicReferenceArray, O, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qrs;
        long eKn = eKn();
        int i = this.qrr;
        T t = (T) b(atomicReferenceArray, O(eKn, i));
        if (t == qrt) {
            return b(a(atomicReferenceArray), eKn, i);
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
        this.qrs = atomicReferenceArray;
        return (T) b(atomicReferenceArray, O(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long eKl = eKl();
        while (true) {
            long eKk = eKk();
            long eKl2 = eKl();
            if (eKl == eKl2) {
                return (int) (eKk - eKl2);
            }
            eKl = eKl2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return eKk() == eKl();
    }

    private void Sl(int i) {
        this.qro = Math.min(i / 4, qrn);
    }

    private long eKk() {
        return this.producerIndex.get();
    }

    private long eKl() {
        return this.consumerIndex.get();
    }

    private long eKm() {
        return this.producerIndex.get();
    }

    private long eKn() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int O(long j, int i) {
        return Sm(((int) j) & i);
    }

    private static int Sm(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
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
