package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class a<T> implements f<T> {
    static final int nMr = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nMx = new Object();
    int nMs;
    final int nMt;
    AtomicReferenceArray<Object> nMu;
    final int nMv;
    AtomicReferenceArray<Object> nMw;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int KU = h.KU(Math.max(8, i));
        int i2 = KU - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(KU + 1);
        this.nMu = atomicReferenceArray;
        this.nMt = i2;
        KR(KU);
        this.nMw = atomicReferenceArray;
        this.nMv = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.nMu;
        long dPM = dPM();
        int i = this.nMt;
        int B = B(dPM, i);
        if (dPM < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dPM, B);
        }
        int i2 = this.nMs;
        if (b(atomicReferenceArray, B(i2 + dPM, i)) == null) {
            this.producerLookAhead = (i2 + dPM) - 1;
            return a(atomicReferenceArray, t, dPM, B);
        } else if (b(atomicReferenceArray, B(1 + dPM, i)) == null) {
            return a(atomicReferenceArray, t, dPM, B);
        } else {
            a(atomicReferenceArray, dPM, B, t, i);
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
        this.nMu = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nMx);
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.nMw;
        long dPN = dPN();
        int i = this.nMv;
        int B = B(dPN, i);
        T t = (T) b(atomicReferenceArray, B);
        boolean z = t == nMx;
        if (t != null && !z) {
            a(atomicReferenceArray, B, (Object) null);
            soConsumerIndex(1 + dPN);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), dPN, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nMw = atomicReferenceArray;
        int B = B(j, i);
        T t = (T) b(atomicReferenceArray, B);
        if (t != null) {
            a(atomicReferenceArray, B, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nMw;
        long dPN = dPN();
        int i = this.nMv;
        T t = (T) b(atomicReferenceArray, B(dPN, i));
        if (t == nMx) {
            return b(a(atomicReferenceArray, i + 1), dPN, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nMw = atomicReferenceArray;
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
        long dPL = dPL();
        while (true) {
            long dPK = dPK();
            long dPL2 = dPL();
            if (dPL == dPL2) {
                return (int) (dPK - dPL2);
            }
            dPL = dPL2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return dPK() == dPL();
    }

    private void KR(int i) {
        this.nMs = Math.min(i / 4, nMr);
    }

    private long dPK() {
        return this.producerIndex.get();
    }

    private long dPL() {
        return this.consumerIndex.get();
    }

    private long dPM() {
        return this.producerIndex.get();
    }

    private long dPN() {
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.nMu;
        long dPK = dPK();
        int i = this.nMt;
        if (b(atomicReferenceArray, B(dPK + 2, i)) == null) {
            int B = B(dPK, i);
            a(atomicReferenceArray, B + 1, t2);
            a(atomicReferenceArray, B, t);
            soProducerIndex(dPK + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.nMu = atomicReferenceArray2;
        int B2 = B(dPK, i);
        a(atomicReferenceArray2, B2 + 1, t2);
        a(atomicReferenceArray2, B2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, B2, nMx);
        soProducerIndex(dPK + 2);
        return true;
    }
}
