package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public class y<E> extends aa<E> {
    private static final long nSH;
    private static final int nSI;
    private static final long nSK;
    private static final long nSL;
    static final int nyJ = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nyP = new Object();

    static {
        int Q = ae.nSR.Q(Object[].class);
        if (4 == Q) {
            nSI = 2;
        } else if (8 == Q) {
            nSI = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nSH = ae.nSR.R(Object[].class);
        try {
            nSL = ae.nSR.b(ad.class.getDeclaredField("producerIndex"));
            try {
                nSK = ae.nSR.b(aa.class.getDeclaredField("consumerIndex"));
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
        this.nSQ = eArr;
        this.nSP = j;
        Nx(NA);
        this.nSO = eArr;
        this.nSN = j;
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
        E[] eArr = this.nSQ;
        long j = this.producerIndex;
        long j2 = this.nSP;
        long an = an(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, an);
        }
        int i = this.nyK;
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
        this.nSQ = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, nyP);
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
        E[] eArr = this.nSO;
        long j = this.consumerIndex;
        long j2 = this.nSN;
        long an = an(j, j2);
        E e = (E) b(eArr, an);
        boolean z = e == nyP;
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
        this.nSO = eArr;
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
        E[] eArr = this.nSO;
        long j = this.consumerIndex;
        long j2 = this.nSN;
        E e = (E) b(eArr, an(j, j2));
        if (e == nyP) {
            return b(R(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.nSO = eArr;
        return (E) b(eArr, an(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long dJu = dJu();
        while (true) {
            long dJt = dJt();
            long dJu2 = dJu();
            if (dJu == dJu2) {
                return (int) (dJt - dJu2);
            }
            dJu = dJu2;
        }
    }

    private void Nx(int i) {
        this.nyK = Math.min(i / 4, nyJ);
    }

    private long dJt() {
        return ae.nSR.d(this, nSL);
    }

    private long dJu() {
        return ae.nSR.d(this, nSK);
    }

    private void soProducerIndex(long j) {
        ae.nSR.a(this, nSL, j);
    }

    private void soConsumerIndex(long j) {
        ae.nSR.a(this, nSK, j);
    }

    private static long an(long j, long j2) {
        return hx(j & j2);
    }

    private static long hx(long j) {
        return nSH + (j << nSI);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.nSR.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.nSR.c(eArr, j);
    }
}
