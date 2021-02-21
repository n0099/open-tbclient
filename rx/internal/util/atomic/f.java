package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes5.dex */
public final class f<T> implements Queue<T> {
    static final int qqL = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qqR = new Object();
    final AtomicLong consumerIndex;
    final AtomicLong producerIndex;
    long producerLookAhead;
    int qqM;
    int qqN;
    AtomicReferenceArray<Object> qqO;
    int qqP;
    AtomicReferenceArray<Object> qqQ;

    public f(int i) {
        int Sp = h.Sp(Math.max(8, i));
        int i2 = Sp - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Sp + 1);
        this.qqO = atomicReferenceArray;
        this.qqN = i2;
        Sm(Sp);
        this.qqQ = atomicReferenceArray;
        this.qqP = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqO;
        long eKE = eKE();
        int i = this.qqN;
        int O = O(eKE, i);
        if (eKE < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eKE, O);
        }
        int i2 = this.qqM;
        if (b(atomicReferenceArray, O(i2 + eKE, i)) == null) {
            this.producerLookAhead = (i2 + eKE) - 1;
            return a(atomicReferenceArray, t, eKE, O);
        } else if (b(atomicReferenceArray, O(1 + eKE, i)) != null) {
            return a(atomicReferenceArray, t, eKE, O);
        } else {
            a(atomicReferenceArray, eKE, O, t, i);
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
        this.qqO = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, qqR);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Sn(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, Sn(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqQ;
        long eKF = eKF();
        int i = this.qqP;
        int O = O(eKF, i);
        T t = (T) b(atomicReferenceArray, O);
        boolean z = t == qqR;
        if (t != null && !z) {
            soConsumerIndex(eKF + 1);
            a(atomicReferenceArray, O, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), eKF, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qqQ = atomicReferenceArray;
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqQ;
        long eKF = eKF();
        int i = this.qqP;
        T t = (T) b(atomicReferenceArray, O(eKF, i));
        if (t == qqR) {
            return b(a(atomicReferenceArray), eKF, i);
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
        this.qqQ = atomicReferenceArray;
        return (T) b(atomicReferenceArray, O(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long eKD = eKD();
        while (true) {
            long eKC = eKC();
            long eKD2 = eKD();
            if (eKD == eKD2) {
                return (int) (eKC - eKD2);
            }
            eKD = eKD2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return eKC() == eKD();
    }

    private void Sm(int i) {
        this.qqM = Math.min(i / 4, qqL);
    }

    private long eKC() {
        return this.producerIndex.get();
    }

    private long eKD() {
        return this.consumerIndex.get();
    }

    private long eKE() {
        return this.producerIndex.get();
    }

    private long eKF() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int O(long j, int i) {
        return Sn(((int) j) & i);
    }

    private static int Sn(int i) {
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
