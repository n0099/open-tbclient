package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes4.dex */
public class y<E> extends aa<E> {
    private static final long qEr;
    private static final int qEs;
    private static final long qEu;
    private static final long qEv;
    static final int qrn = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qrt = new Object();

    static {
        int K = ae.qEB.K(Object[].class);
        if (4 == K) {
            qEs = 2;
        } else if (8 == K) {
            qEs = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qEr = ae.qEB.L(Object[].class);
        try {
            qEv = ae.qEB.c(ad.class.getDeclaredField("producerIndex"));
            try {
                qEu = ae.qEB.c(aa.class.getDeclaredField("consumerIndex"));
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
        this.qEA = eArr;
        this.qEz = j;
        Sl(So);
        this.qEy = eArr;
        this.qEx = j;
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
        E[] eArr = this.qEA;
        long j = this.producerIndex;
        long j2 = this.qEz;
        long ad = ad(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, ad);
        }
        int i = this.qro;
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
        this.qEA = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, qrt);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, jE(eArr.length - 1), eArr2);
    }

    private E[] V(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, jE(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.qEy;
        long j = this.consumerIndex;
        long j2 = this.qEx;
        long ad = ad(j, j2);
        E e = (E) b(eArr, ad);
        boolean z = e == qrt;
        if (e != null && !z) {
            b(eArr, ad, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(V(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.qEy = eArr;
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
        E[] eArr = this.qEy;
        long j = this.consumerIndex;
        long j2 = this.qEx;
        E e = (E) b(eArr, ad(j, j2));
        if (e == qrt) {
            return b(V(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.qEy = eArr;
        return (E) b(eArr, ad(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long eKl = eKl();
        while (true) {
            long eKk = eKk();
            long eKl2 = eKl();
            if (eKl == eKl2) {
                return (int) (eKk - eKl2);
            }
            eKl = eKl2;
        }
    }

    private void Sl(int i) {
        this.qro = Math.min(i / 4, qrn);
    }

    private long eKk() {
        return ae.qEB.e(this, qEv);
    }

    private long eKl() {
        return ae.qEB.e(this, qEu);
    }

    private void soProducerIndex(long j) {
        ae.qEB.a(this, qEv, j);
    }

    private void soConsumerIndex(long j) {
        ae.qEB.a(this, qEu, j);
    }

    private static long ad(long j, long j2) {
        return jE(j & j2);
    }

    private static long jE(long j) {
        return qEr + (j << qEs);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.qEB.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.qEB.d(eArr, j);
    }
}
