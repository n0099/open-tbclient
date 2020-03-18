package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class a<T> implements f<T> {
    static final int nAJ = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nAP = new Object();
    int nAK;
    final int nAL;
    AtomicReferenceArray<Object> nAM;
    final int nAN;
    AtomicReferenceArray<Object> nAO;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int NG = h.NG(Math.max(8, i));
        int i2 = NG - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(NG + 1);
        this.nAM = atomicReferenceArray;
        this.nAL = i2;
        ND(NG);
        this.nAO = atomicReferenceArray;
        this.nAN = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.nAM;
        long dJY = dJY();
        int i = this.nAL;
        int E = E(dJY, i);
        if (dJY < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dJY, E);
        }
        int i2 = this.nAK;
        if (b(atomicReferenceArray, E(i2 + dJY, i)) == null) {
            this.producerLookAhead = (i2 + dJY) - 1;
            return a(atomicReferenceArray, t, dJY, E);
        } else if (b(atomicReferenceArray, E(1 + dJY, i)) == null) {
            return a(atomicReferenceArray, t, dJY, E);
        } else {
            a(atomicReferenceArray, dJY, E, t, i);
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
        this.nAM = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nAP);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, NE(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int NE = NE(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, NE);
        a(atomicReferenceArray, NE, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nAO;
        long dJZ = dJZ();
        int i = this.nAN;
        int E = E(dJZ, i);
        T t = (T) b(atomicReferenceArray, E);
        boolean z = t == nAP;
        if (t != null && !z) {
            a(atomicReferenceArray, E, (Object) null);
            soConsumerIndex(1 + dJZ);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), dJZ, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nAO = atomicReferenceArray;
        int E = E(j, i);
        T t = (T) b(atomicReferenceArray, E);
        if (t != null) {
            a(atomicReferenceArray, E, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nAO;
        long dJZ = dJZ();
        int i = this.nAN;
        T t = (T) b(atomicReferenceArray, E(dJZ, i));
        if (t == nAP) {
            return b(a(atomicReferenceArray, i + 1), dJZ, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nAO = atomicReferenceArray;
        return (T) b(atomicReferenceArray, E(j, i));
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
        long dJX = dJX();
        while (true) {
            long dJW = dJW();
            long dJX2 = dJX();
            if (dJX == dJX2) {
                return (int) (dJW - dJX2);
            }
            dJX = dJX2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return dJW() == dJX();
    }

    private void ND(int i) {
        this.nAK = Math.min(i / 4, nAJ);
    }

    private long dJW() {
        return this.producerIndex.get();
    }

    private long dJX() {
        return this.consumerIndex.get();
    }

    private long dJY() {
        return this.producerIndex.get();
    }

    private long dJZ() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int E(long j, int i) {
        return NE(((int) j) & i);
    }

    private static int NE(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nAM;
        long dJW = dJW();
        int i = this.nAL;
        if (b(atomicReferenceArray, E(dJW + 2, i)) == null) {
            int E = E(dJW, i);
            a(atomicReferenceArray, E + 1, t2);
            a(atomicReferenceArray, E, t);
            soProducerIndex(dJW + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.nAM = atomicReferenceArray2;
        int E2 = E(dJW, i);
        a(atomicReferenceArray2, E2 + 1, t2);
        a(atomicReferenceArray2, E2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, E2, nAP);
        soProducerIndex(dJW + 2);
        return true;
    }
}
