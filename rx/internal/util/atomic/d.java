package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes5.dex */
public final class d<T> implements Queue<T> {
    static final int nyh = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nyn = new Object();
    final AtomicLong consumerIndex;
    int nyi;
    int nyj;
    AtomicReferenceArray<Object> nyk;
    int nyl;
    AtomicReferenceArray<Object> nym;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public d(int i) {
        int Nx = h.Nx(i);
        int i2 = Nx - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Nx + 1);
        this.nyk = atomicReferenceArray;
        this.nyj = i2;
        Nu(Nx);
        this.nym = atomicReferenceArray;
        this.nyl = i2;
        this.producerLookAhead = i2 - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyk;
        long dIo = dIo();
        int i = this.nyj;
        int E = E(dIo, i);
        if (dIo < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dIo, E);
        }
        int i2 = this.nyi;
        if (b(atomicReferenceArray, E(i2 + dIo, i)) == null) {
            this.producerLookAhead = (i2 + dIo) - 1;
            return a(atomicReferenceArray, t, dIo, E);
        } else if (b(atomicReferenceArray, E(1 + dIo, i)) == null) {
            return a(atomicReferenceArray, t, dIo, E);
        } else {
            a(atomicReferenceArray, dIo, E, t, i);
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
        this.nyk = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nyn);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Nv(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, Nv(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nym;
        long dIp = dIp();
        int i = this.nyl;
        int E = E(dIp, i);
        T t = (T) b(atomicReferenceArray, E);
        boolean z = t == nyn;
        if (t != null && !z) {
            a(atomicReferenceArray, E, (Object) null);
            soConsumerIndex(1 + dIp);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), dIp, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nym = atomicReferenceArray;
        int E = E(j, i);
        T t = (T) b(atomicReferenceArray, E);
        if (t == null) {
            return null;
        }
        a(atomicReferenceArray, E, (Object) null);
        soConsumerIndex(1 + j);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nym;
        long dIp = dIp();
        int i = this.nyl;
        T t = (T) b(atomicReferenceArray, E(dIp, i));
        if (t == nyn) {
            return b(a(atomicReferenceArray), dIp, i);
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
        this.nym = atomicReferenceArray;
        return (T) b(atomicReferenceArray, E(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long dIn = dIn();
        while (true) {
            long dIm = dIm();
            long dIn2 = dIn();
            if (dIn == dIn2) {
                return (int) (dIm - dIn2);
            }
            dIn = dIn2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return dIm() == dIn();
    }

    private void Nu(int i) {
        this.nyi = Math.min(i / 4, nyh);
    }

    private long dIm() {
        return this.producerIndex.get();
    }

    private long dIn() {
        return this.consumerIndex.get();
    }

    private long dIo() {
        return this.producerIndex.get();
    }

    private long dIp() {
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

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyk;
        long dIm = dIm();
        int i = this.nyj;
        if (b(atomicReferenceArray, E(dIm + 2, i)) == null) {
            int E = E(dIm, i);
            a(atomicReferenceArray, E + 1, t2);
            a(atomicReferenceArray, E, t);
            soProducerIndex(dIm + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.nyk = atomicReferenceArray2;
        int E2 = E(dIm, i);
        a(atomicReferenceArray2, E2 + 1, t2);
        a(atomicReferenceArray2, E2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, E2, nyn);
        soProducerIndex(dIm + 2);
        return true;
    }
}
