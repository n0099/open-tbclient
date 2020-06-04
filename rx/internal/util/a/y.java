package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public class y<E> extends aa<E> {
    private static final long nKC;
    private static final int nKD;
    private static final long nKF;
    private static final long nKG;
    static final int nqB = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nqH = new Object();

    static {
        int Q = ae.nKM.Q(Object[].class);
        if (4 == Q) {
            nKD = 2;
        } else if (8 == Q) {
            nKD = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nKC = ae.nKM.R(Object[].class);
        try {
            nKG = ae.nKM.b(ad.class.getDeclaredField("producerIndex"));
            try {
                nKF = ae.nKM.b(aa.class.getDeclaredField("consumerIndex"));
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
        int JN = h.JN(i);
        long j = JN - 1;
        E[] eArr = (E[]) new Object[JN + 1];
        this.nKL = eArr;
        this.nKK = j;
        JK(JN);
        this.nKJ = eArr;
        this.nKI = j;
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
        E[] eArr = this.nKL;
        long j = this.producerIndex;
        long j2 = this.nKK;
        long W = W(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, W);
        }
        int i = this.nqC;
        if (b(eArr, W(i + j, j2)) == null) {
            this.producerLookAhead = (i + j) - 1;
            return a(eArr, e, j, W);
        } else if (b(eArr, W(1 + j, j2)) != null) {
            return a(eArr, e, j, W);
        } else {
            a(eArr, j, W, e, j2);
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
        this.nKL = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, nqH);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, gA(eArr.length - 1), eArr2);
    }

    private E[] U(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, gA(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.nKJ;
        long j = this.consumerIndex;
        long j2 = this.nKI;
        long W = W(j, j2);
        E e = (E) b(eArr, W);
        boolean z = e == nqH;
        if (e != null && !z) {
            b(eArr, W, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(U(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.nKJ = eArr;
        long W = W(j, j2);
        E e = (E) b(eArr, W);
        if (e == null) {
            return null;
        }
        b(eArr, W, (Object) null);
        soConsumerIndex(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.nKJ;
        long j = this.consumerIndex;
        long j2 = this.nKI;
        E e = (E) b(eArr, W(j, j2));
        if (e == nqH) {
            return b(U(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.nKJ = eArr;
        return (E) b(eArr, W(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long dLb = dLb();
        while (true) {
            long dLa = dLa();
            long dLb2 = dLb();
            if (dLb == dLb2) {
                return (int) (dLa - dLb2);
            }
            dLb = dLb2;
        }
    }

    private void JK(int i) {
        this.nqC = Math.min(i / 4, nqB);
    }

    private long dLa() {
        return ae.nKM.e(this, nKG);
    }

    private long dLb() {
        return ae.nKM.e(this, nKF);
    }

    private void soProducerIndex(long j) {
        ae.nKM.a(this, nKG, j);
    }

    private void soConsumerIndex(long j) {
        ae.nKM.a(this, nKF, j);
    }

    private static long W(long j, long j2) {
        return gA(j & j2);
    }

    private static long gA(long j) {
        return nKC + (j << nKD);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.nKM.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.nKM.d(eArr, j);
    }
}
