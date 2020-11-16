package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes14.dex */
public class y<E> extends aa<E> {
    static final int pQH = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object pQN = new Object();
    private static final long qkC;
    private static final int qkD;
    private static final long qkF;
    private static final long qkG;

    static {
        int Q = ae.qkM.Q(Object[].class);
        if (4 == Q) {
            qkD = 2;
        } else if (8 == Q) {
            qkD = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qkC = ae.qkM.R(Object[].class);
        try {
            qkG = ae.qkM.b(ad.class.getDeclaredField("producerIndex"));
            try {
                qkF = ae.qkM.b(aa.class.getDeclaredField("consumerIndex"));
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
        int RR = h.RR(i);
        long j = RR - 1;
        E[] eArr = (E[]) new Object[RR + 1];
        this.qkL = eArr;
        this.qkK = j;
        RO(RR);
        this.qkJ = eArr;
        this.qkI = j;
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
        E[] eArr = this.qkL;
        long j = this.producerIndex;
        long j2 = this.qkK;
        long Y = Y(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, Y);
        }
        int i = this.pQI;
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
        this.qkL = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, pQN);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, iC(eArr.length - 1), eArr2);
    }

    private E[] T(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, iC(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.qkJ;
        long j = this.consumerIndex;
        long j2 = this.qkI;
        long Y = Y(j, j2);
        E e = (E) b(eArr, Y);
        boolean z = e == pQN;
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
        this.qkJ = eArr;
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
        E[] eArr = this.qkJ;
        long j = this.consumerIndex;
        long j2 = this.qkI;
        E e = (E) b(eArr, Y(j, j2));
        if (e == pQN) {
            return b(T(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.qkJ = eArr;
        return (E) b(eArr, Y(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long eAR = eAR();
        while (true) {
            long eAQ = eAQ();
            long eAR2 = eAR();
            if (eAR == eAR2) {
                return (int) (eAQ - eAR2);
            }
            eAR = eAR2;
        }
    }

    private void RO(int i) {
        this.pQI = Math.min(i / 4, pQH);
    }

    private long eAQ() {
        return ae.qkM.e(this, qkG);
    }

    private long eAR() {
        return ae.qkM.e(this, qkF);
    }

    private void soProducerIndex(long j) {
        ae.qkM.a(this, qkG, j);
    }

    private void soConsumerIndex(long j) {
        ae.qkM.a(this, qkF, j);
    }

    private static long Y(long j, long j2) {
        return iC(j & j2);
    }

    private static long iC(long j) {
        return qkC + (j << qkD);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.qkM.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.qkM.d(eArr, j);
    }
}
