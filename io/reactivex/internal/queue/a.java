package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class a<T> implements f<T> {
    static final int nMo = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nMu = new Object();
    int nMp;
    final int nMq;
    AtomicReferenceArray<Object> nMr;
    final int nMs;
    AtomicReferenceArray<Object> nMt;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int KU = h.KU(Math.max(8, i));
        int i2 = KU - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(KU + 1);
        this.nMr = atomicReferenceArray;
        this.nMq = i2;
        KR(KU);
        this.nMt = atomicReferenceArray;
        this.nMs = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.nMr;
        long dPI = dPI();
        int i = this.nMq;
        int B = B(dPI, i);
        if (dPI < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dPI, B);
        }
        int i2 = this.nMp;
        if (b(atomicReferenceArray, B(i2 + dPI, i)) == null) {
            this.producerLookAhead = (i2 + dPI) - 1;
            return a(atomicReferenceArray, t, dPI, B);
        } else if (b(atomicReferenceArray, B(1 + dPI, i)) == null) {
            return a(atomicReferenceArray, t, dPI, B);
        } else {
            a(atomicReferenceArray, dPI, B, t, i);
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
        this.nMr = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nMu);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, KS(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int KS = KS(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, KS);
        a(atomicReferenceArray, KS, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nMt;
        long dPJ = dPJ();
        int i = this.nMs;
        int B = B(dPJ, i);
        T t = (T) b(atomicReferenceArray, B);
        boolean z = t == nMu;
        if (t != null && !z) {
            a(atomicReferenceArray, B, (Object) null);
            soConsumerIndex(1 + dPJ);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), dPJ, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nMt = atomicReferenceArray;
        int B = B(j, i);
        T t = (T) b(atomicReferenceArray, B);
        if (t != null) {
            a(atomicReferenceArray, B, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nMt;
        long dPJ = dPJ();
        int i = this.nMs;
        T t = (T) b(atomicReferenceArray, B(dPJ, i));
        if (t == nMu) {
            return b(a(atomicReferenceArray, i + 1), dPJ, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nMt = atomicReferenceArray;
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
        long dPH = dPH();
        while (true) {
            long dPG = dPG();
            long dPH2 = dPH();
            if (dPH == dPH2) {
                return (int) (dPG - dPH2);
            }
            dPH = dPH2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return dPG() == dPH();
    }

    private void KR(int i) {
        this.nMp = Math.min(i / 4, nMo);
    }

    private long dPG() {
        return this.producerIndex.get();
    }

    private long dPH() {
        return this.consumerIndex.get();
    }

    private long dPI() {
        return this.producerIndex.get();
    }

    private long dPJ() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int B(long j, int i) {
        return KS(((int) j) & i);
    }

    private static int KS(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nMr;
        long dPG = dPG();
        int i = this.nMq;
        if (b(atomicReferenceArray, B(dPG + 2, i)) == null) {
            int B = B(dPG, i);
            a(atomicReferenceArray, B + 1, t2);
            a(atomicReferenceArray, B, t);
            soProducerIndex(dPG + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.nMr = atomicReferenceArray2;
        int B2 = B(dPG, i);
        a(atomicReferenceArray2, B2 + 1, t2);
        a(atomicReferenceArray2, B2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, B2, nMu);
        soProducerIndex(dPG + 2);
        return true;
    }
}
