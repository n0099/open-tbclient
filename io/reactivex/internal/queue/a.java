package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes5.dex */
public final class a<T> implements f<T> {
    static final int nyh = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nyn = new Object();
    int nyi;
    final int nyj;
    AtomicReferenceArray<Object> nyk;
    final int nyl;
    AtomicReferenceArray<Object> nym;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int Nx = h.Nx(Math.max(8, i));
        int i2 = Nx - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Nx + 1);
        this.nyk = atomicReferenceArray;
        this.nyj = i2;
        Nu(Nx);
        this.nym = atomicReferenceArray;
        this.nyl = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyk;
        long dIo = dIo();
        int i = this.nyj;
        int E = E(dIo, i);
        if (dIo < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dIo, E);
        }
        int i2 = this.nyi;
        if (b(atomicReferenceArray, E(i2 + dIo, i)) == null) {
            this.producerLookAhead = (i2 + dIo) - 1;
            return a(atomicReferenceArray, t, dIo, E);
        } else if (b(atomicReferenceArray, E(1 + dIo, i)) == null) {
            return a(atomicReferenceArray, t, dIo, E);
        } else {
            a(atomicReferenceArray, dIo, E, t, i);
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
        this.nyk = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nyn);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Nv(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int Nv = Nv(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, Nv);
        a(atomicReferenceArray, Nv, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nym;
        long dIp = dIp();
        int i = this.nyl;
        int E = E(dIp, i);
        T t = (T) b(atomicReferenceArray, E);
        boolean z = t == nyn;
        if (t != null && !z) {
            a(atomicReferenceArray, E, (Object) null);
            soConsumerIndex(1 + dIp);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), dIp, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nym = atomicReferenceArray;
        int E = E(j, i);
        T t = (T) b(atomicReferenceArray, E);
        if (t != null) {
            a(atomicReferenceArray, E, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nym;
        long dIp = dIp();
        int i = this.nyl;
        T t = (T) b(atomicReferenceArray, E(dIp, i));
        if (t == nyn) {
            return b(a(atomicReferenceArray, i + 1), dIp, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nym = atomicReferenceArray;
        return (T) b(atomicReferenceArray, E(j, i));
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
        long dIn = dIn();
        while (true) {
            long dIm = dIm();
            long dIn2 = dIn();
            if (dIn == dIn2) {
                return (int) (dIm - dIn2);
            }
            dIn = dIn2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return dIm() == dIn();
    }

    private void Nu(int i) {
        this.nyi = Math.min(i / 4, nyh);
    }

    private long dIm() {
        return this.producerIndex.get();
    }

    private long dIn() {
        return this.consumerIndex.get();
    }

    private long dIo() {
        return this.producerIndex.get();
    }

    private long dIp() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int E(long j, int i) {
        return Nv(((int) j) & i);
    }

    private static int Nv(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyk;
        long dIm = dIm();
        int i = this.nyj;
        if (b(atomicReferenceArray, E(dIm + 2, i)) == null) {
            int E = E(dIm, i);
            a(atomicReferenceArray, E + 1, t2);
            a(atomicReferenceArray, E, t);
            soProducerIndex(dIm + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.nyk = atomicReferenceArray2;
        int E2 = E(dIm, i);
        a(atomicReferenceArray2, E2 + 1, t2);
        a(atomicReferenceArray2, E2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, E2, nyn);
        soProducerIndex(dIm + 2);
        return true;
    }
}
