package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes12.dex */
public class y<E> extends aa<E> {
    private static final long pUF;
    private static final int pUG;
    private static final long pUI;
    private static final long pUJ;
    static final int pHx = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object pHD = new Object();

    static {
        int Q = ae.pUP.Q(Object[].class);
        if (4 == Q) {
            pUG = 2;
        } else if (8 == Q) {
            pUG = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        pUF = ae.pUP.R(Object[].class);
        try {
            pUJ = ae.pUP.b(ad.class.getDeclaredField("producerIndex"));
            try {
                pUI = ae.pUP.b(aa.class.getDeclaredField("consumerIndex"));
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
        this.pUO = eArr;
        this.pUN = j;
        RO(RR);
        this.pUM = eArr;
        this.pUL = j;
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
        E[] eArr = this.pUO;
        long j = this.producerIndex;
        long j2 = this.pUN;
        long T = T(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, T);
        }
        int i = this.pHy;
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
        this.pUO = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, pHD);
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
        E[] eArr = this.pUM;
        long j = this.consumerIndex;
        long j2 = this.pUL;
        long T = T(j, j2);
        E e = (E) b(eArr, T);
        boolean z = e == pHD;
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
        this.pUM = eArr;
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
        E[] eArr = this.pUM;
        long j = this.consumerIndex;
        long j2 = this.pUL;
        E e = (E) b(eArr, T(j, j2));
        if (e == pHD) {
            return b(S(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.pUM = eArr;
        return (E) b(eArr, T(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long eDj = eDj();
        while (true) {
            long eDi = eDi();
            long eDj2 = eDj();
            if (eDj == eDj2) {
                return (int) (eDi - eDj2);
            }
            eDj = eDj2;
        }
    }

    private void RO(int i) {
        this.pHy = Math.min(i / 4, pHx);
    }

    private long eDi() {
        return ae.pUP.e(this, pUJ);
    }

    private long eDj() {
        return ae.pUP.e(this, pUI);
    }

    private void soProducerIndex(long j) {
        ae.pUP.a(this, pUJ, j);
    }

    private void soConsumerIndex(long j) {
        ae.pUP.a(this, pUI, j);
    }

    private static long T(long j, long j2) {
        return iP(j & j2);
    }

    private static long iP(long j) {
        return pUF + (j << pUG);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.pUP.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.pUP.d(eArr, j);
    }
}
