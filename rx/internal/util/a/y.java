package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes14.dex */
public class y<E> extends aa<E> {
    static final int qgh = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qgn = new Object();
    private static final long qtm;
    private static final int qtn;
    private static final long qtp;
    private static final long qtq;

    static {
        int K = ae.qtw.K(Object[].class);
        if (4 == K) {
            qtn = 2;
        } else if (8 == K) {
            qtn = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qtm = ae.qtw.L(Object[].class);
        try {
            qtq = ae.qtw.c(ad.class.getDeclaredField("producerIndex"));
            try {
                qtp = ae.qtw.c(aa.class.getDeclaredField("consumerIndex"));
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
        this.qtv = eArr;
        this.qtu = j;
        RQ(RT);
        this.qtt = eArr;
        this.qts = j;
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
        E[] eArr = this.qtv;
        long j = this.producerIndex;
        long j2 = this.qtu;
        long Z = Z(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, Z);
        }
        int i = this.qgi;
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
        this.qtv = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, qgn);
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
        E[] eArr = this.qtt;
        long j = this.consumerIndex;
        long j2 = this.qts;
        long Z = Z(j, j2);
        E e = (E) b(eArr, Z);
        boolean z = e == qgn;
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
        this.qtt = eArr;
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
        E[] eArr = this.qtt;
        long j = this.consumerIndex;
        long j2 = this.qts;
        E e = (E) b(eArr, Z(j, j2));
        if (e == qgn) {
            return b(W(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.qtt = eArr;
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
        this.qgi = Math.min(i / 4, qgh);
    }

    private long eIe() {
        return ae.qtw.e(this, qtq);
    }

    private long eIf() {
        return ae.qtw.e(this, qtp);
    }

    private void soProducerIndex(long j) {
        ae.qtw.a(this, qtq, j);
    }

    private void soConsumerIndex(long j) {
        ae.qtw.a(this, qtp, j);
    }

    private static long Z(long j, long j2) {
        return jC(j & j2);
    }

    private static long jC(long j) {
        return qtm + (j << qtn);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.qtw.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.qtw.d(eArr, j);
    }
}
