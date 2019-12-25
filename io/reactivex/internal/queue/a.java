package io.reactivex.internal.queue;

import io.reactivex.internal.a.e;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes4.dex */
public final class a<T> implements e<T> {
    static final int mVT = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object mVZ = new Object();
    int mVU;
    final int mVV;
    AtomicReferenceArray<Object> mVW;
    final int mVX;
    AtomicReferenceArray<Object> mVY;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int MK = h.MK(Math.max(8, i));
        int i2 = MK - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(MK + 1);
        this.mVW = atomicReferenceArray;
        this.mVV = i2;
        MH(MK);
        this.mVY = atomicReferenceArray;
        this.mVX = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.mVW;
        long dEc = dEc();
        int i = this.mVV;
        int E = E(dEc, i);
        if (dEc < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dEc, E);
        }
        int i2 = this.mVU;
        if (b(atomicReferenceArray, E(i2 + dEc, i)) == null) {
            this.producerLookAhead = (i2 + dEc) - 1;
            return a(atomicReferenceArray, t, dEc, E);
        } else if (b(atomicReferenceArray, E(1 + dEc, i)) == null) {
            return a(atomicReferenceArray, t, dEc, E);
        } else {
            a(atomicReferenceArray, dEc, E, t, i);
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
        this.mVW = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, mVZ);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, MI(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int MI = MI(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, MI);
        a(atomicReferenceArray, MI, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.e, io.reactivex.internal.a.f
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.mVY;
        long dEd = dEd();
        int i = this.mVX;
        int E = E(dEd, i);
        T t = (T) b(atomicReferenceArray, E);
        boolean z = t == mVZ;
        if (t != null && !z) {
            a(atomicReferenceArray, E, (Object) null);
            soConsumerIndex(1 + dEd);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), dEd, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.mVY = atomicReferenceArray;
        int E = E(j, i);
        T t = (T) b(atomicReferenceArray, E);
        if (t != null) {
            a(atomicReferenceArray, E, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.mVY;
        long dEd = dEd();
        int i = this.mVX;
        T t = (T) b(atomicReferenceArray, E(dEd, i));
        if (t == mVZ) {
            return b(a(atomicReferenceArray, i + 1), dEd, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.mVY = atomicReferenceArray;
        return (T) b(atomicReferenceArray, E(j, i));
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
        long dEb = dEb();
        while (true) {
            long dEa = dEa();
            long dEb2 = dEb();
            if (dEb == dEb2) {
                return (int) (dEa - dEb2);
            }
            dEb = dEb2;
        }
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return dEa() == dEb();
    }

    private void MH(int i) {
        this.mVU = Math.min(i / 4, mVT);
    }

    private long dEa() {
        return this.producerIndex.get();
    }

    private long dEb() {
        return this.consumerIndex.get();
    }

    private long dEc() {
        return this.producerIndex.get();
    }

    private long dEd() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int E(long j, int i) {
        return MI(((int) j) & i);
    }

    private static int MI(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.mVW;
        long dEa = dEa();
        int i = this.mVV;
        if (b(atomicReferenceArray, E(dEa + 2, i)) == null) {
            int E = E(dEa, i);
            a(atomicReferenceArray, E + 1, t2);
            a(atomicReferenceArray, E, t);
            soProducerIndex(dEa + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.mVW = atomicReferenceArray2;
        int E2 = E(dEa, i);
        a(atomicReferenceArray2, E2 + 1, t2);
        a(atomicReferenceArray2, E2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, E2, mVZ);
        soProducerIndex(dEa + 2);
        return true;
    }
}
