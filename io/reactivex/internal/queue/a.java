package io.reactivex.internal.queue;

import io.reactivex.internal.a.e;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes5.dex */
public final class a<T> implements e<T> {
    static final int qql = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qqr = new Object();
    long producerLookAhead;
    int qqm;
    final int qqn;
    AtomicReferenceArray<Object> qqo;
    final int qqp;
    AtomicReferenceArray<Object> qqq;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int So = h.So(Math.max(8, i));
        int i2 = So - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(So + 1);
        this.qqo = atomicReferenceArray;
        this.qqn = i2;
        Sl(So);
        this.qqq = atomicReferenceArray;
        this.qqp = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqo;
        long eKw = eKw();
        int i = this.qqn;
        int O = O(eKw, i);
        if (eKw < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eKw, O);
        }
        int i2 = this.qqm;
        if (b(atomicReferenceArray, O(i2 + eKw, i)) == null) {
            this.producerLookAhead = (i2 + eKw) - 1;
            return a(atomicReferenceArray, t, eKw, O);
        } else if (b(atomicReferenceArray, O(1 + eKw, i)) == null) {
            return a(atomicReferenceArray, t, eKw, O);
        } else {
            a(atomicReferenceArray, eKw, O, t, i);
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
        this.qqo = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, qqr);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Sm(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int Sm = Sm(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, Sm);
        a(atomicReferenceArray, Sm, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.e, io.reactivex.internal.a.f
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqq;
        long eKx = eKx();
        int i = this.qqp;
        int O = O(eKx, i);
        T t = (T) b(atomicReferenceArray, O);
        boolean z = t == qqr;
        if (t != null && !z) {
            a(atomicReferenceArray, O, (Object) null);
            soConsumerIndex(1 + eKx);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), eKx, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qqq = atomicReferenceArray;
        int O = O(j, i);
        T t = (T) b(atomicReferenceArray, O);
        if (t != null) {
            a(atomicReferenceArray, O, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqq;
        long eKx = eKx();
        int i = this.qqp;
        T t = (T) b(atomicReferenceArray, O(eKx, i));
        if (t == qqr) {
            return b(a(atomicReferenceArray, i + 1), eKx, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qqq = atomicReferenceArray;
        return (T) b(atomicReferenceArray, O(j, i));
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public int size() {
        long eKv = eKv();
        while (true) {
            long eKu = eKu();
            long eKv2 = eKv();
            if (eKv == eKv2) {
                return (int) (eKu - eKv2);
            }
            eKv = eKv2;
        }
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return eKu() == eKv();
    }

    private void Sl(int i) {
        this.qqm = Math.min(i / 4, qql);
    }

    private long eKu() {
        return this.producerIndex.get();
    }

    private long eKv() {
        return this.consumerIndex.get();
    }

    private long eKw() {
        return this.producerIndex.get();
    }

    private long eKx() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int O(long j, int i) {
        return Sm(((int) j) & i);
    }

    private static int Sm(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqo;
        long eKu = eKu();
        int i = this.qqn;
        if (b(atomicReferenceArray, O(eKu + 2, i)) == null) {
            int O = O(eKu, i);
            a(atomicReferenceArray, O + 1, t2);
            a(atomicReferenceArray, O, t);
            soProducerIndex(eKu + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.qqo = atomicReferenceArray2;
        int O2 = O(eKu, i);
        a(atomicReferenceArray2, O2 + 1, t2);
        a(atomicReferenceArray2, O2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, O2, qqr);
        soProducerIndex(eKu + 2);
        return true;
    }
}
