package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class a<T> implements f<T> {
    static final int ooX = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object opd = new Object();
    int ooY;
    final int ooZ;
    AtomicReferenceArray<Object> opa;
    final int opb;
    AtomicReferenceArray<Object> opc;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int NR = h.NR(Math.max(8, i));
        int i2 = NR - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(NR + 1);
        this.opa = atomicReferenceArray;
        this.ooZ = i2;
        NO(NR);
        this.opc = atomicReferenceArray;
        this.opb = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.opa;
        long efl = efl();
        int i = this.ooZ;
        int C = C(efl, i);
        if (efl < this.producerLookAhead) {
            return a(atomicReferenceArray, t, efl, C);
        }
        int i2 = this.ooY;
        if (b(atomicReferenceArray, C(i2 + efl, i)) == null) {
            this.producerLookAhead = (i2 + efl) - 1;
            return a(atomicReferenceArray, t, efl, C);
        } else if (b(atomicReferenceArray, C(1 + efl, i)) == null) {
            return a(atomicReferenceArray, t, efl, C);
        } else {
            a(atomicReferenceArray, efl, C, t, i);
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
        this.opa = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, opd);
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.opc;
        long efm = efm();
        int i = this.opb;
        int C = C(efm, i);
        T t = (T) b(atomicReferenceArray, C);
        boolean z = t == opd;
        if (t != null && !z) {
            a(atomicReferenceArray, C, (Object) null);
            soConsumerIndex(1 + efm);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), efm, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.opc = atomicReferenceArray;
        int C = C(j, i);
        T t = (T) b(atomicReferenceArray, C);
        if (t != null) {
            a(atomicReferenceArray, C, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.opc;
        long efm = efm();
        int i = this.opb;
        T t = (T) b(atomicReferenceArray, C(efm, i));
        if (t == opd) {
            return b(a(atomicReferenceArray, i + 1), efm, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.opc = atomicReferenceArray;
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
        long efk = efk();
        while (true) {
            long efj = efj();
            long efk2 = efk();
            if (efk == efk2) {
                return (int) (efj - efk2);
            }
            efk = efk2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return efj() == efk();
    }

    private void NO(int i) {
        this.ooY = Math.min(i / 4, ooX);
    }

    private long efj() {
        return this.producerIndex.get();
    }

    private long efk() {
        return this.consumerIndex.get();
    }

    private long efl() {
        return this.producerIndex.get();
    }

    private long efm() {
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.opa;
        long efj = efj();
        int i = this.ooZ;
        if (b(atomicReferenceArray, C(efj + 2, i)) == null) {
            int C = C(efj, i);
            a(atomicReferenceArray, C + 1, t2);
            a(atomicReferenceArray, C, t);
            soProducerIndex(efj + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.opa = atomicReferenceArray2;
        int C2 = C(efj, i);
        a(atomicReferenceArray2, C2 + 1, t2);
        a(atomicReferenceArray2, C2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, C2, opd);
        soProducerIndex(efj + 2);
        return true;
    }
}
