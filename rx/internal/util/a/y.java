package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public class y<E> extends aa<E> {
    private static final long nJs;
    private static final int nJt;
    private static final long nJv;
    private static final long nJw;
    static final int npr = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object npx = new Object();

    static {
        int Q = ae.nJC.Q(Object[].class);
        if (4 == Q) {
            nJt = 2;
        } else if (8 == Q) {
            nJt = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nJs = ae.nJC.R(Object[].class);
        try {
            nJw = ae.nJC.b(ad.class.getDeclaredField("producerIndex"));
            try {
                nJv = ae.nJC.b(aa.class.getDeclaredField("consumerIndex"));
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
        int JL = h.JL(i);
        long j = JL - 1;
        E[] eArr = (E[]) new Object[JL + 1];
        this.nJB = eArr;
        this.nJA = j;
        JI(JL);
        this.nJz = eArr;
        this.nJy = j;
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
        E[] eArr = this.nJB;
        long j = this.producerIndex;
        long j2 = this.nJA;
        long W = W(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, W);
        }
        int i = this.nps;
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
        this.nJB = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, npx);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, gA(eArr.length - 1), eArr2);
    }

    private E[] U(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, gA(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.nJz;
        long j = this.consumerIndex;
        long j2 = this.nJy;
        long W = W(j, j2);
        E e = (E) b(eArr, W);
        boolean z = e == npx;
        if (e != null && !z) {
            b(eArr, W, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(U(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.nJz = eArr;
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
        E[] eArr = this.nJz;
        long j = this.consumerIndex;
        long j2 = this.nJy;
        E e = (E) b(eArr, W(j, j2));
        if (e == npx) {
            return b(U(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.nJz = eArr;
        return (E) b(eArr, W(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long dKN = dKN();
        while (true) {
            long dKM = dKM();
            long dKN2 = dKN();
            if (dKN == dKN2) {
                return (int) (dKM - dKN2);
            }
            dKN = dKN2;
        }
    }

    private void JI(int i) {
        this.nps = Math.min(i / 4, npr);
    }

    private long dKM() {
        return ae.nJC.e(this, nJw);
    }

    private long dKN() {
        return ae.nJC.e(this, nJv);
    }

    private void soProducerIndex(long j) {
        ae.nJC.a(this, nJw, j);
    }

    private void soConsumerIndex(long j) {
        ae.nJC.a(this, nJv, j);
    }

    private static long W(long j, long j2) {
        return gA(j & j2);
    }

    private static long gA(long j) {
        return nJs + (j << nJt);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.nJC.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.nJC.d(eArr, j);
    }
}
