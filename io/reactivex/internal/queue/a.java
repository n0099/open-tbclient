package io.reactivex.internal.queue;

import io.reactivex.internal.a.e;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes5.dex */
public final class a<T> implements e<T> {
    static final int qgg = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qgm = new Object();
    long producerLookAhead;
    int qgh;
    final int qgi;
    AtomicReferenceArray<Object> qgj;
    final int qgk;
    AtomicReferenceArray<Object> qgl;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int RT = h.RT(Math.max(8, i));
        int i2 = RT - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(RT + 1);
        this.qgj = atomicReferenceArray;
        this.qgi = i2;
        RQ(RT);
        this.qgl = atomicReferenceArray;
        this.qgk = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.qgj;
        long eIg = eIg();
        int i = this.qgi;
        int Q = Q(eIg, i);
        if (eIg < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eIg, Q);
        }
        int i2 = this.qgh;
        if (b(atomicReferenceArray, Q(i2 + eIg, i)) == null) {
            this.producerLookAhead = (i2 + eIg) - 1;
            return a(atomicReferenceArray, t, eIg, Q);
        } else if (b(atomicReferenceArray, Q(1 + eIg, i)) == null) {
            return a(atomicReferenceArray, t, eIg, Q);
        } else {
            a(atomicReferenceArray, eIg, Q, t, i);
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
        this.qgj = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, qgm);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, RR(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int RR = RR(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, RR);
        a(atomicReferenceArray, RR, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.e, io.reactivex.internal.a.f
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qgl;
        long eIh = eIh();
        int i = this.qgk;
        int Q = Q(eIh, i);
        T t = (T) b(atomicReferenceArray, Q);
        boolean z = t == qgm;
        if (t != null && !z) {
            a(atomicReferenceArray, Q, (Object) null);
            soConsumerIndex(1 + eIh);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), eIh, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qgl = atomicReferenceArray;
        int Q = Q(j, i);
        T t = (T) b(atomicReferenceArray, Q);
        if (t != null) {
            a(atomicReferenceArray, Q, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qgl;
        long eIh = eIh();
        int i = this.qgk;
        T t = (T) b(atomicReferenceArray, Q(eIh, i));
        if (t == qgm) {
            return b(a(atomicReferenceArray, i + 1), eIh, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qgl = atomicReferenceArray;
        return (T) b(atomicReferenceArray, Q(j, i));
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
        long eIf = eIf();
        while (true) {
            long eIe = eIe();
            long eIf2 = eIf();
            if (eIf == eIf2) {
                return (int) (eIe - eIf2);
            }
            eIf = eIf2;
        }
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return eIe() == eIf();
    }

    private void RQ(int i) {
        this.qgh = Math.min(i / 4, qgg);
    }

    private long eIe() {
        return this.producerIndex.get();
    }

    private long eIf() {
        return this.consumerIndex.get();
    }

    private long eIg() {
        return this.producerIndex.get();
    }

    private long eIh() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int Q(long j, int i) {
        return RR(((int) j) & i);
    }

    private static int RR(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qgj;
        long eIe = eIe();
        int i = this.qgi;
        if (b(atomicReferenceArray, Q(eIe + 2, i)) == null) {
            int Q = Q(eIe, i);
            a(atomicReferenceArray, Q + 1, t2);
            a(atomicReferenceArray, Q, t);
            soProducerIndex(eIe + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.qgj = atomicReferenceArray2;
        int Q2 = Q(eIe, i);
        a(atomicReferenceArray2, Q2 + 1, t2);
        a(atomicReferenceArray2, Q2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, Q2, qgm);
        soProducerIndex(eIe + 2);
        return true;
    }
}
