package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes6.dex */
public final class f<T> implements Queue<T> {
    static final int nyJ = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nyP = new Object();
    final AtomicLong consumerIndex;
    int nyK;
    int nyL;
    AtomicReferenceArray<Object> nyM;
    int nyN;
    AtomicReferenceArray<Object> nyO;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public f(int i) {
        int NA = h.NA(Math.max(8, i));
        int i2 = NA - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(NA + 1);
        this.nyM = atomicReferenceArray;
        this.nyL = i2;
        Nx(NA);
        this.nyO = atomicReferenceArray;
        this.nyN = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyM;
        long dJv = dJv();
        int i = this.nyL;
        int E = E(dJv, i);
        if (dJv < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dJv, E);
        }
        int i2 = this.nyK;
        if (b(atomicReferenceArray, E(i2 + dJv, i)) == null) {
            this.producerLookAhead = (i2 + dJv) - 1;
            return a(atomicReferenceArray, t, dJv, E);
        } else if (b(atomicReferenceArray, E(1 + dJv, i)) != null) {
            return a(atomicReferenceArray, t, dJv, E);
        } else {
            a(atomicReferenceArray, dJv, E, t, i);
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
        this.nyM = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nyP);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Ny(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, Ny(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyO;
        long dJw = dJw();
        int i = this.nyN;
        int E = E(dJw, i);
        T t = (T) b(atomicReferenceArray, E);
        boolean z = t == nyP;
        if (t != null && !z) {
            soConsumerIndex(dJw + 1);
            a(atomicReferenceArray, E, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), dJw, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nyO = atomicReferenceArray;
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyO;
        long dJw = dJw();
        int i = this.nyN;
        T t = (T) b(atomicReferenceArray, E(dJw, i));
        if (t == nyP) {
            return b(a(atomicReferenceArray), dJw, i);
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
        this.nyO = atomicReferenceArray;
        return (T) b(atomicReferenceArray, E(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long dJu = dJu();
        while (true) {
            long dJt = dJt();
            long dJu2 = dJu();
            if (dJu == dJu2) {
                return (int) (dJt - dJu2);
            }
            dJu = dJu2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return dJt() == dJu();
    }

    private void Nx(int i) {
        this.nyK = Math.min(i / 4, nyJ);
    }

    private long dJt() {
        return this.producerIndex.get();
    }

    private long dJu() {
        return this.consumerIndex.get();
    }

    private long dJv() {
        return this.producerIndex.get();
    }

    private long dJw() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int E(long j, int i) {
        return Ny(((int) j) & i);
    }

    private static int Ny(int i) {
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
