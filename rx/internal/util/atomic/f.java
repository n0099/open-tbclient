package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes5.dex */
public final class f<T> implements Queue<T> {
    static final int opp = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object opw = new Object();
    final AtomicLong consumerIndex;
    int opq;
    int opr;
    AtomicReferenceArray<Object> ops;
    int opu;
    AtomicReferenceArray<Object> opv;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public f(int i) {
        int NR = h.NR(Math.max(8, i));
        int i2 = NR - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(NR + 1);
        this.ops = atomicReferenceArray;
        this.opr = i2;
        NO(NR);
        this.opv = atomicReferenceArray;
        this.opu = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.ops;
        long efu = efu();
        int i = this.opr;
        int C = C(efu, i);
        if (efu < this.producerLookAhead) {
            return a(atomicReferenceArray, t, efu, C);
        }
        int i2 = this.opq;
        if (b(atomicReferenceArray, C(i2 + efu, i)) == null) {
            this.producerLookAhead = (i2 + efu) - 1;
            return a(atomicReferenceArray, t, efu, C);
        } else if (b(atomicReferenceArray, C(1 + efu, i)) != null) {
            return a(atomicReferenceArray, t, efu, C);
        } else {
            a(atomicReferenceArray, efu, C, t, i);
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
        this.ops = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, opw);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, NP(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, NP(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.opv;
        long efv = efv();
        int i = this.opu;
        int C = C(efv, i);
        T t = (T) b(atomicReferenceArray, C);
        boolean z = t == opw;
        if (t != null && !z) {
            soConsumerIndex(efv + 1);
            a(atomicReferenceArray, C, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), efv, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.opv = atomicReferenceArray;
        int C = C(j, i);
        T t = (T) b(atomicReferenceArray, C);
        if (t == null) {
            return null;
        }
        soConsumerIndex(1 + j);
        a(atomicReferenceArray, C, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.opv;
        long efv = efv();
        int i = this.opu;
        T t = (T) b(atomicReferenceArray, C(efv, i));
        if (t == opw) {
            return b(a(atomicReferenceArray), efv, i);
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
        this.opv = atomicReferenceArray;
        return (T) b(atomicReferenceArray, C(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long eft = eft();
        while (true) {
            long efs = efs();
            long eft2 = eft();
            if (eft == eft2) {
                return (int) (efs - eft2);
            }
            eft = eft2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return efs() == eft();
    }

    private void NO(int i) {
        this.opq = Math.min(i / 4, opp);
    }

    private long efs() {
        return this.producerIndex.get();
    }

    private long eft() {
        return this.consumerIndex.get();
    }

    private long efu() {
        return this.producerIndex.get();
    }

    private long efv() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int C(long j, int i) {
        return NP(((int) j) & i);
    }

    private static int NP(int i) {
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
