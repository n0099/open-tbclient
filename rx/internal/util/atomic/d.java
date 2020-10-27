package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes16.dex */
public final class d<T> implements Queue<T> {
    static final int pFK = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object pFQ = new Object();
    final AtomicLong consumerIndex;
    int pFL;
    int pFM;
    AtomicReferenceArray<Object> pFN;
    int pFO;
    AtomicReferenceArray<Object> pFP;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public d(int i) {
        int QT = h.QT(i);
        int i2 = QT - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(QT + 1);
        this.pFN = atomicReferenceArray;
        this.pFM = i2;
        QQ(QT);
        this.pFP = atomicReferenceArray;
        this.pFO = i2;
        this.producerLookAhead = i2 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pFN;
        long exc = exc();
        int i = this.pFM;
        int K = K(exc, i);
        if (exc < this.producerLookAhead) {
            return a(atomicReferenceArray, t, exc, K);
        }
        int i2 = this.pFL;
        if (b(atomicReferenceArray, K(i2 + exc, i)) == null) {
            this.producerLookAhead = (i2 + exc) - 1;
            return a(atomicReferenceArray, t, exc, K);
        } else if (b(atomicReferenceArray, K(1 + exc, i)) == null) {
            return a(atomicReferenceArray, t, exc, K);
        } else {
            a(atomicReferenceArray, exc, K, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        a(atomicReferenceArray, i, t);
        soProducerIndex(1 + j);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.pFN = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, pFQ);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, QR(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, QR(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pFP;
        long exd = exd();
        int i = this.pFO;
        int K = K(exd, i);
        T t = (T) b(atomicReferenceArray, K);
        boolean z = t == pFQ;
        if (t != null && !z) {
            a(atomicReferenceArray, K, (Object) null);
            soConsumerIndex(1 + exd);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), exd, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.pFP = atomicReferenceArray;
        int K = K(j, i);
        T t = (T) b(atomicReferenceArray, K);
        if (t == null) {
            return null;
        }
        a(atomicReferenceArray, K, (Object) null);
        soConsumerIndex(1 + j);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pFP;
        long exd = exd();
        int i = this.pFO;
        T t = (T) b(atomicReferenceArray, K(exd, i));
        if (t == pFQ) {
            return b(a(atomicReferenceArray), exd, i);
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
        this.pFP = atomicReferenceArray;
        return (T) b(atomicReferenceArray, K(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long exb = exb();
        while (true) {
            long exa = exa();
            long exb2 = exb();
            if (exb == exb2) {
                return (int) (exa - exb2);
            }
            exb = exb2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return exa() == exb();
    }

    private void QQ(int i) {
        this.pFL = Math.min(i / 4, pFK);
    }

    private long exa() {
        return this.producerIndex.get();
    }

    private long exb() {
        return this.consumerIndex.get();
    }

    private long exc() {
        return this.producerIndex.get();
    }

    private long exd() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int K(long j, int i) {
        return QR(((int) j) & i);
    }

    private static int QR(int i) {
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

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pFN;
        long exa = exa();
        int i = this.pFM;
        if (b(atomicReferenceArray, K(exa + 2, i)) == null) {
            int K = K(exa, i);
            a(atomicReferenceArray, K + 1, t2);
            a(atomicReferenceArray, K, t);
            soProducerIndex(exa + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.pFN = atomicReferenceArray2;
        int K2 = K(exa, i);
        a(atomicReferenceArray2, K2 + 1, t2);
        a(atomicReferenceArray2, K2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, K2, pFQ);
        soProducerIndex(exa + 2);
        return true;
    }
}
