package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public class y<E> extends aa<E> {
    static final int nMr = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nMx = new Object();
    private static final long ogt;
    private static final int ogu;
    private static final long ogw;
    private static final long ogx;

    static {
        int Q = ae.ogD.Q(Object[].class);
        if (4 == Q) {
            ogu = 2;
        } else if (8 == Q) {
            ogu = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        ogt = ae.ogD.R(Object[].class);
        try {
            ogx = ae.ogD.b(ad.class.getDeclaredField("producerIndex"));
            try {
                ogw = ae.ogD.b(aa.class.getDeclaredField("consumerIndex"));
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
        int KU = h.KU(i);
        long j = KU - 1;
        E[] eArr = (E[]) new Object[KU + 1];
        this.ogC = eArr;
        this.ogB = j;
        KR(KU);
        this.ogA = eArr;
        this.ogz = j;
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
        E[] eArr = this.ogC;
        long j = this.producerIndex;
        long j2 = this.ogB;
        long X = X(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, X);
        }
        int i = this.nMs;
        if (b(eArr, X(i + j, j2)) == null) {
            this.producerLookAhead = (i + j) - 1;
            return a(eArr, e, j, X);
        } else if (b(eArr, X(1 + j, j2)) != null) {
            return a(eArr, e, j, X);
        } else {
            a(eArr, j, X, e, j2);
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
        this.ogC = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, nMx);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, gF(eArr.length - 1), eArr2);
    }

    private E[] U(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, gF(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.ogA;
        long j = this.consumerIndex;
        long j2 = this.ogz;
        long X = X(j, j2);
        E e = (E) b(eArr, X);
        boolean z = e == nMx;
        if (e != null && !z) {
            b(eArr, X, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(U(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.ogA = eArr;
        long X = X(j, j2);
        E e = (E) b(eArr, X);
        if (e == null) {
            return null;
        }
        b(eArr, X, (Object) null);
        soConsumerIndex(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.ogA;
        long j = this.consumerIndex;
        long j2 = this.ogz;
        E e = (E) b(eArr, X(j, j2));
        if (e == nMx) {
            return b(U(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.ogA = eArr;
        return (E) b(eArr, X(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long dPL = dPL();
        while (true) {
            long dPK = dPK();
            long dPL2 = dPL();
            if (dPL == dPL2) {
                return (int) (dPK - dPL2);
            }
            dPL = dPL2;
        }
    }

    private void KR(int i) {
        this.nMs = Math.min(i / 4, nMr);
    }

    private long dPK() {
        return ae.ogD.e(this, ogx);
    }

    private long dPL() {
        return ae.ogD.e(this, ogw);
    }

    private void soProducerIndex(long j) {
        ae.ogD.a(this, ogx, j);
    }

    private void soConsumerIndex(long j) {
        ae.ogD.a(this, ogw, j);
    }

    private static long X(long j, long j2) {
        return gF(j & j2);
    }

    private static long gF(long j) {
        return ogt + (j << ogu);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.ogD.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.ogD.d(eArr, j);
    }
}
