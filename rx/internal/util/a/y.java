package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes16.dex */
public class y<E> extends aa<E> {
    static final int pPe = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object pPk = new Object();
    private static final long qiZ;
    private static final int qja;
    private static final long qjc;
    private static final long qjd;

    static {
        int Q = ae.qjj.Q(Object[].class);
        if (4 == Q) {
            qja = 2;
        } else if (8 == Q) {
            qja = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qiZ = ae.qjj.R(Object[].class);
        try {
            qjd = ae.qjj.b(ad.class.getDeclaredField("producerIndex"));
            try {
                qjc = ae.qjj.b(aa.class.getDeclaredField("consumerIndex"));
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
        int Ro = h.Ro(i);
        long j = Ro - 1;
        E[] eArr = (E[]) new Object[Ro + 1];
        this.qji = eArr;
        this.qjh = j;
        Rl(Ro);
        this.qjg = eArr;
        this.qjf = j;
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
        E[] eArr = this.qji;
        long j = this.producerIndex;
        long j2 = this.qjh;
        long Y = Y(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, Y);
        }
        int i = this.pPf;
        if (b(eArr, Y(i + j, j2)) == null) {
            this.producerLookAhead = (i + j) - 1;
            return a(eArr, e, j, Y);
        } else if (b(eArr, Y(1 + j, j2)) != null) {
            return a(eArr, e, j, Y);
        } else {
            a(eArr, j, Y, e, j2);
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
        this.qji = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, pPk);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, iz(eArr.length - 1), eArr2);
    }

    private E[] T(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, iz(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.qjg;
        long j = this.consumerIndex;
        long j2 = this.qjf;
        long Y = Y(j, j2);
        E e = (E) b(eArr, Y);
        boolean z = e == pPk;
        if (e != null && !z) {
            b(eArr, Y, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(T(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.qjg = eArr;
        long Y = Y(j, j2);
        E e = (E) b(eArr, Y);
        if (e == null) {
            return null;
        }
        b(eArr, Y, (Object) null);
        soConsumerIndex(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.qjg;
        long j = this.consumerIndex;
        long j2 = this.qjf;
        E e = (E) b(eArr, Y(j, j2));
        if (e == pPk) {
            return b(T(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.qjg = eArr;
        return (E) b(eArr, Y(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long eAQ = eAQ();
        while (true) {
            long eAP = eAP();
            long eAQ2 = eAQ();
            if (eAQ == eAQ2) {
                return (int) (eAP - eAQ2);
            }
            eAQ = eAQ2;
        }
    }

    private void Rl(int i) {
        this.pPf = Math.min(i / 4, pPe);
    }

    private long eAP() {
        return ae.qjj.e(this, qjd);
    }

    private long eAQ() {
        return ae.qjj.e(this, qjc);
    }

    private void soProducerIndex(long j) {
        ae.qjj.a(this, qjd, j);
    }

    private void soConsumerIndex(long j) {
        ae.qjj.a(this, qjc, j);
    }

    private static long Y(long j, long j2) {
        return iz(j & j2);
    }

    private static long iz(long j) {
        return qiZ + (j << qja);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.qjj.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.qjj.d(eArr, j);
    }
}
