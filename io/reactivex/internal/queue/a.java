package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class a<T> implements f<T> {
    static final int nyL = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nyR = new Object();
    int nyM;
    final int nyN;
    AtomicReferenceArray<Object> nyO;
    final int nyP;
    AtomicReferenceArray<Object> nyQ;
    long producerLookAhead;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int NA = h.NA(Math.max(8, i));
        int i2 = NA - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(NA + 1);
        this.nyO = atomicReferenceArray;
        this.nyN = i2;
        Nx(NA);
        this.nyQ = atomicReferenceArray;
        this.nyP = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyO;
        long dJx = dJx();
        int i = this.nyN;
        int E = E(dJx, i);
        if (dJx < this.producerLookAhead) {
            return a(atomicReferenceArray, t, dJx, E);
        }
        int i2 = this.nyM;
        if (b(atomicReferenceArray, E(i2 + dJx, i)) == null) {
            this.producerLookAhead = (i2 + dJx) - 1;
            return a(atomicReferenceArray, t, dJx, E);
        } else if (b(atomicReferenceArray, E(1 + dJx, i)) == null) {
            return a(atomicReferenceArray, t, dJx, E);
        } else {
            a(atomicReferenceArray, dJx, E, t, i);
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
        this.nyO = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, nyR);
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyQ;
        long dJy = dJy();
        int i = this.nyP;
        int E = E(dJy, i);
        T t = (T) b(atomicReferenceArray, E);
        boolean z = t == nyR;
        if (t != null && !z) {
            a(atomicReferenceArray, E, (Object) null);
            soConsumerIndex(1 + dJy);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), dJy, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nyQ = atomicReferenceArray;
        int E = E(j, i);
        T t = (T) b(atomicReferenceArray, E);
        if (t != null) {
            a(atomicReferenceArray, E, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyQ;
        long dJy = dJy();
        int i = this.nyP;
        T t = (T) b(atomicReferenceArray, E(dJy, i));
        if (t == nyR) {
            return b(a(atomicReferenceArray, i + 1), dJy, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.nyQ = atomicReferenceArray;
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
        long dJw = dJw();
        while (true) {
            long dJv = dJv();
            long dJw2 = dJw();
            if (dJw == dJw2) {
                return (int) (dJv - dJw2);
            }
            dJw = dJw2;
        }
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return dJv() == dJw();
    }

    private void Nx(int i) {
        this.nyM = Math.min(i / 4, nyL);
    }

    private long dJv() {
        return this.producerIndex.get();
    }

    private long dJw() {
        return this.consumerIndex.get();
    }

    private long dJx() {
        return this.producerIndex.get();
    }

    private long dJy() {
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
        AtomicReferenceArray<Object> atomicReferenceArray = this.nyO;
        long dJv = dJv();
        int i = this.nyN;
        if (b(atomicReferenceArray, E(dJv + 2, i)) == null) {
            int E = E(dJv, i);
            a(atomicReferenceArray, E + 1, t2);
            a(atomicReferenceArray, E, t);
            soProducerIndex(dJv + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.nyO = atomicReferenceArray2;
        int E2 = E(dJv, i);
        a(atomicReferenceArray2, E2 + 1, t2);
        a(atomicReferenceArray2, E2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, E2, nyR);
        soProducerIndex(dJv + 2);
        return true;
    }
}
