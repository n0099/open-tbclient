package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes12.dex */
public class y<E> extends aa<E> {
    private static final long pUD;
    private static final int pUE;
    private static final long pUG;
    private static final long pUH;
    static final int pHv = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object pHB = new Object();

    static {
        int Q = ae.pUN.Q(Object[].class);
        if (4 == Q) {
            pUE = 2;
        } else if (8 == Q) {
            pUE = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        pUD = ae.pUN.R(Object[].class);
        try {
            pUH = ae.pUN.b(ad.class.getDeclaredField("producerIndex"));
            try {
                pUG = ae.pUN.b(aa.class.getDeclaredField("consumerIndex"));
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
        int RR = h.RR(i);
        long j = RR - 1;
        E[] eArr = (E[]) new Object[RR + 1];
        this.pUM = eArr;
        this.pUL = j;
        RO(RR);
        this.pUK = eArr;
        this.pUJ = j;
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
        E[] eArr = this.pUM;
        long j = this.producerIndex;
        long j2 = this.pUL;
        long T = T(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, T);
        }
        int i = this.pHw;
        if (b(eArr, T(i + j, j2)) == null) {
            this.producerLookAhead = (i + j) - 1;
            return a(eArr, e, j, T);
        } else if (b(eArr, T(1 + j, j2)) != null) {
            return a(eArr, e, j, T);
        } else {
            a(eArr, j, T, e, j2);
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
        this.pUM = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, pHB);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, iP(eArr.length - 1), eArr2);
    }

    private E[] S(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, iP(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.pUK;
        long j = this.consumerIndex;
        long j2 = this.pUJ;
        long T = T(j, j2);
        E e = (E) b(eArr, T);
        boolean z = e == pHB;
        if (e != null && !z) {
            b(eArr, T, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(S(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.pUK = eArr;
        long T = T(j, j2);
        E e = (E) b(eArr, T);
        if (e == null) {
            return null;
        }
        b(eArr, T, (Object) null);
        soConsumerIndex(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.pUK;
        long j = this.consumerIndex;
        long j2 = this.pUJ;
        E e = (E) b(eArr, T(j, j2));
        if (e == pHB) {
            return b(S(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.pUK = eArr;
        return (E) b(eArr, T(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long eDi = eDi();
        while (true) {
            long eDh = eDh();
            long eDi2 = eDi();
            if (eDi == eDi2) {
                return (int) (eDh - eDi2);
            }
            eDi = eDi2;
        }
    }

    private void RO(int i) {
        this.pHw = Math.min(i / 4, pHv);
    }

    private long eDh() {
        return ae.pUN.e(this, pUH);
    }

    private long eDi() {
        return ae.pUN.e(this, pUG);
    }

    private void soProducerIndex(long j) {
        ae.pUN.a(this, pUH, j);
    }

    private void soConsumerIndex(long j) {
        ae.pUN.a(this, pUG, j);
    }

    private static long T(long j, long j2) {
        return iP(j & j2);
    }

    private static long iP(long j) {
        return pUD + (j << pUE);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.pUN.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.pUN.d(eArr, j);
    }
}
