package io.reactivex.internal.queue;

import io.reactivex.internal.a.e;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes5.dex */
public final class a<T> implements e<T> {
    static final int qqL = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qqR = new Object();
    long producerLookAhead;
    int qqM;
    final int qqN;
    AtomicReferenceArray<Object> qqO;
    final int qqP;
    AtomicReferenceArray<Object> qqQ;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int Sp = h.Sp(Math.max(8, i));
        int i2 = Sp - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Sp + 1);
        this.qqO = atomicReferenceArray;
        this.qqN = i2;
        Sm(Sp);
        this.qqQ = atomicReferenceArray;
        this.qqP = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqO;
        long eKE = eKE();
        int i = this.qqN;
        int O = O(eKE, i);
        if (eKE < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eKE, O);
        }
        int i2 = this.qqM;
        if (b(atomicReferenceArray, O(i2 + eKE, i)) == null) {
            this.producerLookAhead = (i2 + eKE) - 1;
            return a(atomicReferenceArray, t, eKE, O);
        } else if (b(atomicReferenceArray, O(1 + eKE, i)) == null) {
            return a(atomicReferenceArray, t, eKE, O);
        } else {
            a(atomicReferenceArray, eKE, O, t, i);
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
        this.qqO = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, qqR);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Sn(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int Sn = Sn(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, Sn);
        a(atomicReferenceArray, Sn, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.e, io.reactivex.internal.a.f
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqQ;
        long eKF = eKF();
        int i = this.qqP;
        int O = O(eKF, i);
        T t = (T) b(atomicReferenceArray, O);
        boolean z = t == qqR;
        if (t != null && !z) {
            a(atomicReferenceArray, O, (Object) null);
            soConsumerIndex(1 + eKF);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), eKF, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qqQ = atomicReferenceArray;
        int O = O(j, i);
        T t = (T) b(atomicReferenceArray, O);
        if (t != null) {
            a(atomicReferenceArray, O, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqQ;
        long eKF = eKF();
        int i = this.qqP;
        T t = (T) b(atomicReferenceArray, O(eKF, i));
        if (t == qqR) {
            return b(a(atomicReferenceArray, i + 1), eKF, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qqQ = atomicReferenceArray;
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
        long eKD = eKD();
        while (true) {
            long eKC = eKC();
            long eKD2 = eKD();
            if (eKD == eKD2) {
                return (int) (eKC - eKD2);
            }
            eKD = eKD2;
        }
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return eKC() == eKD();
    }

    private void Sm(int i) {
        this.qqM = Math.min(i / 4, qqL);
    }

    private long eKC() {
        return this.producerIndex.get();
    }

    private long eKD() {
        return this.consumerIndex.get();
    }

    private long eKE() {
        return this.producerIndex.get();
    }

    private long eKF() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int O(long j, int i) {
        return Sn(((int) j) & i);
    }

    private static int Sn(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qqO;
        long eKC = eKC();
        int i = this.qqN;
        if (b(atomicReferenceArray, O(eKC + 2, i)) == null) {
            int O = O(eKC, i);
            a(atomicReferenceArray, O + 1, t2);
            a(atomicReferenceArray, O, t);
            soProducerIndex(eKC + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.qqO = atomicReferenceArray2;
        int O2 = O(eKC, i);
        a(atomicReferenceArray2, O2 + 1, t2);
        a(atomicReferenceArray2, O2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, O2, qqR);
        soProducerIndex(eKC + 2);
        return true;
    }
}
