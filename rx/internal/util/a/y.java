package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    private static final long iDI;
    private static final int iDJ;
    private static final long iDL;
    private static final long iDM;
    static final int iDy = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object iDE = new Object();

    static {
        int arrayIndexScale = ae.iDS.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            iDJ = 2;
        } else if (8 == arrayIndexScale) {
            iDJ = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        iDI = ae.iDS.arrayBaseOffset(Object[].class);
        try {
            iDM = ae.iDS.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                iDL = ae.iDS.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int yE = h.yE(i);
        long j = yE - 1;
        E[] eArr = (E[]) new Object[yE + 1];
        this.iDR = eArr;
        this.iDQ = j;
        yC(yE);
        this.iDP = eArr;
        this.iDO = j;
        this.iDw = j - 1;
        dM(0L);
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
        E[] eArr = this.iDR;
        long j = this.producerIndex;
        long j2 = this.iDQ;
        long w = w(j, j2);
        if (j < this.iDw) {
            return a(eArr, e, j, w);
        }
        int i = this.iDz;
        if (b(eArr, w(i + j, j2)) == null) {
            this.iDw = (i + j) - 1;
            return a(eArr, e, j, w);
        } else if (b(eArr, w(1 + j, j2)) != null) {
            return a(eArr, e, j, w);
        } else {
            a(eArr, j, w, e, j2);
            return true;
        }
    }

    private boolean a(E[] eArr, E e, long j, long j2) {
        b(eArr, j2, e);
        dM(1 + j);
        return true;
    }

    private void a(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.iDR = eArr2;
        this.iDw = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, iDE);
        dM(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, dS(eArr.length - 1), eArr2);
    }

    private E[] M(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, dS(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.iDP;
        long j = this.consumerIndex;
        long j2 = this.iDO;
        long w = w(j, j2);
        E e = (E) b(eArr, w);
        boolean z = e == iDE;
        if (e != null && !z) {
            b(eArr, w, (Object) null);
            dN(j + 1);
            return e;
        } else if (z) {
            return a(M(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.iDP = eArr;
        long w = w(j, j2);
        E e = (E) b(eArr, w);
        if (e == null) {
            return null;
        }
        b(eArr, w, (Object) null);
        dN(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.iDP;
        long j = this.consumerIndex;
        long j2 = this.iDO;
        E e = (E) b(eArr, w(j, j2));
        if (e == iDE) {
            return b(M(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.iDP = eArr;
        return (E) b(eArr, w(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cdb = cdb();
        while (true) {
            long cdc = cdc();
            long cdb2 = cdb();
            if (cdb == cdb2) {
                return (int) (cdc - cdb2);
            }
            cdb = cdb2;
        }
    }

    private void yC(int i) {
        this.iDz = Math.min(i / 4, iDy);
    }

    private long cdc() {
        return ae.iDS.getLongVolatile(this, iDM);
    }

    private long cdb() {
        return ae.iDS.getLongVolatile(this, iDL);
    }

    private void dM(long j) {
        ae.iDS.putOrderedLong(this, iDM, j);
    }

    private void dN(long j) {
        ae.iDS.putOrderedLong(this, iDL, j);
    }

    private static long w(long j, long j2) {
        return dS(j & j2);
    }

    private static long dS(long j) {
        return iDI + (j << iDJ);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.iDS.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.iDS.getObjectVolatile(eArr, j);
    }
}
