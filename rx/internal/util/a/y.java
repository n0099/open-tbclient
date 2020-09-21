package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes7.dex */
public class y<E> extends aa<E> {
    private static final long oSV;
    private static final int oSW;
    private static final long oSY;
    private static final long oSZ;
    static final int oyY = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object oze = new Object();

    static {
        int Q = ae.oTf.Q(Object[].class);
        if (4 == Q) {
            oSW = 2;
        } else if (8 == Q) {
            oSW = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        oSV = ae.oTf.R(Object[].class);
        try {
            oSZ = ae.oTf.b(ad.class.getDeclaredField("producerIndex"));
            try {
                oSY = ae.oTf.b(aa.class.getDeclaredField("consumerIndex"));
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
        int Ow = h.Ow(i);
        long j = Ow - 1;
        E[] eArr = (E[]) new Object[Ow + 1];
        this.oTe = eArr;
        this.oTd = j;
        Ot(Ow);
        this.oTc = eArr;
        this.oTb = j;
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
        E[] eArr = this.oTe;
        long j = this.producerIndex;
        long j2 = this.oTd;
        long W = W(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, W);
        }
        int i = this.oyZ;
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
        this.oTe = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, oze);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, hv(eArr.length - 1), eArr2);
    }

    private E[] T(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, hv(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.oTc;
        long j = this.consumerIndex;
        long j2 = this.oTb;
        long W = W(j, j2);
        E e = (E) b(eArr, W);
        boolean z = e == oze;
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
        this.oTc = eArr;
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
        E[] eArr = this.oTc;
        long j = this.consumerIndex;
        long j2 = this.oTb;
        E e = (E) b(eArr, W(j, j2));
        if (e == oze) {
            return b(T(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.oTc = eArr;
        return (E) b(eArr, W(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long ejq = ejq();
        while (true) {
            long ejp = ejp();
            long ejq2 = ejq();
            if (ejq == ejq2) {
                return (int) (ejp - ejq2);
            }
            ejq = ejq2;
        }
    }

    private void Ot(int i) {
        this.oyZ = Math.min(i / 4, oyY);
    }

    private long ejp() {
        return ae.oTf.e(this, oSZ);
    }

    private long ejq() {
        return ae.oTf.e(this, oSY);
    }

    private void soProducerIndex(long j) {
        ae.oTf.a(this, oSZ, j);
    }

    private void soConsumerIndex(long j) {
        ae.oTf.a(this, oSY, j);
    }

    private static long W(long j, long j2) {
        return hv(j & j2);
    }

    private static long hv(long j) {
        return oSV + (j << oSW);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.oTf.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.oTf.d(eArr, j);
    }
}
