package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class a<T> implements f<T> {
    static final int nqB = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nqH = new Object();
    int nqC;
    final int nqD;
    AtomicReferenceArray<Object> nqE;
    final int nqF;
    AtomicReferenceArray<Object> nqG;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int JN = h.JN(Math.max(8, i));
        int i2 = JN - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(JN + 1);
        this.nqE = atomicReferenceArray;
        this.nqD = i2;
        JK(JN);
        this.nqG = atomicReferenceArray;
        this.nqF = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.nqE;
        long dLc = dLc();
        int i = this.nqD;
        int B = B(dLc, i);
        if (dLc < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dLc, B);
        }
        int i2 = this.nqC;
        if (b(atomicReferenceArray, B(i2 + dLc, i)) == null) {
            this.producerLookAhead = (i2 + dLc) - 1;
            return a(atomicReferenceArray, t, dLc, B);
        } else if (b(atomicReferenceArray, B(1 + dLc, i)) == null) {
            return a(atomicReferenceArray, t, dLc, B);
        } else {
            a(atomicReferenceArray, dLc, B, t, i);
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
        this.nqE = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nqH);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, JL(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int JL = JL(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, JL);
        a(atomicReferenceArray, JL, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nqG;
        long dLd = dLd();
        int i = this.nqF;
        int B = B(dLd, i);
        T t = (T) b(atomicReferenceArray, B);
        boolean z = t == nqH;
        if (t != null && !z) {
            a(atomicReferenceArray, B, (Object) null);
            soConsumerIndex(1 + dLd);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), dLd, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nqG = atomicReferenceArray;
        int B = B(j, i);
        T t = (T) b(atomicReferenceArray, B);
        if (t != null) {
            a(atomicReferenceArray, B, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nqG;
        long dLd = dLd();
        int i = this.nqF;
        T t = (T) b(atomicReferenceArray, B(dLd, i));
        if (t == nqH) {
            return b(a(atomicReferenceArray, i + 1), dLd, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nqG = atomicReferenceArray;
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
        long dLb = dLb();
        while (true) {
            long dLa = dLa();
            long dLb2 = dLb();
            if (dLb == dLb2) {
                return (int) (dLa - dLb2);
            }
            dLb = dLb2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return dLa() == dLb();
    }

    private void JK(int i) {
        this.nqC = Math.min(i / 4, nqB);
    }

    private long dLa() {
        return this.producerIndex.get();
    }

    private long dLb() {
        return this.consumerIndex.get();
    }

    private long dLc() {
        return this.producerIndex.get();
    }

    private long dLd() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int B(long j, int i) {
        return JL(((int) j) & i);
    }

    private static int JL(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nqE;
        long dLa = dLa();
        int i = this.nqD;
        if (b(atomicReferenceArray, B(dLa + 2, i)) == null) {
            int B = B(dLa, i);
            a(atomicReferenceArray, B + 1, t2);
            a(atomicReferenceArray, B, t);
            soProducerIndex(dLa + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.nqE = atomicReferenceArray2;
        int B2 = B(dLa, i);
        a(atomicReferenceArray2, B2 + 1, t2);
        a(atomicReferenceArray2, B2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, B2, nqH);
        soProducerIndex(dLa + 2);
        return true;
    }
}
