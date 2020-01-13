package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes5.dex */
public final class f<T> implements Queue<T> {
    static final int nyc = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nyi = new Object();
    final AtomicLong consumerIndex;
    int nyd;
    int nye;
    AtomicReferenceArray<Object> nyf;
    int nyg;
    AtomicReferenceArray<Object> nyh;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public f(int i) {
        int Nx = h.Nx(Math.max(8, i));
        int i2 = Nx - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Nx + 1);
        this.nyf = atomicReferenceArray;
        this.nye = i2;
        Nu(Nx);
        this.nyh = atomicReferenceArray;
        this.nyg = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyf;
        long dIm = dIm();
        int i = this.nye;
        int E = E(dIm, i);
        if (dIm < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dIm, E);
        }
        int i2 = this.nyd;
        if (b(atomicReferenceArray, E(i2 + dIm, i)) == null) {
            this.producerLookAhead = (i2 + dIm) - 1;
            return a(atomicReferenceArray, t, dIm, E);
        } else if (b(atomicReferenceArray, E(1 + dIm, i)) != null) {
            return a(atomicReferenceArray, t, dIm, E);
        } else {
            a(atomicReferenceArray, dIm, E, t, i);
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
        this.nyf = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nyi);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Nv(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, Nv(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyh;
        long dIn = dIn();
        int i = this.nyg;
        int E = E(dIn, i);
        T t = (T) b(atomicReferenceArray, E);
        boolean z = t == nyi;
        if (t != null && !z) {
            soConsumerIndex(dIn + 1);
            a(atomicReferenceArray, E, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), dIn, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nyh = atomicReferenceArray;
        int E = E(j, i);
        T t = (T) b(atomicReferenceArray, E);
        if (t == null) {
            return null;
        }
        soConsumerIndex(1 + j);
        a(atomicReferenceArray, E, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyh;
        long dIn = dIn();
        int i = this.nyg;
        T t = (T) b(atomicReferenceArray, E(dIn, i));
        if (t == nyi) {
            return b(a(atomicReferenceArray), dIn, i);
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
        this.nyh = atomicReferenceArray;
        return (T) b(atomicReferenceArray, E(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long dIl = dIl();
        while (true) {
            long dIk = dIk();
            long dIl2 = dIl();
            if (dIl == dIl2) {
                return (int) (dIk - dIl2);
            }
            dIl = dIl2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return dIk() == dIl();
    }

    private void Nu(int i) {
        this.nyd = Math.min(i / 4, nyc);
    }

    private long dIk() {
        return this.producerIndex.get();
    }

    private long dIl() {
        return this.consumerIndex.get();
    }

    private long dIm() {
        return this.producerIndex.get();
    }

    private long dIn() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int E(long j, int i) {
        return Nv(((int) j) & i);
    }

    private static int Nv(int i) {
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
