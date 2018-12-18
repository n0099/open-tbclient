package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    private static final int iMA;
    private static final long iMC;
    private static final long iMD;
    static final int iMp = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object iMv = new Object();
    private static final long iMz;

    static {
        int arrayIndexScale = ae.iMJ.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            iMA = 2;
        } else if (8 == arrayIndexScale) {
            iMA = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        iMz = ae.iMJ.arrayBaseOffset(Object[].class);
        try {
            iMD = ae.iMJ.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                iMC = ae.iMJ.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int zt = h.zt(i);
        long j = zt - 1;
        E[] eArr = (E[]) new Object[zt + 1];
        this.iMI = eArr;
        this.iMH = j;
        zr(zt);
        this.iMG = eArr;
        this.iMF = j;
        this.iMn = j - 1;
        dO(0L);
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
        E[] eArr = this.iMI;
        long j = this.producerIndex;
        long j2 = this.iMH;
        long v = v(j, j2);
        if (j < this.iMn) {
            return a(eArr, e, j, v);
        }
        int i = this.iMq;
        if (b(eArr, v(i + j, j2)) == null) {
            this.iMn = (i + j) - 1;
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
        dO(1 + j);
        return true;
    }

    private void a(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.iMI = eArr2;
        this.iMn = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, iMv);
        dO(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, dU(eArr.length - 1), eArr2);
    }

    private E[] N(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, dU(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.iMG;
        long j = this.consumerIndex;
        long j2 = this.iMF;
        long v = v(j, j2);
        E e = (E) b(eArr, v);
        boolean z = e == iMv;
        if (e != null && !z) {
            b(eArr, v, (Object) null);
            dP(j + 1);
            return e;
        } else if (z) {
            return a(N(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.iMG = eArr;
        long v = v(j, j2);
        E e = (E) b(eArr, v);
        if (e == null) {
            return null;
        }
        b(eArr, v, (Object) null);
        dP(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.iMG;
        long j = this.consumerIndex;
        long j2 = this.iMF;
        E e = (E) b(eArr, v(j, j2));
        if (e == iMv) {
            return b(N(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.iMG = eArr;
        return (E) b(eArr, v(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long ceA = ceA();
        while (true) {
            long ceB = ceB();
            long ceA2 = ceA();
            if (ceA == ceA2) {
                return (int) (ceB - ceA2);
            }
            ceA = ceA2;
        }
    }

    private void zr(int i) {
        this.iMq = Math.min(i / 4, iMp);
    }

    private long ceB() {
        return ae.iMJ.getLongVolatile(this, iMD);
    }

    private long ceA() {
        return ae.iMJ.getLongVolatile(this, iMC);
    }

    private void dO(long j) {
        ae.iMJ.putOrderedLong(this, iMD, j);
    }

    private void dP(long j) {
        ae.iMJ.putOrderedLong(this, iMC, j);
    }

    private static long v(long j, long j2) {
        return dU(j & j2);
    }

    private static long dU(long j) {
        return iMz + (j << iMA);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.iMJ.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.iMJ.getObjectVolatile(eArr, j);
    }
}
