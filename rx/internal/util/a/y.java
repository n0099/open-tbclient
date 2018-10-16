package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    private static final long iDH;
    private static final int iDI;
    private static final long iDK;
    private static final long iDL;
    static final int iDx = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object iDD = new Object();

    static {
        int arrayIndexScale = ae.iDR.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            iDI = 2;
        } else if (8 == arrayIndexScale) {
            iDI = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        iDH = ae.iDR.arrayBaseOffset(Object[].class);
        try {
            iDL = ae.iDR.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                iDK = ae.iDR.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        this.iDQ = eArr;
        this.iDP = j;
        yC(yE);
        this.iDO = eArr;
        this.iDN = j;
        this.iDv = j - 1;
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
        E[] eArr = this.iDQ;
        long j = this.producerIndex;
        long j2 = this.iDP;
        long w = w(j, j2);
        if (j < this.iDv) {
            return a(eArr, e, j, w);
        }
        int i = this.iDy;
        if (b(eArr, w(i + j, j2)) == null) {
            this.iDv = (i + j) - 1;
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
        this.iDQ = eArr2;
        this.iDv = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, iDD);
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
        E[] eArr = this.iDO;
        long j = this.consumerIndex;
        long j2 = this.iDN;
        long w = w(j, j2);
        E e = (E) b(eArr, w);
        boolean z = e == iDD;
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
        this.iDO = eArr;
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
        E[] eArr = this.iDO;
        long j = this.consumerIndex;
        long j2 = this.iDN;
        E e = (E) b(eArr, w(j, j2));
        if (e == iDD) {
            return b(M(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.iDO = eArr;
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
        this.iDy = Math.min(i / 4, iDx);
    }

    private long cdc() {
        return ae.iDR.getLongVolatile(this, iDL);
    }

    private long cdb() {
        return ae.iDR.getLongVolatile(this, iDK);
    }

    private void dM(long j) {
        ae.iDR.putOrderedLong(this, iDL, j);
    }

    private void dN(long j) {
        ae.iDR.putOrderedLong(this, iDK, j);
    }

    private static long w(long j, long j2) {
        return dS(j & j2);
    }

    private static long dS(long j) {
        return iDH + (j << iDI);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.iDR.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.iDR.getObjectVolatile(eArr, j);
    }
}
