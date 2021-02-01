package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes5.dex */
public final class f<T> implements Queue<T> {
    static final int qql = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qqr = new Object();
    final AtomicLong consumerIndex;
    final AtomicLong producerIndex;
    long producerLookAhead;
    int qqm;
    int qqn;
    AtomicReferenceArray<Object> qqo;
    int qqp;
    AtomicReferenceArray<Object> qqq;

    public f(int i) {
        int So = h.So(Math.max(8, i));
        int i2 = So - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(So + 1);
        this.qqo = atomicReferenceArray;
        this.qqn = i2;
        Sl(So);
        this.qqq = atomicReferenceArray;
        this.qqp = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqo;
        long eKw = eKw();
        int i = this.qqn;
        int O = O(eKw, i);
        if (eKw < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eKw, O);
        }
        int i2 = this.qqm;
        if (b(atomicReferenceArray, O(i2 + eKw, i)) == null) {
            this.producerLookAhead = (i2 + eKw) - 1;
            return a(atomicReferenceArray, t, eKw, O);
        } else if (b(atomicReferenceArray, O(1 + eKw, i)) != null) {
            return a(atomicReferenceArray, t, eKw, O);
        } else {
            a(atomicReferenceArray, eKw, O, t, i);
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
        this.qqo = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, qqr);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Sm(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, Sm(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqq;
        long eKx = eKx();
        int i = this.qqp;
        int O = O(eKx, i);
        T t = (T) b(atomicReferenceArray, O);
        boolean z = t == qqr;
        if (t != null && !z) {
            soConsumerIndex(eKx + 1);
            a(atomicReferenceArray, O, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), eKx, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qqq = atomicReferenceArray;
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqq;
        long eKx = eKx();
        int i = this.qqp;
        T t = (T) b(atomicReferenceArray, O(eKx, i));
        if (t == qqr) {
            return b(a(atomicReferenceArray), eKx, i);
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
        this.qqq = atomicReferenceArray;
        return (T) b(atomicReferenceArray, O(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long eKv = eKv();
        while (true) {
            long eKu = eKu();
            long eKv2 = eKv();
            if (eKv == eKv2) {
                return (int) (eKu - eKv2);
            }
            eKv = eKv2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return eKu() == eKv();
    }

    private void Sl(int i) {
        this.qqm = Math.min(i / 4, qql);
    }

    private long eKu() {
        return this.producerIndex.get();
    }

    private long eKv() {
        return this.consumerIndex.get();
    }

    private long eKw() {
        return this.producerIndex.get();
    }

    private long eKx() {
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
