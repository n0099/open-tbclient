package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class a<T> implements f<T> {
    static final int nVb = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nVh = new Object();
    int nVc;
    final int nVd;
    AtomicReferenceArray<Object> nVe;
    final int nVf;
    AtomicReferenceArray<Object> nVg;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int Lo = h.Lo(Math.max(8, i));
        int i2 = Lo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Lo + 1);
        this.nVe = atomicReferenceArray;
        this.nVd = i2;
        Ll(Lo);
        this.nVg = atomicReferenceArray;
        this.nVf = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.nVe;
        long dTj = dTj();
        int i = this.nVd;
        int C = C(dTj, i);
        if (dTj < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dTj, C);
        }
        int i2 = this.nVc;
        if (b(atomicReferenceArray, C(i2 + dTj, i)) == null) {
            this.producerLookAhead = (i2 + dTj) - 1;
            return a(atomicReferenceArray, t, dTj, C);
        } else if (b(atomicReferenceArray, C(1 + dTj, i)) == null) {
            return a(atomicReferenceArray, t, dTj, C);
        } else {
            a(atomicReferenceArray, dTj, C, t, i);
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
        this.nVe = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nVh);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Lm(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int Lm = Lm(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, Lm);
        a(atomicReferenceArray, Lm, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nVg;
        long dTk = dTk();
        int i = this.nVf;
        int C = C(dTk, i);
        T t = (T) b(atomicReferenceArray, C);
        boolean z = t == nVh;
        if (t != null && !z) {
            a(atomicReferenceArray, C, (Object) null);
            soConsumerIndex(1 + dTk);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), dTk, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nVg = atomicReferenceArray;
        int C = C(j, i);
        T t = (T) b(atomicReferenceArray, C);
        if (t != null) {
            a(atomicReferenceArray, C, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nVg;
        long dTk = dTk();
        int i = this.nVf;
        T t = (T) b(atomicReferenceArray, C(dTk, i));
        if (t == nVh) {
            return b(a(atomicReferenceArray, i + 1), dTk, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nVg = atomicReferenceArray;
        return (T) b(atomicReferenceArray, C(j, i));
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
        long dTi = dTi();
        while (true) {
            long dTh = dTh();
            long dTi2 = dTi();
            if (dTi == dTi2) {
                return (int) (dTh - dTi2);
            }
            dTi = dTi2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return dTh() == dTi();
    }

    private void Ll(int i) {
        this.nVc = Math.min(i / 4, nVb);
    }

    private long dTh() {
        return this.producerIndex.get();
    }

    private long dTi() {
        return this.consumerIndex.get();
    }

    private long dTj() {
        return this.producerIndex.get();
    }

    private long dTk() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int C(long j, int i) {
        return Lm(((int) j) & i);
    }

    private static int Lm(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nVe;
        long dTh = dTh();
        int i = this.nVd;
        if (b(atomicReferenceArray, C(dTh + 2, i)) == null) {
            int C = C(dTh, i);
            a(atomicReferenceArray, C + 1, t2);
            a(atomicReferenceArray, C, t);
            soProducerIndex(dTh + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.nVe = atomicReferenceArray2;
        int C2 = C(dTh, i);
        a(atomicReferenceArray2, C2 + 1, t2);
        a(atomicReferenceArray2, C2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, C2, nVh);
        soProducerIndex(dTh + 2);
        return true;
    }
}
