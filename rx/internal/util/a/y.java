package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes14.dex */
public class y<E> extends aa<E> {
    static final int qgg = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qgm = new Object();
    private static final long qtl;
    private static final int qtm;
    private static final long qto;
    private static final long qtp;

    static {
        int K = ae.qtv.K(Object[].class);
        if (4 == K) {
            qtm = 2;
        } else if (8 == K) {
            qtm = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qtl = ae.qtv.L(Object[].class);
        try {
            qtp = ae.qtv.c(ad.class.getDeclaredField("producerIndex"));
            try {
                qto = ae.qtv.c(aa.class.getDeclaredField("consumerIndex"));
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
        int RT = h.RT(i);
        long j = RT - 1;
        E[] eArr = (E[]) new Object[RT + 1];
        this.qtu = eArr;
        this.qtt = j;
        RQ(RT);
        this.qts = eArr;
        this.qtr = j;
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
        E[] eArr = this.qtu;
        long j = this.producerIndex;
        long j2 = this.qtt;
        long Z = Z(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, Z);
        }
        int i = this.qgh;
        if (b(eArr, Z(i + j, j2)) == null) {
            this.producerLookAhead = (i + j) - 1;
            return a(eArr, e, j, Z);
        } else if (b(eArr, Z(1 + j, j2)) != null) {
            return a(eArr, e, j, Z);
        } else {
            a(eArr, j, Z, e, j2);
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
        this.qtu = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, qgm);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, jC(eArr.length - 1), eArr2);
    }

    private E[] W(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, jC(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.qts;
        long j = this.consumerIndex;
        long j2 = this.qtr;
        long Z = Z(j, j2);
        E e = (E) b(eArr, Z);
        boolean z = e == qgm;
        if (e != null && !z) {
            b(eArr, Z, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(W(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.qts = eArr;
        long Z = Z(j, j2);
        E e = (E) b(eArr, Z);
        if (e == null) {
            return null;
        }
        b(eArr, Z, (Object) null);
        soConsumerIndex(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.qts;
        long j = this.consumerIndex;
        long j2 = this.qtr;
        E e = (E) b(eArr, Z(j, j2));
        if (e == qgm) {
            return b(W(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.qts = eArr;
        return (E) b(eArr, Z(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long eIf = eIf();
        while (true) {
            long eIe = eIe();
            long eIf2 = eIf();
            if (eIf == eIf2) {
                return (int) (eIe - eIf2);
            }
            eIf = eIf2;
        }
    }

    private void RQ(int i) {
        this.qgh = Math.min(i / 4, qgg);
    }

    private long eIe() {
        return ae.qtv.e(this, qtp);
    }

    private long eIf() {
        return ae.qtv.e(this, qto);
    }

    private void soProducerIndex(long j) {
        ae.qtv.a(this, qtp, j);
    }

    private void soConsumerIndex(long j) {
        ae.qtv.a(this, qto, j);
    }

    private static long Z(long j, long j2) {
        return jC(j & j2);
    }

    private static long jC(long j) {
        return qtl + (j << qtm);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.qtv.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.qtv.d(eArr, j);
    }
}
