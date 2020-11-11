package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes17.dex */
public final class a<T> implements f<T> {
    static final int pPe = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object pPk = new Object();
    int pPf;
    final int pPg;
    AtomicReferenceArray<Object> pPh;
    final int pPi;
    AtomicReferenceArray<Object> pPj;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int Ro = h.Ro(Math.max(8, i));
        int i2 = Ro - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Ro + 1);
        this.pPh = atomicReferenceArray;
        this.pPg = i2;
        Rl(Ro);
        this.pPj = atomicReferenceArray;
        this.pPi = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.pPh;
        long eAR = eAR();
        int i = this.pPg;
        int N = N(eAR, i);
        if (eAR < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eAR, N);
        }
        int i2 = this.pPf;
        if (b(atomicReferenceArray, N(i2 + eAR, i)) == null) {
            this.producerLookAhead = (i2 + eAR) - 1;
            return a(atomicReferenceArray, t, eAR, N);
        } else if (b(atomicReferenceArray, N(1 + eAR, i)) == null) {
            return a(atomicReferenceArray, t, eAR, N);
        } else {
            a(atomicReferenceArray, eAR, N, t, i);
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
        this.pPh = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, pPk);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Rm(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int Rm = Rm(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, Rm);
        a(atomicReferenceArray, Rm, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pPj;
        long eAS = eAS();
        int i = this.pPi;
        int N = N(eAS, i);
        T t = (T) b(atomicReferenceArray, N);
        boolean z = t == pPk;
        if (t != null && !z) {
            a(atomicReferenceArray, N, (Object) null);
            soConsumerIndex(1 + eAS);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), eAS, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.pPj = atomicReferenceArray;
        int N = N(j, i);
        T t = (T) b(atomicReferenceArray, N);
        if (t != null) {
            a(atomicReferenceArray, N, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pPj;
        long eAS = eAS();
        int i = this.pPi;
        T t = (T) b(atomicReferenceArray, N(eAS, i));
        if (t == pPk) {
            return b(a(atomicReferenceArray, i + 1), eAS, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.pPj = atomicReferenceArray;
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
        long eAQ = eAQ();
        while (true) {
            long eAP = eAP();
            long eAQ2 = eAQ();
            if (eAQ == eAQ2) {
                return (int) (eAP - eAQ2);
            }
            eAQ = eAQ2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return eAP() == eAQ();
    }

    private void Rl(int i) {
        this.pPf = Math.min(i / 4, pPe);
    }

    private long eAP() {
        return this.producerIndex.get();
    }

    private long eAQ() {
        return this.consumerIndex.get();
    }

    private long eAR() {
        return this.producerIndex.get();
    }

    private long eAS() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int N(long j, int i) {
        return Rm(((int) j) & i);
    }

    private static int Rm(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.pPh;
        long eAP = eAP();
        int i = this.pPg;
        if (b(atomicReferenceArray, N(eAP + 2, i)) == null) {
            int N = N(eAP, i);
            a(atomicReferenceArray, N + 1, t2);
            a(atomicReferenceArray, N, t);
            soProducerIndex(eAP + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.pPh = atomicReferenceArray2;
        int N2 = N(eAP, i);
        a(atomicReferenceArray2, N2 + 1, t2);
        a(atomicReferenceArray2, N2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, N2, pPk);
        soProducerIndex(eAP + 2);
        return true;
    }
}
