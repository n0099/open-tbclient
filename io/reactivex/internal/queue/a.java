package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class a<T> implements f<T> {
    static final int mUo = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object mUu = new Object();
    int mUp;
    final int mUq;
    AtomicReferenceArray<Object> mUr;
    final int mUs;
    AtomicReferenceArray<Object> mUt;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int Ja = h.Ja(Math.max(8, i));
        int i2 = Ja - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Ja + 1);
        this.mUr = atomicReferenceArray;
        this.mUq = i2;
        IX(Ja);
        this.mUt = atomicReferenceArray;
        this.mUs = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.mUr;
        long dCT = dCT();
        int i = this.mUq;
        int B = B(dCT, i);
        if (dCT < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dCT, B);
        }
        int i2 = this.mUp;
        if (b(atomicReferenceArray, B(i2 + dCT, i)) == null) {
            this.producerLookAhead = (i2 + dCT) - 1;
            return a(atomicReferenceArray, t, dCT, B);
        } else if (b(atomicReferenceArray, B(1 + dCT, i)) == null) {
            return a(atomicReferenceArray, t, dCT, B);
        } else {
            a(atomicReferenceArray, dCT, B, t, i);
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
        this.mUr = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, mUu);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, IY(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int IY = IY(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, IY);
        a(atomicReferenceArray, IY, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.mUt;
        long dCU = dCU();
        int i = this.mUs;
        int B = B(dCU, i);
        T t = (T) b(atomicReferenceArray, B);
        boolean z = t == mUu;
        if (t != null && !z) {
            a(atomicReferenceArray, B, (Object) null);
            soConsumerIndex(1 + dCU);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), dCU, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.mUt = atomicReferenceArray;
        int B = B(j, i);
        T t = (T) b(atomicReferenceArray, B);
        if (t != null) {
            a(atomicReferenceArray, B, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.mUt;
        long dCU = dCU();
        int i = this.mUs;
        T t = (T) b(atomicReferenceArray, B(dCU, i));
        if (t == mUu) {
            return b(a(atomicReferenceArray, i + 1), dCU, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.mUt = atomicReferenceArray;
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
        long dCS = dCS();
        while (true) {
            long dCR = dCR();
            long dCS2 = dCS();
            if (dCS == dCS2) {
                return (int) (dCR - dCS2);
            }
            dCS = dCS2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return dCR() == dCS();
    }

    private void IX(int i) {
        this.mUp = Math.min(i / 4, mUo);
    }

    private long dCR() {
        return this.producerIndex.get();
    }

    private long dCS() {
        return this.consumerIndex.get();
    }

    private long dCT() {
        return this.producerIndex.get();
    }

    private long dCU() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int B(long j, int i) {
        return IY(((int) j) & i);
    }

    private static int IY(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.mUr;
        long dCR = dCR();
        int i = this.mUq;
        if (b(atomicReferenceArray, B(dCR + 2, i)) == null) {
            int B = B(dCR, i);
            a(atomicReferenceArray, B + 1, t2);
            a(atomicReferenceArray, B, t);
            soProducerIndex(dCR + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.mUr = atomicReferenceArray2;
        int B2 = B(dCR, i);
        a(atomicReferenceArray2, B2 + 1, t2);
        a(atomicReferenceArray2, B2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, B2, mUu);
        soProducerIndex(dCR + 2);
        return true;
    }
}
