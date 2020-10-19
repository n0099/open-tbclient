package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes16.dex */
public class y<E> extends aa<E> {
    static final int oOn = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object oOt = new Object();
    private static final long pio;
    private static final int pip;
    private static final long pir;
    private static final long pis;

    static {
        int Q = ae.piy.Q(Object[].class);
        if (4 == Q) {
            pip = 2;
        } else if (8 == Q) {
            pip = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        pio = ae.piy.R(Object[].class);
        try {
            pis = ae.piy.b(ad.class.getDeclaredField("producerIndex"));
            try {
                pir = ae.piy.b(aa.class.getDeclaredField("consumerIndex"));
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
        int Pc = h.Pc(i);
        long j = Pc - 1;
        E[] eArr = (E[]) new Object[Pc + 1];
        this.pix = eArr;
        this.piw = j;
        OZ(Pc);
        this.piv = eArr;
        this.piu = j;
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
        E[] eArr = this.pix;
        long j = this.producerIndex;
        long j2 = this.piw;
        long W = W(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, W);
        }
        int i = this.oOo;
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
        this.pix = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, oOt);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, hN(eArr.length - 1), eArr2);
    }

    private E[] T(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, hN(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.piv;
        long j = this.consumerIndex;
        long j2 = this.piu;
        long W = W(j, j2);
        E e = (E) b(eArr, W);
        boolean z = e == oOt;
        if (e != null && !z) {
            b(eArr, W, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(T(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.piv = eArr;
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
        E[] eArr = this.piv;
        long j = this.consumerIndex;
        long j2 = this.piu;
        E e = (E) b(eArr, W(j, j2));
        if (e == oOt) {
            return b(T(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.piv = eArr;
        return (E) b(eArr, W(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long enb = enb();
        while (true) {
            long ena = ena();
            long enb2 = enb();
            if (enb == enb2) {
                return (int) (ena - enb2);
            }
            enb = enb2;
        }
    }

    private void OZ(int i) {
        this.oOo = Math.min(i / 4, oOn);
    }

    private long ena() {
        return ae.piy.e(this, pis);
    }

    private long enb() {
        return ae.piy.e(this, pir);
    }

    private void soProducerIndex(long j) {
        ae.piy.a(this, pis, j);
    }

    private void soConsumerIndex(long j) {
        ae.piy.a(this, pir, j);
    }

    private static long W(long j, long j2) {
        return hN(j & j2);
    }

    private static long hN(long j) {
        return pio + (j << pip);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.piy.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.piy.d(eArr, j);
    }
}
