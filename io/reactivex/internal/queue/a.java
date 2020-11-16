package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes5.dex */
public final class a<T> implements f<T> {
    static final int pQH = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object pQN = new Object();
    int pQI;
    final int pQJ;
    AtomicReferenceArray<Object> pQK;
    final int pQL;
    AtomicReferenceArray<Object> pQM;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int RR = h.RR(Math.max(8, i));
        int i2 = RR - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(RR + 1);
        this.pQK = atomicReferenceArray;
        this.pQJ = i2;
        RO(RR);
        this.pQM = atomicReferenceArray;
        this.pQL = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.pQK;
        long eAS = eAS();
        int i = this.pQJ;
        int N = N(eAS, i);
        if (eAS < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eAS, N);
        }
        int i2 = this.pQI;
        if (b(atomicReferenceArray, N(i2 + eAS, i)) == null) {
            this.producerLookAhead = (i2 + eAS) - 1;
            return a(atomicReferenceArray, t, eAS, N);
        } else if (b(atomicReferenceArray, N(1 + eAS, i)) == null) {
            return a(atomicReferenceArray, t, eAS, N);
        } else {
            a(atomicReferenceArray, eAS, N, t, i);
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
        this.pQK = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, pQN);
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

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pQM;
        long eAT = eAT();
        int i = this.pQL;
        int N = N(eAT, i);
        T t = (T) b(atomicReferenceArray, N);
        boolean z = t == pQN;
        if (t != null && !z) {
            a(atomicReferenceArray, N, (Object) null);
            soConsumerIndex(1 + eAT);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), eAT, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.pQM = atomicReferenceArray;
        int N = N(j, i);
        T t = (T) b(atomicReferenceArray, N);
        if (t != null) {
            a(atomicReferenceArray, N, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pQM;
        long eAT = eAT();
        int i = this.pQL;
        T t = (T) b(atomicReferenceArray, N(eAT, i));
        if (t == pQN) {
            return b(a(atomicReferenceArray, i + 1), eAT, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.pQM = atomicReferenceArray;
        return (T) b(atomicReferenceArray, N(j, i));
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
        long eAR = eAR();
        while (true) {
            long eAQ = eAQ();
            long eAR2 = eAR();
            if (eAR == eAR2) {
                return (int) (eAQ - eAR2);
            }
            eAR = eAR2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return eAQ() == eAR();
    }

    private void RO(int i) {
        this.pQI = Math.min(i / 4, pQH);
    }

    private long eAQ() {
        return this.producerIndex.get();
    }

    private long eAR() {
        return this.consumerIndex.get();
    }

    private long eAS() {
        return this.producerIndex.get();
    }

    private long eAT() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int N(long j, int i) {
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.pQK;
        long eAQ = eAQ();
        int i = this.pQJ;
        if (b(atomicReferenceArray, N(eAQ + 2, i)) == null) {
            int N = N(eAQ, i);
            a(atomicReferenceArray, N + 1, t2);
            a(atomicReferenceArray, N, t);
            soProducerIndex(eAQ + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.pQK = atomicReferenceArray2;
        int N2 = N(eAQ, i);
        a(atomicReferenceArray2, N2 + 1, t2);
        a(atomicReferenceArray2, N2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, N2, pQN);
        soProducerIndex(eAQ + 2);
        return true;
    }
}
