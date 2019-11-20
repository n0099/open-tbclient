package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    static final int kDO = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kDU = new Object();
    private static final long kDY;
    private static final int kDZ;
    private static final long kEb;
    private static final long kEc;

    static {
        int arrayIndexScale = ae.kEi.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kDZ = 2;
        } else if (8 == arrayIndexScale) {
            kDZ = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kDY = ae.kEi.arrayBaseOffset(Object[].class);
        try {
            kEc = ae.kEi.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                kEb = ae.kEi.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int Dx = h.Dx(i);
        long j = Dx - 1;
        E[] eArr = (E[]) new Object[Dx + 1];
        this.kEh = eArr;
        this.kEg = j;
        Dv(Dx);
        this.kEf = eArr;
        this.kEe = j;
        this.kDM = j - 1;
        eu(0L);
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
        E[] eArr = this.kEh;
        long j = this.producerIndex;
        long j2 = this.kEg;
        long H = H(j, j2);
        if (j < this.kDM) {
            return a(eArr, e, j, H);
        }
        int i = this.kDP;
        if (b(eArr, H(i + j, j2)) == null) {
            this.kDM = (i + j) - 1;
            return a(eArr, e, j, H);
        } else if (b(eArr, H(1 + j, j2)) != null) {
            return a(eArr, e, j, H);
        } else {
            a(eArr, j, H, e, j2);
            return true;
        }
    }

    private boolean a(E[] eArr, E e, long j, long j2) {
        b(eArr, j2, e);
        eu(1 + j);
        return true;
    }

    private void a(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.kEh = eArr2;
        this.kDM = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, kDU);
        eu(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, eA(eArr.length - 1), eArr2);
    }

    private E[] M(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, eA(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.kEf;
        long j = this.consumerIndex;
        long j2 = this.kEe;
        long H = H(j, j2);
        E e = (E) b(eArr, H);
        boolean z = e == kDU;
        if (e != null && !z) {
            b(eArr, H, (Object) null);
            ev(j + 1);
            return e;
        } else if (z) {
            return a(M(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.kEf = eArr;
        long H = H(j, j2);
        E e = (E) b(eArr, H);
        if (e == null) {
            return null;
        }
        b(eArr, H, (Object) null);
        ev(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.kEf;
        long j = this.consumerIndex;
        long j2 = this.kEe;
        E e = (E) b(eArr, H(j, j2));
        if (e == kDU) {
            return b(M(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.kEf = eArr;
        return (E) b(eArr, H(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cPl = cPl();
        while (true) {
            long cPm = cPm();
            long cPl2 = cPl();
            if (cPl == cPl2) {
                return (int) (cPm - cPl2);
            }
            cPl = cPl2;
        }
    }

    private void Dv(int i) {
        this.kDP = Math.min(i / 4, kDO);
    }

    private long cPm() {
        return ae.kEi.getLongVolatile(this, kEc);
    }

    private long cPl() {
        return ae.kEi.getLongVolatile(this, kEb);
    }

    private void eu(long j) {
        ae.kEi.putOrderedLong(this, kEc, j);
    }

    private void ev(long j) {
        ae.kEi.putOrderedLong(this, kEb, j);
    }

    private static long H(long j, long j2) {
        return eA(j & j2);
    }

    private static long eA(long j) {
        return kDY + (j << kDZ);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.kEi.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.kEi.getObjectVolatile(eArr, j);
    }
}
