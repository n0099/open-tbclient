package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class a<T> implements f<T> {
    static final int opp = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object opw = new Object();
    int opq;
    final int opr;
    AtomicReferenceArray<Object> ops;
    final int opu;
    AtomicReferenceArray<Object> opv;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int NR = h.NR(Math.max(8, i));
        int i2 = NR - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(NR + 1);
        this.ops = atomicReferenceArray;
        this.opr = i2;
        NO(NR);
        this.opv = atomicReferenceArray;
        this.opu = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
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
        } else if (b(atomicReferenceArray, C(1 + efu, i)) == null) {
            return a(atomicReferenceArray, t, efu, C);
        } else {
            a(atomicReferenceArray, efu, C, t, i);
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
        this.ops = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, opw);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, NP(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int NP = NP(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, NP);
        a(atomicReferenceArray, NP, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.opv;
        long efv = efv();
        int i = this.opu;
        int C = C(efv, i);
        T t = (T) b(atomicReferenceArray, C);
        boolean z = t == opw;
        if (t != null && !z) {
            a(atomicReferenceArray, C, (Object) null);
            soConsumerIndex(1 + efv);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), efv, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.opv = atomicReferenceArray;
        int C = C(j, i);
        T t = (T) b(atomicReferenceArray, C);
        if (t != null) {
            a(atomicReferenceArray, C, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.opv;
        long efv = efv();
        int i = this.opu;
        T t = (T) b(atomicReferenceArray, C(efv, i));
        if (t == opw) {
            return b(a(atomicReferenceArray, i + 1), efv, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.opv = atomicReferenceArray;
        return (T) b(atomicReferenceArray, C(j, i));
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

    @Override // io.reactivex.internal.a.g
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

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.ops;
        long efs = efs();
        int i = this.opr;
        if (b(atomicReferenceArray, C(efs + 2, i)) == null) {
            int C = C(efs, i);
            a(atomicReferenceArray, C + 1, t2);
            a(atomicReferenceArray, C, t);
            soProducerIndex(efs + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.ops = atomicReferenceArray2;
        int C2 = C(efs, i);
        a(atomicReferenceArray2, C2 + 1, t2);
        a(atomicReferenceArray2, C2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, C2, opw);
        soProducerIndex(efs + 2);
        return true;
    }
}
