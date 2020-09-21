package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes25.dex */
public final class a<T> implements f<T> {
    static final int oyY = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object oze = new Object();
    int oyZ;
    final int oza;
    AtomicReferenceArray<Object> ozb;
    final int ozc;
    AtomicReferenceArray<Object> ozd;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int Ow = h.Ow(Math.max(8, i));
        int i2 = Ow - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Ow + 1);
        this.ozb = atomicReferenceArray;
        this.oza = i2;
        Ot(Ow);
        this.ozd = atomicReferenceArray;
        this.ozc = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.ozb;
        long ejr = ejr();
        int i = this.oza;
        int F = F(ejr, i);
        if (ejr < this.producerLookAhead) {
            return a(atomicReferenceArray, t, ejr, F);
        }
        int i2 = this.oyZ;
        if (b(atomicReferenceArray, F(i2 + ejr, i)) == null) {
            this.producerLookAhead = (i2 + ejr) - 1;
            return a(atomicReferenceArray, t, ejr, F);
        } else if (b(atomicReferenceArray, F(1 + ejr, i)) == null) {
            return a(atomicReferenceArray, t, ejr, F);
        } else {
            a(atomicReferenceArray, ejr, F, t, i);
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
        this.ozb = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, oze);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Ou(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int Ou = Ou(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, Ou);
        a(atomicReferenceArray, Ou, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.ozd;
        long ejs = ejs();
        int i = this.ozc;
        int F = F(ejs, i);
        T t = (T) b(atomicReferenceArray, F);
        boolean z = t == oze;
        if (t != null && !z) {
            a(atomicReferenceArray, F, (Object) null);
            soConsumerIndex(1 + ejs);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), ejs, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.ozd = atomicReferenceArray;
        int F = F(j, i);
        T t = (T) b(atomicReferenceArray, F);
        if (t != null) {
            a(atomicReferenceArray, F, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.ozd;
        long ejs = ejs();
        int i = this.ozc;
        T t = (T) b(atomicReferenceArray, F(ejs, i));
        if (t == oze) {
            return b(a(atomicReferenceArray, i + 1), ejs, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.ozd = atomicReferenceArray;
        return (T) b(atomicReferenceArray, F(j, i));
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
        long ejq = ejq();
        while (true) {
            long ejp = ejp();
            long ejq2 = ejq();
            if (ejq == ejq2) {
                return (int) (ejp - ejq2);
            }
            ejq = ejq2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return ejp() == ejq();
    }

    private void Ot(int i) {
        this.oyZ = Math.min(i / 4, oyY);
    }

    private long ejp() {
        return this.producerIndex.get();
    }

    private long ejq() {
        return this.consumerIndex.get();
    }

    private long ejr() {
        return this.producerIndex.get();
    }

    private long ejs() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int F(long j, int i) {
        return Ou(((int) j) & i);
    }

    private static int Ou(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.ozb;
        long ejp = ejp();
        int i = this.oza;
        if (b(atomicReferenceArray, F(ejp + 2, i)) == null) {
            int F = F(ejp, i);
            a(atomicReferenceArray, F + 1, t2);
            a(atomicReferenceArray, F, t);
            soProducerIndex(ejp + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.ozb = atomicReferenceArray2;
        int F2 = F(ejp, i);
        a(atomicReferenceArray2, F2 + 1, t2);
        a(atomicReferenceArray2, F2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, F2, oze);
        soProducerIndex(ejp + 2);
        return true;
    }
}
