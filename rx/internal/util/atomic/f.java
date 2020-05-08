package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes6.dex */
public final class f<T> implements Queue<T> {
    static final int mUo = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object mUu = new Object();
    final AtomicLong consumerIndex;
    int mUp;
    int mUq;
    AtomicReferenceArray<Object> mUr;
    int mUs;
    AtomicReferenceArray<Object> mUt;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public f(int i) {
        int Ja = h.Ja(Math.max(8, i));
        int i2 = Ja - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Ja + 1);
        this.mUr = atomicReferenceArray;
        this.mUq = i2;
        IX(Ja);
        this.mUt = atomicReferenceArray;
        this.mUs = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.mUr;
        long dCT = dCT();
        int i = this.mUq;
        int B = B(dCT, i);
        if (dCT < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dCT, B);
        }
        int i2 = this.mUp;
        if (b(atomicReferenceArray, B(i2 + dCT, i)) == null) {
            this.producerLookAhead = (i2 + dCT) - 1;
            return a(atomicReferenceArray, t, dCT, B);
        } else if (b(atomicReferenceArray, B(1 + dCT, i)) != null) {
            return a(atomicReferenceArray, t, dCT, B);
        } else {
            a(atomicReferenceArray, dCT, B, t, i);
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
        this.mUr = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, mUu);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, IY(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, IY(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.mUt;
        long dCU = dCU();
        int i = this.mUs;
        int B = B(dCU, i);
        T t = (T) b(atomicReferenceArray, B);
        boolean z = t == mUu;
        if (t != null && !z) {
            soConsumerIndex(dCU + 1);
            a(atomicReferenceArray, B, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), dCU, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.mUt = atomicReferenceArray;
        int B = B(j, i);
        T t = (T) b(atomicReferenceArray, B);
        if (t == null) {
            return null;
        }
        soConsumerIndex(1 + j);
        a(atomicReferenceArray, B, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.mUt;
        long dCU = dCU();
        int i = this.mUs;
        T t = (T) b(atomicReferenceArray, B(dCU, i));
        if (t == mUu) {
            return b(a(atomicReferenceArray), dCU, i);
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
        this.mUt = atomicReferenceArray;
        return (T) b(atomicReferenceArray, B(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long dCS = dCS();
        while (true) {
            long dCR = dCR();
            long dCS2 = dCS();
            if (dCS == dCS2) {
                return (int) (dCR - dCS2);
            }
            dCS = dCS2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return dCR() == dCS();
    }

    private void IX(int i) {
        this.mUp = Math.min(i / 4, mUo);
    }

    private long dCR() {
        return this.producerIndex.get();
    }

    private long dCS() {
        return this.consumerIndex.get();
    }

    private long dCT() {
        return this.producerIndex.get();
    }

    private long dCU() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int B(long j, int i) {
        return IY(((int) j) & i);
    }

    private static int IY(int i) {
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
