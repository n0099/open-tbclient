package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes6.dex */
public final class d<T> implements Queue<T> {
    static final int mUl = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object mUr = new Object();
    final AtomicLong consumerIndex;
    int mUm;
    int mUn;
    AtomicReferenceArray<Object> mUo;
    int mUp;
    AtomicReferenceArray<Object> mUq;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public d(int i) {
        int Ja = h.Ja(i);
        int i2 = Ja - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Ja + 1);
        this.mUo = atomicReferenceArray;
        this.mUn = i2;
        IX(Ja);
        this.mUq = atomicReferenceArray;
        this.mUp = i2;
        this.producerLookAhead = i2 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.mUo;
        long dCX = dCX();
        int i = this.mUn;
        int B = B(dCX, i);
        if (dCX < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dCX, B);
        }
        int i2 = this.mUm;
        if (b(atomicReferenceArray, B(i2 + dCX, i)) == null) {
            this.producerLookAhead = (i2 + dCX) - 1;
            return a(atomicReferenceArray, t, dCX, B);
        } else if (b(atomicReferenceArray, B(1 + dCX, i)) == null) {
            return a(atomicReferenceArray, t, dCX, B);
        } else {
            a(atomicReferenceArray, dCX, B, t, i);
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
        this.mUo = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, mUr);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, IY(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, IY(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.mUq;
        long dCY = dCY();
        int i = this.mUp;
        int B = B(dCY, i);
        T t = (T) b(atomicReferenceArray, B);
        boolean z = t == mUr;
        if (t != null && !z) {
            a(atomicReferenceArray, B, (Object) null);
            soConsumerIndex(1 + dCY);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), dCY, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.mUq = atomicReferenceArray;
        int B = B(j, i);
        T t = (T) b(atomicReferenceArray, B);
        if (t == null) {
            return null;
        }
        a(atomicReferenceArray, B, (Object) null);
        soConsumerIndex(1 + j);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.mUq;
        long dCY = dCY();
        int i = this.mUp;
        T t = (T) b(atomicReferenceArray, B(dCY, i));
        if (t == mUr) {
            return b(a(atomicReferenceArray), dCY, i);
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
        this.mUq = atomicReferenceArray;
        return (T) b(atomicReferenceArray, B(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long dCW = dCW();
        while (true) {
            long dCV = dCV();
            long dCW2 = dCW();
            if (dCW == dCW2) {
                return (int) (dCV - dCW2);
            }
            dCW = dCW2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return dCV() == dCW();
    }

    private void IX(int i) {
        this.mUm = Math.min(i / 4, mUl);
    }

    private long dCV() {
        return this.producerIndex.get();
    }

    private long dCW() {
        return this.consumerIndex.get();
    }

    private long dCX() {
        return this.producerIndex.get();
    }

    private long dCY() {
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

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.mUo;
        long dCV = dCV();
        int i = this.mUn;
        if (b(atomicReferenceArray, B(dCV + 2, i)) == null) {
            int B = B(dCV, i);
            a(atomicReferenceArray, B + 1, t2);
            a(atomicReferenceArray, B, t);
            soProducerIndex(dCV + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.mUo = atomicReferenceArray2;
        int B2 = B(dCV, i);
        a(atomicReferenceArray2, B2 + 1, t2);
        a(atomicReferenceArray2, B2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, B2, mUr);
        soProducerIndex(dCV + 2);
        return true;
    }
}
