package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class a<T> implements f<T> {
    static final int nyW = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nzc = new Object();
    int nyX;
    final int nyY;
    AtomicReferenceArray<Object> nyZ;
    final int nza;
    AtomicReferenceArray<Object> nzb;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int NA = h.NA(Math.max(8, i));
        int i2 = NA - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(NA + 1);
        this.nyZ = atomicReferenceArray;
        this.nyY = i2;
        Nx(NA);
        this.nzb = atomicReferenceArray;
        this.nza = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyZ;
        long dJy = dJy();
        int i = this.nyY;
        int E = E(dJy, i);
        if (dJy < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dJy, E);
        }
        int i2 = this.nyX;
        if (b(atomicReferenceArray, E(i2 + dJy, i)) == null) {
            this.producerLookAhead = (i2 + dJy) - 1;
            return a(atomicReferenceArray, t, dJy, E);
        } else if (b(atomicReferenceArray, E(1 + dJy, i)) == null) {
            return a(atomicReferenceArray, t, dJy, E);
        } else {
            a(atomicReferenceArray, dJy, E, t, i);
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
        this.nyZ = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nzc);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Ny(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int Ny = Ny(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, Ny);
        a(atomicReferenceArray, Ny, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nzb;
        long dJz = dJz();
        int i = this.nza;
        int E = E(dJz, i);
        T t = (T) b(atomicReferenceArray, E);
        boolean z = t == nzc;
        if (t != null && !z) {
            a(atomicReferenceArray, E, (Object) null);
            soConsumerIndex(1 + dJz);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), dJz, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nzb = atomicReferenceArray;
        int E = E(j, i);
        T t = (T) b(atomicReferenceArray, E);
        if (t != null) {
            a(atomicReferenceArray, E, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nzb;
        long dJz = dJz();
        int i = this.nza;
        T t = (T) b(atomicReferenceArray, E(dJz, i));
        if (t == nzc) {
            return b(a(atomicReferenceArray, i + 1), dJz, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nzb = atomicReferenceArray;
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
        long dJx = dJx();
        while (true) {
            long dJw = dJw();
            long dJx2 = dJx();
            if (dJx == dJx2) {
                return (int) (dJw - dJx2);
            }
            dJx = dJx2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return dJw() == dJx();
    }

    private void Nx(int i) {
        this.nyX = Math.min(i / 4, nyW);
    }

    private long dJw() {
        return this.producerIndex.get();
    }

    private long dJx() {
        return this.consumerIndex.get();
    }

    private long dJy() {
        return this.producerIndex.get();
    }

    private long dJz() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int E(long j, int i) {
        return Ny(((int) j) & i);
    }

    private static int Ny(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyZ;
        long dJw = dJw();
        int i = this.nyY;
        if (b(atomicReferenceArray, E(dJw + 2, i)) == null) {
            int E = E(dJw, i);
            a(atomicReferenceArray, E + 1, t2);
            a(atomicReferenceArray, E, t);
            soProducerIndex(dJw + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.nyZ = atomicReferenceArray2;
        int E2 = E(dJw, i);
        a(atomicReferenceArray2, E2 + 1, t2);
        a(atomicReferenceArray2, E2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, E2, nzc);
        soProducerIndex(dJw + 2);
        return true;
    }
}
