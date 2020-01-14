package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes5.dex */
public class y<E> extends aa<E> {
    private static final long nRT;
    private static final int nRU;
    private static final long nRW;
    private static final long nRX;
    static final int nyh = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nyn = new Object();

    static {
        int R = ae.nSd.R(Object[].class);
        if (4 == R) {
            nRU = 2;
        } else if (8 == R) {
            nRU = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nRT = ae.nSd.S(Object[].class);
        try {
            nRX = ae.nSd.b(ad.class.getDeclaredField("producerIndex"));
            try {
                nRW = ae.nSd.b(aa.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e) {
                InternalError internalError = new InternalError();
                internalError.initCause(e);
                throw internalError;
            }
        } catch (NoSuchFieldException e2) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e2);
            throw internalError2;
        }
    }

    public y(int i) {
        int Nx = h.Nx(i);
        long j = Nx - 1;
        E[] eArr = (E[]) new Object[Nx + 1];
        this.nSc = eArr;
        this.nSb = j;
        Nu(Nx);
        this.nSa = eArr;
        this.nRZ = j;
        this.producerLookAhead = j - 1;
        soProducerIndex(0L);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public final boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.nSc;
        long j = this.producerIndex;
        long j2 = this.nSb;
        long an = an(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, an);
        }
        int i = this.nyi;
        if (b(eArr, an(i + j, j2)) == null) {
            this.producerLookAhead = (i + j) - 1;
            return a(eArr, e, j, an);
        } else if (b(eArr, an(1 + j, j2)) != null) {
            return a(eArr, e, j, an);
        } else {
            a(eArr, j, an, e, j2);
            return true;
        }
    }

    private boolean a(E[] eArr, E e, long j, long j2) {
        b(eArr, j2, e);
        soProducerIndex(1 + j);
        return true;
    }

    private void a(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.nSc = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, nyn);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, hz(eArr.length - 1), eArr2);
    }

    private E[] R(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, hz(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.nSa;
        long j = this.consumerIndex;
        long j2 = this.nRZ;
        long an = an(j, j2);
        E e = (E) b(eArr, an);
        boolean z = e == nyn;
        if (e != null && !z) {
            b(eArr, an, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(R(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.nSa = eArr;
        long an = an(j, j2);
        E e = (E) b(eArr, an);
        if (e == null) {
            return null;
        }
        b(eArr, an, (Object) null);
        soConsumerIndex(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.nSa;
        long j = this.consumerIndex;
        long j2 = this.nRZ;
        E e = (E) b(eArr, an(j, j2));
        if (e == nyn) {
            return b(R(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.nSa = eArr;
        return (E) b(eArr, an(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
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

    private void Nu(int i) {
        this.nyi = Math.min(i / 4, nyh);
    }

    private long dIm() {
        return ae.nSd.d(this, nRX);
    }

    private long dIn() {
        return ae.nSd.d(this, nRW);
    }

    private void soProducerIndex(long j) {
        ae.nSd.a(this, nRX, j);
    }

    private void soConsumerIndex(long j) {
        ae.nSd.a(this, nRW, j);
    }

    private static long an(long j, long j2) {
        return hz(j & j2);
    }

    private static long hz(long j) {
        return nRT + (j << nRU);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.nSd.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.nSd.c(eArr, j);
    }
}
