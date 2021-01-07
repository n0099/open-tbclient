package io.reactivex.internal.queue;

import io.reactivex.internal.a.e;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes5.dex */
public final class a<T> implements e<T> {
    static final int qkI = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qkO = new Object();
    long producerLookAhead;
    int qkJ;
    final int qkK;
    AtomicReferenceArray<Object> qkL;
    final int qkM;
    AtomicReferenceArray<Object> qkN;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int TA = h.TA(Math.max(8, i));
        int i2 = TA - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(TA + 1);
        this.qkL = atomicReferenceArray;
        this.qkK = i2;
        Tx(TA);
        this.qkN = atomicReferenceArray;
        this.qkM = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.qkL;
        long eLW = eLW();
        int i = this.qkK;
        int Q = Q(eLW, i);
        if (eLW < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eLW, Q);
        }
        int i2 = this.qkJ;
        if (b(atomicReferenceArray, Q(i2 + eLW, i)) == null) {
            this.producerLookAhead = (i2 + eLW) - 1;
            return a(atomicReferenceArray, t, eLW, Q);
        } else if (b(atomicReferenceArray, Q(1 + eLW, i)) == null) {
            return a(atomicReferenceArray, t, eLW, Q);
        } else {
            a(atomicReferenceArray, eLW, Q, t, i);
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
        this.qkL = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, qkO);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Ty(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int Ty = Ty(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, Ty);
        a(atomicReferenceArray, Ty, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.e, io.reactivex.internal.a.f
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qkN;
        long eLX = eLX();
        int i = this.qkM;
        int Q = Q(eLX, i);
        T t = (T) b(atomicReferenceArray, Q);
        boolean z = t == qkO;
        if (t != null && !z) {
            a(atomicReferenceArray, Q, (Object) null);
            soConsumerIndex(1 + eLX);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), eLX, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qkN = atomicReferenceArray;
        int Q = Q(j, i);
        T t = (T) b(atomicReferenceArray, Q);
        if (t != null) {
            a(atomicReferenceArray, Q, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qkN;
        long eLX = eLX();
        int i = this.qkM;
        T t = (T) b(atomicReferenceArray, Q(eLX, i));
        if (t == qkO) {
            return b(a(atomicReferenceArray, i + 1), eLX, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qkN = atomicReferenceArray;
        return (T) b(atomicReferenceArray, Q(j, i));
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
        long eLV = eLV();
        while (true) {
            long eLU = eLU();
            long eLV2 = eLV();
            if (eLV == eLV2) {
                return (int) (eLU - eLV2);
            }
            eLV = eLV2;
        }
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return eLU() == eLV();
    }

    private void Tx(int i) {
        this.qkJ = Math.min(i / 4, qkI);
    }

    private long eLU() {
        return this.producerIndex.get();
    }

    private long eLV() {
        return this.consumerIndex.get();
    }

    private long eLW() {
        return this.producerIndex.get();
    }

    private long eLX() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int Q(long j, int i) {
        return Ty(((int) j) & i);
    }

    private static int Ty(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qkL;
        long eLU = eLU();
        int i = this.qkK;
        if (b(atomicReferenceArray, Q(eLU + 2, i)) == null) {
            int Q = Q(eLU, i);
            a(atomicReferenceArray, Q + 1, t2);
            a(atomicReferenceArray, Q, t);
            soProducerIndex(eLU + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.qkL = atomicReferenceArray2;
        int Q2 = Q(eLU, i);
        a(atomicReferenceArray2, Q2 + 1, t2);
        a(atomicReferenceArray2, Q2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, Q2, qkO);
        soProducerIndex(eLU + 2);
        return true;
    }
}
