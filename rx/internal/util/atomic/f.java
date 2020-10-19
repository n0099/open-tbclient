package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes16.dex */
public final class f<T> implements Queue<T> {
    static final int oOn = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object oOt = new Object();
    final AtomicLong consumerIndex;
    int oOo;
    int oOp;
    AtomicReferenceArray<Object> oOq;
    int oOr;
    AtomicReferenceArray<Object> oOs;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public f(int i) {
        int Pc = h.Pc(Math.max(8, i));
        int i2 = Pc - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Pc + 1);
        this.oOq = atomicReferenceArray;
        this.oOp = i2;
        OZ(Pc);
        this.oOs = atomicReferenceArray;
        this.oOr = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.oOq;
        long enc = enc();
        int i = this.oOp;
        int J = J(enc, i);
        if (enc < this.producerLookAhead) {
            return a(atomicReferenceArray, t, enc, J);
        }
        int i2 = this.oOo;
        if (b(atomicReferenceArray, J(i2 + enc, i)) == null) {
            this.producerLookAhead = (i2 + enc) - 1;
            return a(atomicReferenceArray, t, enc, J);
        } else if (b(atomicReferenceArray, J(1 + enc, i)) != null) {
            return a(atomicReferenceArray, t, enc, J);
        } else {
            a(atomicReferenceArray, enc, J, t, i);
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
        this.oOq = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        soProducerIndex(j + 1);
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, oOt);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Pa(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) b(atomicReferenceArray, Pa(atomicReferenceArray.length() - 1));
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.oOs;
        long ene = ene();
        int i = this.oOr;
        int J = J(ene, i);
        T t = (T) b(atomicReferenceArray, J);
        boolean z = t == oOt;
        if (t != null && !z) {
            soConsumerIndex(ene + 1);
            a(atomicReferenceArray, J, (Object) null);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray), ene, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.oOs = atomicReferenceArray;
        int J = J(j, i);
        T t = (T) b(atomicReferenceArray, J);
        if (t == null) {
            return null;
        }
        soConsumerIndex(1 + j);
        a(atomicReferenceArray, J, (Object) null);
        return t;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.oOs;
        long ene = ene();
        int i = this.oOr;
        T t = (T) b(atomicReferenceArray, J(ene, i));
        if (t == oOt) {
            return b(a(atomicReferenceArray), ene, i);
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
        this.oOs = atomicReferenceArray;
        return (T) b(atomicReferenceArray, J(j, i));
    }

    @Override // java.util.Collection
    public int size() {
        long enb = enb();
        while (true) {
            long ena = ena();
            long enb2 = enb();
            if (enb == enb2) {
                return (int) (ena - enb2);
            }
            enb = enb2;
        }
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return ena() == enb();
    }

    private void OZ(int i) {
        this.oOo = Math.min(i / 4, oOn);
    }

    private long ena() {
        return this.producerIndex.get();
    }

    private long enb() {
        return this.consumerIndex.get();
    }

    private long enc() {
        return this.producerIndex.get();
    }

    private long ene() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int J(long j, int i) {
        return Pa(((int) j) & i);
    }

    private static int Pa(int i) {
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
