package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes16.dex */
public final class f<T> implements Queue<T> {
    static final int pPe = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object pPk = new Object();
    final AtomicLong consumerIndex;
    int pPf;
    int pPg;
    AtomicReferenceArray<Object> pPh;
    int pPi;
    AtomicReferenceArray<Object> pPj;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public f(int i) {
        int Ro = h.Ro(Math.max(8, i));
        int i2 = Ro - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Ro + 1);
        this.pPh = atomicReferenceArray;
        this.pPg = i2;
        Rl(Ro);
        this.pPj = atomicReferenceArray;
        this.pPi = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.pPh;
        long eAR = eAR();
        int i = this.pPg;
        int N = N(eAR, i);
        if (eAR < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eAR, N);
        }
        int i2 = this.pPf;
        if (b(atomicReferenceArray, N(i2 + eAR, i)) == null) {
            this.producerLookAhead = (i2 + eAR) - 1;
            return a(atomicReferenceArray, t, eAR, N);
        } else if (b(atomicReferenceArray, N(1 + eAR, i)) != null) {
            return a(atomicReferenceArray, t, eAR, N);
        } else {
            a(atomicReferenceArray, eAR, N, t, i);
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
        this.pPh = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, pPk);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Rm(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, Rm(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pPj;
        long eAS = eAS();
        int i = this.pPi;
        int N = N(eAS, i);
        T t = (T) b(atomicReferenceArray, N);
        boolean z = t == pPk;
        if (t != null && !z) {
            soConsumerIndex(eAS + 1);
            a(atomicReferenceArray, N, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), eAS, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.pPj = atomicReferenceArray;
        int N = N(j, i);
        T t = (T) b(atomicReferenceArray, N);
        if (t == null) {
            return null;
        }
        soConsumerIndex(1 + j);
        a(atomicReferenceArray, N, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pPj;
        long eAS = eAS();
        int i = this.pPi;
        T t = (T) b(atomicReferenceArray, N(eAS, i));
        if (t == pPk) {
            return b(a(atomicReferenceArray), eAS, i);
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
        this.pPj = atomicReferenceArray;
        return (T) b(atomicReferenceArray, N(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long eAQ = eAQ();
        while (true) {
            long eAP = eAP();
            long eAQ2 = eAQ();
            if (eAQ == eAQ2) {
                return (int) (eAP - eAQ2);
            }
            eAQ = eAQ2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return eAP() == eAQ();
    }

    private void Rl(int i) {
        this.pPf = Math.min(i / 4, pPe);
    }

    private long eAP() {
        return this.producerIndex.get();
    }

    private long eAQ() {
        return this.consumerIndex.get();
    }

    private long eAR() {
        return this.producerIndex.get();
    }

    private long eAS() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int N(long j, int i) {
        return Rm(((int) j) & i);
    }

    private static int Rm(int i) {
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
