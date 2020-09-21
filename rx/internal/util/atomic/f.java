package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes7.dex */
public final class f<T> implements Queue<T> {
    static final int oyY = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object oze = new Object();
    final AtomicLong consumerIndex;
    int oyZ;
    int oza;
    AtomicReferenceArray<Object> ozb;
    int ozc;
    AtomicReferenceArray<Object> ozd;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public f(int i) {
        int Ow = h.Ow(Math.max(8, i));
        int i2 = Ow - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Ow + 1);
        this.ozb = atomicReferenceArray;
        this.oza = i2;
        Ot(Ow);
        this.ozd = atomicReferenceArray;
        this.ozc = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.ozb;
        long ejr = ejr();
        int i = this.oza;
        int F = F(ejr, i);
        if (ejr < this.producerLookAhead) {
            return a(atomicReferenceArray, t, ejr, F);
        }
        int i2 = this.oyZ;
        if (b(atomicReferenceArray, F(i2 + ejr, i)) == null) {
            this.producerLookAhead = (i2 + ejr) - 1;
            return a(atomicReferenceArray, t, ejr, F);
        } else if (b(atomicReferenceArray, F(1 + ejr, i)) != null) {
            return a(atomicReferenceArray, t, ejr, F);
        } else {
            a(atomicReferenceArray, ejr, F, t, i);
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
        this.ozb = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, oze);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Ou(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, Ou(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.ozd;
        long ejs = ejs();
        int i = this.ozc;
        int F = F(ejs, i);
        T t = (T) b(atomicReferenceArray, F);
        boolean z = t == oze;
        if (t != null && !z) {
            soConsumerIndex(ejs + 1);
            a(atomicReferenceArray, F, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), ejs, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.ozd = atomicReferenceArray;
        int F = F(j, i);
        T t = (T) b(atomicReferenceArray, F);
        if (t == null) {
            return null;
        }
        soConsumerIndex(1 + j);
        a(atomicReferenceArray, F, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.ozd;
        long ejs = ejs();
        int i = this.ozc;
        T t = (T) b(atomicReferenceArray, F(ejs, i));
        if (t == oze) {
            return b(a(atomicReferenceArray), ejs, i);
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
        this.ozd = atomicReferenceArray;
        return (T) b(atomicReferenceArray, F(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long ejq = ejq();
        while (true) {
            long ejp = ejp();
            long ejq2 = ejq();
            if (ejq == ejq2) {
                return (int) (ejp - ejq2);
            }
            ejq = ejq2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return ejp() == ejq();
    }

    private void Ot(int i) {
        this.oyZ = Math.min(i / 4, oyY);
    }

    private long ejp() {
        return this.producerIndex.get();
    }

    private long ejq() {
        return this.consumerIndex.get();
    }

    private long ejr() {
        return this.producerIndex.get();
    }

    private long ejs() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int F(long j, int i) {
        return Ou(((int) j) & i);
    }

    private static int Ou(int i) {
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
