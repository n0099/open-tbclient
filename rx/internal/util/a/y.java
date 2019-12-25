package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes4.dex */
public class y<E> extends aa<E> {
    static final int mVT = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object mVZ = new Object();
    private static final long niR;
    private static final int niS;
    private static final long niU;
    private static final long niV;

    static {
        int Q = ae.njb.Q(Object[].class);
        if (4 == Q) {
            niS = 2;
        } else if (8 == Q) {
            niS = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        niR = ae.njb.R(Object[].class);
        try {
            niV = ae.njb.b(ad.class.getDeclaredField("producerIndex"));
            try {
                niU = ae.njb.b(aa.class.getDeclaredField("consumerIndex"));
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
        int MK = h.MK(i);
        long j = MK - 1;
        E[] eArr = (E[]) new Object[MK + 1];
        this.nja = eArr;
        this.niZ = j;
        MH(MK);
        this.niY = eArr;
        this.niX = j;
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
        E[] eArr = this.nja;
        long j = this.producerIndex;
        long j2 = this.niZ;
        long ai = ai(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, ai);
        }
        int i = this.mVU;
        if (b(eArr, ai(i + j, j2)) == null) {
            this.producerLookAhead = (i + j) - 1;
            return a(eArr, e, j, ai);
        } else if (b(eArr, ai(1 + j, j2)) != null) {
            return a(eArr, e, j, ai);
        } else {
            a(eArr, j, ai, e, j2);
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
        this.nja = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, mVZ);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, hb(eArr.length - 1), eArr2);
    }

    private E[] Q(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, hb(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.niY;
        long j = this.consumerIndex;
        long j2 = this.niX;
        long ai = ai(j, j2);
        E e = (E) b(eArr, ai);
        boolean z = e == mVZ;
        if (e != null && !z) {
            b(eArr, ai, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(Q(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.niY = eArr;
        long ai = ai(j, j2);
        E e = (E) b(eArr, ai);
        if (e == null) {
            return null;
        }
        b(eArr, ai, (Object) null);
        soConsumerIndex(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.niY;
        long j = this.consumerIndex;
        long j2 = this.niX;
        E e = (E) b(eArr, ai(j, j2));
        if (e == mVZ) {
            return b(Q(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.niY = eArr;
        return (E) b(eArr, ai(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long dEb = dEb();
        while (true) {
            long dEa = dEa();
            long dEb2 = dEb();
            if (dEb == dEb2) {
                return (int) (dEa - dEb2);
            }
            dEb = dEb2;
        }
    }

    private void MH(int i) {
        this.mVU = Math.min(i / 4, mVT);
    }

    private long dEa() {
        return ae.njb.d(this, niV);
    }

    private long dEb() {
        return ae.njb.d(this, niU);
    }

    private void soProducerIndex(long j) {
        ae.njb.a(this, niV, j);
    }

    private void soConsumerIndex(long j) {
        ae.njb.a(this, niU, j);
    }

    private static long ai(long j, long j2) {
        return hb(j & j2);
    }

    private static long hb(long j) {
        return niR + (j << niS);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.njb.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.njb.c(eArr, j);
    }
}
