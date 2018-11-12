package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    static final int iFi = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object iFo = new Object();
    private static final long iFs;
    private static final int iFt;
    private static final long iFv;
    private static final long iFw;

    static {
        int arrayIndexScale = ae.iFC.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            iFt = 2;
        } else if (8 == arrayIndexScale) {
            iFt = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        iFs = ae.iFC.arrayBaseOffset(Object[].class);
        try {
            iFw = ae.iFC.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                iFv = ae.iFC.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int yX = h.yX(i);
        long j = yX - 1;
        E[] eArr = (E[]) new Object[yX + 1];
        this.iFB = eArr;
        this.iFA = j;
        yV(yX);
        this.iFz = eArr;
        this.iFy = j;
        this.iFg = j - 1;
        dH(0L);
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
        E[] eArr = this.iFB;
        long j = this.producerIndex;
        long j2 = this.iFA;
        long v = v(j, j2);
        if (j < this.iFg) {
            return a(eArr, e, j, v);
        }
        int i = this.iFj;
        if (b(eArr, v(i + j, j2)) == null) {
            this.iFg = (i + j) - 1;
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
        dH(1 + j);
        return true;
    }

    private void a(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.iFB = eArr2;
        this.iFg = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, iFo);
        dH(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, dN(eArr.length - 1), eArr2);
    }

    private E[] N(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, dN(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.iFz;
        long j = this.consumerIndex;
        long j2 = this.iFy;
        long v = v(j, j2);
        E e = (E) b(eArr, v);
        boolean z = e == iFo;
        if (e != null && !z) {
            b(eArr, v, (Object) null);
            dI(j + 1);
            return e;
        } else if (z) {
            return a(N(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.iFz = eArr;
        long v = v(j, j2);
        E e = (E) b(eArr, v);
        if (e == null) {
            return null;
        }
        b(eArr, v, (Object) null);
        dI(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.iFz;
        long j = this.consumerIndex;
        long j2 = this.iFy;
        E e = (E) b(eArr, v(j, j2));
        if (e == iFo) {
            return b(N(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.iFz = eArr;
        return (E) b(eArr, v(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long ccy = ccy();
        while (true) {
            long ccz = ccz();
            long ccy2 = ccy();
            if (ccy == ccy2) {
                return (int) (ccz - ccy2);
            }
            ccy = ccy2;
        }
    }

    private void yV(int i) {
        this.iFj = Math.min(i / 4, iFi);
    }

    private long ccz() {
        return ae.iFC.getLongVolatile(this, iFw);
    }

    private long ccy() {
        return ae.iFC.getLongVolatile(this, iFv);
    }

    private void dH(long j) {
        ae.iFC.putOrderedLong(this, iFw, j);
    }

    private void dI(long j) {
        ae.iFC.putOrderedLong(this, iFv, j);
    }

    private static long v(long j, long j2) {
        return dN(j & j2);
    }

    private static long dN(long j) {
        return iFs + (j << iFt);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.iFC.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.iFC.getObjectVolatile(eArr, j);
    }
}
