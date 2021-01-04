package io.reactivex.internal.queue;

import io.reactivex.internal.a.e;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes3.dex */
public final class a<T> implements e<T> {
    static final int qja = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qjg = new Object();
    long producerLookAhead;
    int qjb;
    final int qjc;
    AtomicReferenceArray<Object> qjd;
    final int qje;
    AtomicReferenceArray<Object> qjf;
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public a(int i) {
        int Tk = h.Tk(Math.max(8, i));
        int i2 = Tk - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(Tk + 1);
        this.qjd = atomicReferenceArray;
        this.qjc = i2;
        Th(Tk);
        this.qjf = atomicReferenceArray;
        this.qje = i2;
        this.producerLookAhead = i2 - 1;
        soProducerIndex(0L);
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.qjd;
        long eLs = eLs();
        int i = this.qjc;
        int N = N(eLs, i);
        if (eLs < this.producerLookAhead) {
            return a(atomicReferenceArray, t, eLs, N);
        }
        int i2 = this.qjb;
        if (b(atomicReferenceArray, N(i2 + eLs, i)) == null) {
            this.producerLookAhead = (i2 + eLs) - 1;
            return a(atomicReferenceArray, t, eLs, N);
        } else if (b(atomicReferenceArray, N(1 + eLs, i)) == null) {
            return a(atomicReferenceArray, t, eLs, N);
        } else {
            a(atomicReferenceArray, eLs, N, t, i);
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
        this.qjd = atomicReferenceArray2;
        this.producerLookAhead = (j + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, qjg);
        soProducerIndex(j + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, Ti(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int Ti = Ti(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, Ti);
        a(atomicReferenceArray, Ti, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // io.reactivex.internal.a.e, io.reactivex.internal.a.f
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qjf;
        long eLt = eLt();
        int i = this.qje;
        int N = N(eLt, i);
        T t = (T) b(atomicReferenceArray, N);
        boolean z = t == qjg;
        if (t != null && !z) {
            a(atomicReferenceArray, N, (Object) null);
            soConsumerIndex(1 + eLt);
            return t;
        } else if (z) {
            return a(a(atomicReferenceArray, i + 1), eLt, i);
        } else {
            return null;
        }
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qjf = atomicReferenceArray;
        int N = N(j, i);
        T t = (T) b(atomicReferenceArray, N);
        if (t != null) {
            a(atomicReferenceArray, N, (Object) null);
            soConsumerIndex(1 + j);
        }
        return t;
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qjf;
        long eLt = eLt();
        int i = this.qje;
        T t = (T) b(atomicReferenceArray, N(eLt, i));
        if (t == qjg) {
            return b(a(atomicReferenceArray, i + 1), eLt, i);
        }
        return t;
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.qjf = atomicReferenceArray;
        return (T) b(atomicReferenceArray, N(j, i));
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
        long eLr = eLr();
        while (true) {
            long eLq = eLq();
            long eLr2 = eLr();
            if (eLr == eLr2) {
                return (int) (eLq - eLr2);
            }
            eLr = eLr2;
        }
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return eLq() == eLr();
    }

    private void Th(int i) {
        this.qjb = Math.min(i / 4, qja);
    }

    private long eLq() {
        return this.producerIndex.get();
    }

    private long eLr() {
        return this.consumerIndex.get();
    }

    private long eLs() {
        return this.producerIndex.get();
    }

    private long eLt() {
        return this.consumerIndex.get();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private static int N(long j, int i) {
        return Ti(((int) j) & i);
    }

    private static int Ti(int i) {
        return i;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.qjd;
        long eLq = eLq();
        int i = this.qjc;
        if (b(atomicReferenceArray, N(eLq + 2, i)) == null) {
            int N = N(eLq, i);
            a(atomicReferenceArray, N + 1, t2);
            a(atomicReferenceArray, N, t);
            soProducerIndex(eLq + 2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.qjd = atomicReferenceArray2;
        int N2 = N(eLq, i);
        a(atomicReferenceArray2, N2 + 1, t2);
        a(atomicReferenceArray2, N2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, N2, qjg);
        soProducerIndex(eLq + 2);
        return true;
    }
}
