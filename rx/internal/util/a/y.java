package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    static final int iQG = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object iQM = new Object();
    private static final long iQQ;
    private static final int iQR;
    private static final long iQT;
    private static final long iQU;

    static {
        int arrayIndexScale = ae.iRa.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            iQR = 2;
        } else if (8 == arrayIndexScale) {
            iQR = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        iQQ = ae.iRa.arrayBaseOffset(Object[].class);
        try {
            iQU = ae.iRa.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                iQT = ae.iRa.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int zI = h.zI(i);
        long j = zI - 1;
        E[] eArr = (E[]) new Object[zI + 1];
        this.iQZ = eArr;
        this.iQY = j;
        zG(zI);
        this.iQX = eArr;
        this.iQW = j;
        this.iQE = j - 1;
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
        E[] eArr = this.iQZ;
        long j = this.producerIndex;
        long j2 = this.iQY;
        long v = v(j, j2);
        if (j < this.iQE) {
            return a(eArr, e, j, v);
        }
        int i = this.iQH;
        if (b(eArr, v(i + j, j2)) == null) {
            this.iQE = (i + j) - 1;
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
        this.iQZ = eArr2;
        this.iQE = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, iQM);
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
        E[] eArr = this.iQX;
        long j = this.consumerIndex;
        long j2 = this.iQW;
        long v = v(j, j2);
        E e = (E) b(eArr, v);
        boolean z = e == iQM;
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
        this.iQX = eArr;
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
        E[] eArr = this.iQX;
        long j = this.consumerIndex;
        long j2 = this.iQW;
        E e = (E) b(eArr, v(j, j2));
        if (e == iQM) {
            return b(N(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.iQX = eArr;
        return (E) b(eArr, v(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cfZ = cfZ();
        while (true) {
            long cga = cga();
            long cfZ2 = cfZ();
            if (cfZ == cfZ2) {
                return (int) (cga - cfZ2);
            }
            cfZ = cfZ2;
        }
    }

    private void zG(int i) {
        this.iQH = Math.min(i / 4, iQG);
    }

    private long cga() {
        return ae.iRa.getLongVolatile(this, iQU);
    }

    private long cfZ() {
        return ae.iRa.getLongVolatile(this, iQT);
    }

    private void dT(long j) {
        ae.iRa.putOrderedLong(this, iQU, j);
    }

    private void dU(long j) {
        ae.iRa.putOrderedLong(this, iQT, j);
    }

    private static long v(long j, long j2) {
        return dZ(j & j2);
    }

    private static long dZ(long j) {
        return iQQ + (j << iQR);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.iRa.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.iRa.getObjectVolatile(eArr, j);
    }
}
