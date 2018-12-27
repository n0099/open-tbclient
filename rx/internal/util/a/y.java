package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    private static final long iPJ;
    private static final int iPK;
    private static final long iPM;
    private static final long iPN;
    static final int iPz = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object iPF = new Object();

    static {
        int arrayIndexScale = ae.iPT.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            iPK = 2;
        } else if (8 == arrayIndexScale) {
            iPK = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        iPJ = ae.iPT.arrayBaseOffset(Object[].class);
        try {
            iPN = ae.iPT.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                iPM = ae.iPT.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int zG = h.zG(i);
        long j = zG - 1;
        E[] eArr = (E[]) new Object[zG + 1];
        this.iPS = eArr;
        this.iPR = j;
        zE(zG);
        this.iPQ = eArr;
        this.iPP = j;
        this.iPx = j - 1;
        dT(0L);
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
        E[] eArr = this.iPS;
        long j = this.producerIndex;
        long j2 = this.iPR;
        long v = v(j, j2);
        if (j < this.iPx) {
            return a(eArr, e, j, v);
        }
        int i = this.iPA;
        if (b(eArr, v(i + j, j2)) == null) {
            this.iPx = (i + j) - 1;
            return a(eArr, e, j, v);
        } else if (b(eArr, v(1 + j, j2)) != null) {
            return a(eArr, e, j, v);
        } else {
            a(eArr, j, v, e, j2);
            return true;
        }
    }

    private boolean a(E[] eArr, E e, long j, long j2) {
        b(eArr, j2, e);
        dT(1 + j);
        return true;
    }

    private void a(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.iPS = eArr2;
        this.iPx = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, iPF);
        dT(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, dZ(eArr.length - 1), eArr2);
    }

    private E[] N(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, dZ(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.iPQ;
        long j = this.consumerIndex;
        long j2 = this.iPP;
        long v = v(j, j2);
        E e = (E) b(eArr, v);
        boolean z = e == iPF;
        if (e != null && !z) {
            b(eArr, v, (Object) null);
            dU(j + 1);
            return e;
        } else if (z) {
            return a(N(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.iPQ = eArr;
        long v = v(j, j2);
        E e = (E) b(eArr, v);
        if (e == null) {
            return null;
        }
        b(eArr, v, (Object) null);
        dU(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.iPQ;
        long j = this.consumerIndex;
        long j2 = this.iPP;
        E e = (E) b(eArr, v(j, j2));
        if (e == iPF) {
            return b(N(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.iPQ = eArr;
        return (E) b(eArr, v(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cfr = cfr();
        while (true) {
            long cfs = cfs();
            long cfr2 = cfr();
            if (cfr == cfr2) {
                return (int) (cfs - cfr2);
            }
            cfr = cfr2;
        }
    }

    private void zE(int i) {
        this.iPA = Math.min(i / 4, iPz);
    }

    private long cfs() {
        return ae.iPT.getLongVolatile(this, iPN);
    }

    private long cfr() {
        return ae.iPT.getLongVolatile(this, iPM);
    }

    private void dT(long j) {
        ae.iPT.putOrderedLong(this, iPN, j);
    }

    private void dU(long j) {
        ae.iPT.putOrderedLong(this, iPM, j);
    }

    private static long v(long j, long j2) {
        return dZ(j & j2);
    }

    private static long dZ(long j) {
        return iPJ + (j << iPK);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.iPT.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.iPT.getObjectVolatile(eArr, j);
    }
}
