package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class a<T> implements f<T> {
    static final int npr = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object npx = new Object();
    int nps;
    final int npt;
    AtomicReferenceArray<Object> npu;
    final int npv;
    AtomicReferenceArray<Object> npw;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int JL = h.JL(Math.max(8, i));
        int i2 = JL - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(JL + 1);
        this.npu = atomicReferenceArray;
        this.npt = i2;
        JI(JL);
        this.npw = atomicReferenceArray;
        this.npv = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.npu;
        long dKO = dKO();
        int i = this.npt;
        int B = B(dKO, i);
        if (dKO < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dKO, B);
        }
        int i2 = this.nps;
        if (b(atomicReferenceArray, B(i2 + dKO, i)) == null) {
            this.producerLookAhead = (i2 + dKO) - 1;
            return a(atomicReferenceArray, t, dKO, B);
        } else if (b(atomicReferenceArray, B(1 + dKO, i)) == null) {
            return a(atomicReferenceArray, t, dKO, B);
        } else {
            a(atomicReferenceArray, dKO, B, t, i);
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
        this.npu = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, npx);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, JJ(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int JJ = JJ(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, JJ);
        a(atomicReferenceArray, JJ, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.npw;
        long dKP = dKP();
        int i = this.npv;
        int B = B(dKP, i);
        T t = (T) b(atomicReferenceArray, B);
        boolean z = t == npx;
        if (t != null && !z) {
            a(atomicReferenceArray, B, (Object) null);
            soConsumerIndex(1 + dKP);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), dKP, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.npw = atomicReferenceArray;
        int B = B(j, i);
        T t = (T) b(atomicReferenceArray, B);
        if (t != null) {
            a(atomicReferenceArray, B, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.npw;
        long dKP = dKP();
        int i = this.npv;
        T t = (T) b(atomicReferenceArray, B(dKP, i));
        if (t == npx) {
            return b(a(atomicReferenceArray, i + 1), dKP, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.npw = atomicReferenceArray;
        return (T) b(atomicReferenceArray, B(j, i));
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
        long dKN = dKN();
        while (true) {
            long dKM = dKM();
            long dKN2 = dKN();
            if (dKN == dKN2) {
                return (int) (dKM - dKN2);
            }
            dKN = dKN2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return dKM() == dKN();
    }

    private void JI(int i) {
        this.nps = Math.min(i / 4, npr);
    }

    private long dKM() {
        return this.producerIndex.get();
    }

    private long dKN() {
        return this.consumerIndex.get();
    }

    private long dKO() {
        return this.producerIndex.get();
    }

    private long dKP() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int B(long j, int i) {
        return JJ(((int) j) & i);
    }

    private static int JJ(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.npu;
        long dKM = dKM();
        int i = this.npt;
        if (b(atomicReferenceArray, B(dKM + 2, i)) == null) {
            int B = B(dKM, i);
            a(atomicReferenceArray, B + 1, t2);
            a(atomicReferenceArray, B, t);
            soProducerIndex(dKM + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.npu = atomicReferenceArray2;
        int B2 = B(dKM, i);
        a(atomicReferenceArray2, B2 + 1, t2);
        a(atomicReferenceArray2, B2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, B2, npx);
        soProducerIndex(dKM + 2);
        return true;
    }
}
