package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes15.dex */
public final class f<T> implements Queue<T> {
    static final int qja = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qjg = new Object();
    final AtomicLong consumerIndex;
    final AtomicLong producerIndex;
    long producerLookAhead;
    int qjb;
    int qjc;
    AtomicReferenceArray<Object> qjd;
    int qje;
    AtomicReferenceArray<Object> qjf;

    public f(int i) {
        int Tk = h.Tk(Math.max(8, i));
        int i2 = Tk - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Tk + 1);
        this.qjd = atomicReferenceArray;
        this.qjc = i2;
        Th(Tk);
        this.qjf = atomicReferenceArray;
        this.qje = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.qjd;
        long eLs = eLs();
        int i = this.qjc;
        int N = N(eLs, i);
        if (eLs < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eLs, N);
        }
        int i2 = this.qjb;
        if (b(atomicReferenceArray, N(i2 + eLs, i)) == null) {
            this.producerLookAhead = (i2 + eLs) - 1;
            return a(atomicReferenceArray, t, eLs, N);
        } else if (b(atomicReferenceArray, N(1 + eLs, i)) != null) {
            return a(atomicReferenceArray, t, eLs, N);
        } else {
            a(atomicReferenceArray, eLs, N, t, i);
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
        this.qjd = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, qjg);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Ti(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, Ti(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qjf;
        long eLt = eLt();
        int i = this.qje;
        int N = N(eLt, i);
        T t = (T) b(atomicReferenceArray, N);
        boolean z = t == qjg;
        if (t != null && !z) {
            soConsumerIndex(eLt + 1);
            a(atomicReferenceArray, N, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), eLt, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qjf = atomicReferenceArray;
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.qjf;
        long eLt = eLt();
        int i = this.qje;
        T t = (T) b(atomicReferenceArray, N(eLt, i));
        if (t == qjg) {
            return b(a(atomicReferenceArray), eLt, i);
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
        this.qjf = atomicReferenceArray;
        return (T) b(atomicReferenceArray, N(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long eLr = eLr();
        while (true) {
            long eLq = eLq();
            long eLr2 = eLr();
            if (eLr == eLr2) {
                return (int) (eLq - eLr2);
            }
            eLr = eLr2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return eLq() == eLr();
    }

    private void Th(int i) {
        this.qjb = Math.min(i / 4, qja);
    }

    private long eLq() {
        return this.producerIndex.get();
    }

    private long eLr() {
        return this.consumerIndex.get();
    }

    private long eLs() {
        return this.producerIndex.get();
    }

    private long eLt() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int N(long j, int i) {
        return Ti(((int) j) & i);
    }

    private static int Ti(int i) {
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
