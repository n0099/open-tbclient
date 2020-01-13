package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes5.dex */
public final class a<T> implements f<T> {
    static final int nyc = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nyi = new Object();
    int nyd;
    final int nye;
    AtomicReferenceArray<Object> nyf;
    final int nyg;
    AtomicReferenceArray<Object> nyh;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int Nx = h.Nx(Math.max(8, i));
        int i2 = Nx - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Nx + 1);
        this.nyf = atomicReferenceArray;
        this.nye = i2;
        Nu(Nx);
        this.nyh = atomicReferenceArray;
        this.nyg = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyf;
        long dIm = dIm();
        int i = this.nye;
        int E = E(dIm, i);
        if (dIm < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dIm, E);
        }
        int i2 = this.nyd;
        if (b(atomicReferenceArray, E(i2 + dIm, i)) == null) {
            this.producerLookAhead = (i2 + dIm) - 1;
            return a(atomicReferenceArray, t, dIm, E);
        } else if (b(atomicReferenceArray, E(1 + dIm, i)) == null) {
            return a(atomicReferenceArray, t, dIm, E);
        } else {
            a(atomicReferenceArray, dIm, E, t, i);
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
        this.nyf = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nyi);
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyh;
        long dIn = dIn();
        int i = this.nyg;
        int E = E(dIn, i);
        T t = (T) b(atomicReferenceArray, E);
        boolean z = t == nyi;
        if (t != null && !z) {
            a(atomicReferenceArray, E, (Object) null);
            soConsumerIndex(1 + dIn);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), dIn, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nyh = atomicReferenceArray;
        int E = E(j, i);
        T t = (T) b(atomicReferenceArray, E);
        if (t != null) {
            a(atomicReferenceArray, E, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyh;
        long dIn = dIn();
        int i = this.nyg;
        T t = (T) b(atomicReferenceArray, E(dIn, i));
        if (t == nyi) {
            return b(a(atomicReferenceArray, i + 1), dIn, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nyh = atomicReferenceArray;
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
        long dIl = dIl();
        while (true) {
            long dIk = dIk();
            long dIl2 = dIl();
            if (dIl == dIl2) {
                return (int) (dIk - dIl2);
            }
            dIl = dIl2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return dIk() == dIl();
    }

    private void Nu(int i) {
        this.nyd = Math.min(i / 4, nyc);
    }

    private long dIk() {
        return this.producerIndex.get();
    }

    private long dIl() {
        return this.consumerIndex.get();
    }

    private long dIm() {
        return this.producerIndex.get();
    }

    private long dIn() {
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyf;
        long dIk = dIk();
        int i = this.nye;
        if (b(atomicReferenceArray, E(dIk + 2, i)) == null) {
            int E = E(dIk, i);
            a(atomicReferenceArray, E + 1, t2);
            a(atomicReferenceArray, E, t);
            soProducerIndex(dIk + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.nyf = atomicReferenceArray2;
        int E2 = E(dIk, i);
        a(atomicReferenceArray2, E2 + 1, t2);
        a(atomicReferenceArray2, E2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, E2, nyi);
        soProducerIndex(dIk + 2);
        return true;
    }
}
