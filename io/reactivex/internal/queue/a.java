package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes17.dex */
public final class a<T> implements f<T> {
    static final int oOn = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object oOt = new Object();
    int oOo;
    final int oOp;
    AtomicReferenceArray<Object> oOq;
    final int oOr;
    AtomicReferenceArray<Object> oOs;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int Pc = h.Pc(Math.max(8, i));
        int i2 = Pc - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Pc + 1);
        this.oOq = atomicReferenceArray;
        this.oOp = i2;
        OZ(Pc);
        this.oOs = atomicReferenceArray;
        this.oOr = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
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
        } else if (b(atomicReferenceArray, J(1 + enc, i)) == null) {
            return a(atomicReferenceArray, t, enc, J);
        } else {
            a(atomicReferenceArray, enc, J, t, i);
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
        this.oOq = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, oOt);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Pa(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int Pa = Pa(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, Pa);
        a(atomicReferenceArray, Pa, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.oOs;
        long ene = ene();
        int i = this.oOr;
        int J = J(ene, i);
        T t = (T) b(atomicReferenceArray, J);
        boolean z = t == oOt;
        if (t != null && !z) {
            a(atomicReferenceArray, J, (Object) null);
            soConsumerIndex(1 + ene);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), ene, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.oOs = atomicReferenceArray;
        int J = J(j, i);
        T t = (T) b(atomicReferenceArray, J);
        if (t != null) {
            a(atomicReferenceArray, J, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.oOs;
        long ene = ene();
        int i = this.oOr;
        T t = (T) b(atomicReferenceArray, J(ene, i));
        if (t == oOt) {
            return b(a(atomicReferenceArray, i + 1), ene, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.oOs = atomicReferenceArray;
        return (T) b(atomicReferenceArray, J(j, i));
    }

    @Override // io.reactivex.internal.a.g
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

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

    @Override // io.reactivex.internal.a.g
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

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.oOq;
        long ena = ena();
        int i = this.oOp;
        if (b(atomicReferenceArray, J(ena + 2, i)) == null) {
            int J = J(ena, i);
            a(atomicReferenceArray, J + 1, t2);
            a(atomicReferenceArray, J, t);
            soProducerIndex(ena + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.oOq = atomicReferenceArray2;
        int J2 = J(ena, i);
        a(atomicReferenceArray2, J2 + 1, t2);
        a(atomicReferenceArray2, J2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, J2, oOt);
        soProducerIndex(ena + 2);
        return true;
    }
}
