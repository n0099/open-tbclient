package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes15.dex */
public class y<E> extends aa<E> {
    static final int qkI = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qkO = new Object();
    private static final long qxN;
    private static final int qxO;
    private static final long qxQ;
    private static final long qxR;

    static {
        int K = ae.qxX.K(Object[].class);
        if (4 == K) {
            qxO = 2;
        } else if (8 == K) {
            qxO = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qxN = ae.qxX.L(Object[].class);
        try {
            qxR = ae.qxX.c(ad.class.getDeclaredField("producerIndex"));
            try {
                qxQ = ae.qxX.c(aa.class.getDeclaredField("consumerIndex"));
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
        int TA = h.TA(i);
        long j = TA - 1;
        E[] eArr = (E[]) new Object[TA + 1];
        this.qxW = eArr;
        this.qxV = j;
        Tx(TA);
        this.qxU = eArr;
        this.qxT = j;
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
        E[] eArr = this.qxW;
        long j = this.producerIndex;
        long j2 = this.qxV;
        long Z = Z(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, Z);
        }
        int i = this.qkJ;
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
        this.qxW = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, qkO);
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
        E[] eArr = this.qxU;
        long j = this.consumerIndex;
        long j2 = this.qxT;
        long Z = Z(j, j2);
        E e = (E) b(eArr, Z);
        boolean z = e == qkO;
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
        this.qxU = eArr;
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
        E[] eArr = this.qxU;
        long j = this.consumerIndex;
        long j2 = this.qxT;
        E e = (E) b(eArr, Z(j, j2));
        if (e == qkO) {
            return b(W(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.qxU = eArr;
        return (E) b(eArr, Z(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long eLV = eLV();
        while (true) {
            long eLU = eLU();
            long eLV2 = eLV();
            if (eLV == eLV2) {
                return (int) (eLU - eLV2);
            }
            eLV = eLV2;
        }
    }

    private void Tx(int i) {
        this.qkJ = Math.min(i / 4, qkI);
    }

    private long eLU() {
        return ae.qxX.e(this, qxR);
    }

    private long eLV() {
        return ae.qxX.e(this, qxQ);
    }

    private void soProducerIndex(long j) {
        ae.qxX.a(this, qxR, j);
    }

    private void soConsumerIndex(long j) {
        ae.qxX.a(this, qxQ, j);
    }

    private static long Z(long j, long j2) {
        return jC(j & j2);
    }

    private static long jC(long j) {
        return qxN + (j << qxO);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.qxX.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.qxX.d(eArr, j);
    }
}
