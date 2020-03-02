package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public class y<E> extends aa<E> {
    private static final long nSJ;
    private static final int nSK;
    private static final long nSM;
    private static final long nSN;
    static final int nyL = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nyR = new Object();

    static {
        int Q = ae.nST.Q(Object[].class);
        if (4 == Q) {
            nSK = 2;
        } else if (8 == Q) {
            nSK = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nSJ = ae.nST.R(Object[].class);
        try {
            nSN = ae.nST.b(ad.class.getDeclaredField("producerIndex"));
            try {
                nSM = ae.nST.b(aa.class.getDeclaredField("consumerIndex"));
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
        int NA = h.NA(i);
        long j = NA - 1;
        E[] eArr = (E[]) new Object[NA + 1];
        this.nSS = eArr;
        this.nSR = j;
        Nx(NA);
        this.nSQ = eArr;
        this.nSP = j;
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
        E[] eArr = this.nSS;
        long j = this.producerIndex;
        long j2 = this.nSR;
        long an = an(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, an);
        }
        int i = this.nyM;
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
        this.nSS = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, nyR);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, hx(eArr.length - 1), eArr2);
    }

    private E[] R(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, hx(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.nSQ;
        long j = this.consumerIndex;
        long j2 = this.nSP;
        long an = an(j, j2);
        E e = (E) b(eArr, an);
        boolean z = e == nyR;
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
        this.nSQ = eArr;
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
        E[] eArr = this.nSQ;
        long j = this.consumerIndex;
        long j2 = this.nSP;
        E e = (E) b(eArr, an(j, j2));
        if (e == nyR) {
            return b(R(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.nSQ = eArr;
        return (E) b(eArr, an(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
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

    private void Nx(int i) {
        this.nyM = Math.min(i / 4, nyL);
    }

    private long dJv() {
        return ae.nST.d(this, nSN);
    }

    private long dJw() {
        return ae.nST.d(this, nSM);
    }

    private void soProducerIndex(long j) {
        ae.nST.a(this, nSN, j);
    }

    private void soConsumerIndex(long j) {
        ae.nST.a(this, nSM, j);
    }

    private static long an(long j, long j2) {
        return hx(j & j2);
    }

    private static long hx(long j) {
        return nSJ + (j << nSK);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.nST.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.nST.c(eArr, j);
    }
}
