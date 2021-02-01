package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes5.dex */
public class y<E> extends aa<E> {
    private static final long qDp;
    private static final int qDq;
    private static final long qDs;
    private static final long qDt;
    static final int qql = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qqr = new Object();

    static {
        int K = ae.qDz.K(Object[].class);
        if (4 == K) {
            qDq = 2;
        } else if (8 == K) {
            qDq = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qDp = ae.qDz.L(Object[].class);
        try {
            qDt = ae.qDz.c(ad.class.getDeclaredField("producerIndex"));
            try {
                qDs = ae.qDz.c(aa.class.getDeclaredField("consumerIndex"));
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
        int So = h.So(i);
        long j = So - 1;
        E[] eArr = (E[]) new Object[So + 1];
        this.qDy = eArr;
        this.qDx = j;
        Sl(So);
        this.qDw = eArr;
        this.qDv = j;
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
        E[] eArr = this.qDy;
        long j = this.producerIndex;
        long j2 = this.qDx;
        long ad = ad(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, ad);
        }
        int i = this.qqm;
        if (b(eArr, ad(i + j, j2)) == null) {
            this.producerLookAhead = (i + j) - 1;
            return a(eArr, e, j, ad);
        } else if (b(eArr, ad(1 + j, j2)) != null) {
            return a(eArr, e, j, ad);
        } else {
            a(eArr, j, ad, e, j2);
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
        this.qDy = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, qqr);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, jF(eArr.length - 1), eArr2);
    }

    private E[] W(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, jF(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.qDw;
        long j = this.consumerIndex;
        long j2 = this.qDv;
        long ad = ad(j, j2);
        E e = (E) b(eArr, ad);
        boolean z = e == qqr;
        if (e != null && !z) {
            b(eArr, ad, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(W(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.qDw = eArr;
        long ad = ad(j, j2);
        E e = (E) b(eArr, ad);
        if (e == null) {
            return null;
        }
        b(eArr, ad, (Object) null);
        soConsumerIndex(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.qDw;
        long j = this.consumerIndex;
        long j2 = this.qDv;
        E e = (E) b(eArr, ad(j, j2));
        if (e == qqr) {
            return b(W(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.qDw = eArr;
        return (E) b(eArr, ad(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long eKv = eKv();
        while (true) {
            long eKu = eKu();
            long eKv2 = eKv();
            if (eKv == eKv2) {
                return (int) (eKu - eKv2);
            }
            eKv = eKv2;
        }
    }

    private void Sl(int i) {
        this.qqm = Math.min(i / 4, qql);
    }

    private long eKu() {
        return ae.qDz.e(this, qDt);
    }

    private long eKv() {
        return ae.qDz.e(this, qDs);
    }

    private void soProducerIndex(long j) {
        ae.qDz.a(this, qDt, j);
    }

    private void soConsumerIndex(long j) {
        ae.qDz.a(this, qDs, j);
    }

    private static long ad(long j, long j2) {
        return jF(j & j2);
    }

    private static long jF(long j) {
        return qDp + (j << qDq);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.qDz.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.qDz.d(eArr, j);
    }
}
