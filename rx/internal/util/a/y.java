package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes5.dex */
public class y<E> extends aa<E> {
    private static final long nRO;
    private static final int nRP;
    private static final long nRR;
    private static final long nRS;
    static final int nyc = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nyi = new Object();

    static {
        int R = ae.nRY.R(Object[].class);
        if (4 == R) {
            nRP = 2;
        } else if (8 == R) {
            nRP = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nRO = ae.nRY.S(Object[].class);
        try {
            nRS = ae.nRY.b(ad.class.getDeclaredField("producerIndex"));
            try {
                nRR = ae.nRY.b(aa.class.getDeclaredField("consumerIndex"));
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
        this.nRX = eArr;
        this.nRW = j;
        Nu(Nx);
        this.nRV = eArr;
        this.nRU = j;
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
        E[] eArr = this.nRX;
        long j = this.producerIndex;
        long j2 = this.nRW;
        long an = an(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, an);
        }
        int i = this.nyd;
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
        this.nRX = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, nyi);
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
        E[] eArr = this.nRV;
        long j = this.consumerIndex;
        long j2 = this.nRU;
        long an = an(j, j2);
        E e = (E) b(eArr, an);
        boolean z = e == nyi;
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
        this.nRV = eArr;
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
        E[] eArr = this.nRV;
        long j = this.consumerIndex;
        long j2 = this.nRU;
        E e = (E) b(eArr, an(j, j2));
        if (e == nyi) {
            return b(R(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.nRV = eArr;
        return (E) b(eArr, an(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
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

    private void Nu(int i) {
        this.nyd = Math.min(i / 4, nyc);
    }

    private long dIk() {
        return ae.nRY.d(this, nRS);
    }

    private long dIl() {
        return ae.nRY.d(this, nRR);
    }

    private void soProducerIndex(long j) {
        ae.nRY.a(this, nRS, j);
    }

    private void soConsumerIndex(long j) {
        ae.nRY.a(this, nRR, j);
    }

    private static long an(long j, long j2) {
        return hz(j & j2);
    }

    private static long hz(long j) {
        return nRO + (j << nRP);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.nRY.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.nRY.c(eArr, j);
    }
}
