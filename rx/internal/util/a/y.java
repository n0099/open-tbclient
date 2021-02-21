package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes5.dex */
public class y<E> extends aa<E> {
    private static final long qDP;
    private static final int qDQ;
    private static final long qDS;
    private static final long qDT;
    static final int qqL = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qqR = new Object();

    static {
        int K = ae.qDZ.K(Object[].class);
        if (4 == K) {
            qDQ = 2;
        } else if (8 == K) {
            qDQ = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qDP = ae.qDZ.L(Object[].class);
        try {
            qDT = ae.qDZ.c(ad.class.getDeclaredField("producerIndex"));
            try {
                qDS = ae.qDZ.c(aa.class.getDeclaredField("consumerIndex"));
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
        int Sp = h.Sp(i);
        long j = Sp - 1;
        E[] eArr = (E[]) new Object[Sp + 1];
        this.qDY = eArr;
        this.qDX = j;
        Sm(Sp);
        this.qDW = eArr;
        this.qDV = j;
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
        E[] eArr = this.qDY;
        long j = this.producerIndex;
        long j2 = this.qDX;
        long ad = ad(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, ad);
        }
        int i = this.qqM;
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
        this.qDY = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, qqR);
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
        E[] eArr = this.qDW;
        long j = this.consumerIndex;
        long j2 = this.qDV;
        long ad = ad(j, j2);
        E e = (E) b(eArr, ad);
        boolean z = e == qqR;
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
        this.qDW = eArr;
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
        E[] eArr = this.qDW;
        long j = this.consumerIndex;
        long j2 = this.qDV;
        E e = (E) b(eArr, ad(j, j2));
        if (e == qqR) {
            return b(W(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.qDW = eArr;
        return (E) b(eArr, ad(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long eKD = eKD();
        while (true) {
            long eKC = eKC();
            long eKD2 = eKD();
            if (eKD == eKD2) {
                return (int) (eKC - eKD2);
            }
            eKD = eKD2;
        }
    }

    private void Sm(int i) {
        this.qqM = Math.min(i / 4, qqL);
    }

    private long eKC() {
        return ae.qDZ.e(this, qDT);
    }

    private long eKD() {
        return ae.qDZ.e(this, qDS);
    }

    private void soProducerIndex(long j) {
        ae.qDZ.a(this, qDT, j);
    }

    private void soConsumerIndex(long j) {
        ae.qDZ.a(this, qDS, j);
    }

    private static long ad(long j, long j2) {
        return jF(j & j2);
    }

    private static long jF(long j) {
        return qDP + (j << qDQ);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.qDZ.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.qDZ.d(eArr, j);
    }
}
