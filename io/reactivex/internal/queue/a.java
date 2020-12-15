package io.reactivex.internal.queue;

import io.reactivex.internal.a.e;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes9.dex */
public final class a<T> implements e<T> {
    AtomicReferenceArray<Object> pHA;
    final int pHB;
    AtomicReferenceArray<Object> pHC;
    int pHy;
    final int pHz;
    long producerLookAhead;
    static final int pHx = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object pHD = new Object();
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int RR = h.RR(Math.max(8, i));
        int i2 = RR - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(RR + 1);
        this.pHA = atomicReferenceArray;
        this.pHz = i2;
        RO(RR);
        this.pHC = atomicReferenceArray;
        this.pHB = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.pHA;
        long eDk = eDk();
        int i = this.pHz;
        int O = O(eDk, i);
        if (eDk < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eDk, O);
        }
        int i2 = this.pHy;
        if (b(atomicReferenceArray, O(i2 + eDk, i)) == null) {
            this.producerLookAhead = (i2 + eDk) - 1;
            return a(atomicReferenceArray, t, eDk, O);
        } else if (b(atomicReferenceArray, O(1 + eDk, i)) == null) {
            return a(atomicReferenceArray, t, eDk, O);
        } else {
            a(atomicReferenceArray, eDk, O, t, i);
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
        this.pHA = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, pHD);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, RP(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int RP = RP(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, RP);
        a(atomicReferenceArray, RP, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.e, io.reactivex.internal.a.f
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pHC;
        long eDl = eDl();
        int i = this.pHB;
        int O = O(eDl, i);
        T t = (T) b(atomicReferenceArray, O);
        boolean z = t == pHD;
        if (t != null && !z) {
            a(atomicReferenceArray, O, (Object) null);
            soConsumerIndex(1 + eDl);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), eDl, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.pHC = atomicReferenceArray;
        int O = O(j, i);
        T t = (T) b(atomicReferenceArray, O);
        if (t != null) {
            a(atomicReferenceArray, O, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pHC;
        long eDl = eDl();
        int i = this.pHB;
        T t = (T) b(atomicReferenceArray, O(eDl, i));
        if (t == pHD) {
            return b(a(atomicReferenceArray, i + 1), eDl, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.pHC = atomicReferenceArray;
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
        long eDj = eDj();
        while (true) {
            long eDi = eDi();
            long eDj2 = eDj();
            if (eDj == eDj2) {
                return (int) (eDi - eDj2);
            }
            eDj = eDj2;
        }
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return eDi() == eDj();
    }

    private void RO(int i) {
        this.pHy = Math.min(i / 4, pHx);
    }

    private long eDi() {
        return this.producerIndex.get();
    }

    private long eDj() {
        return this.consumerIndex.get();
    }

    private long eDk() {
        return this.producerIndex.get();
    }

    private long eDl() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int O(long j, int i) {
        return RP(((int) j) & i);
    }

    private static int RP(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pHA;
        long eDi = eDi();
        int i = this.pHz;
        if (b(atomicReferenceArray, O(eDi + 2, i)) == null) {
            int O = O(eDi, i);
            a(atomicReferenceArray, O + 1, t2);
            a(atomicReferenceArray, O, t);
            soProducerIndex(eDi + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.pHA = atomicReferenceArray2;
        int O2 = O(eDi, i);
        a(atomicReferenceArray2, O2 + 1, t2);
        a(atomicReferenceArray2, O2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, O2, pHD);
        soProducerIndex(eDi + 2);
        return true;
    }
}
