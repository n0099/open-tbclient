package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    static final int kEF = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kEL = new Object();
    private static final long kEP;
    private static final int kEQ;
    private static final long kES;
    private static final long kET;

    static {
        int arrayIndexScale = ae.kEZ.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kEQ = 2;
        } else if (8 == arrayIndexScale) {
            kEQ = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kEP = ae.kEZ.arrayBaseOffset(Object[].class);
        try {
            kET = ae.kEZ.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                kES = ae.kEZ.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int Dy = h.Dy(i);
        long j = Dy - 1;
        E[] eArr = (E[]) new Object[Dy + 1];
        this.kEY = eArr;
        this.kEX = j;
        Dw(Dy);
        this.kEW = eArr;
        this.kEV = j;
        this.kED = j - 1;
        ev(0L);
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
        E[] eArr = this.kEY;
        long j = this.producerIndex;
        long j2 = this.kEX;
        long H = H(j, j2);
        if (j < this.kED) {
            return a(eArr, e, j, H);
        }
        int i = this.kEG;
        if (b(eArr, H(i + j, j2)) == null) {
            this.kED = (i + j) - 1;
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
        ev(1 + j);
        return true;
    }

    private void a(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.kEY = eArr2;
        this.kED = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, kEL);
        ev(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, eB(eArr.length - 1), eArr2);
    }

    private E[] M(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, eB(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.kEW;
        long j = this.consumerIndex;
        long j2 = this.kEV;
        long H = H(j, j2);
        E e = (E) b(eArr, H);
        boolean z = e == kEL;
        if (e != null && !z) {
            b(eArr, H, (Object) null);
            ew(j + 1);
            return e;
        } else if (z) {
            return a(M(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.kEW = eArr;
        long H = H(j, j2);
        E e = (E) b(eArr, H);
        if (e == null) {
            return null;
        }
        b(eArr, H, (Object) null);
        ew(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.kEW;
        long j = this.consumerIndex;
        long j2 = this.kEV;
        E e = (E) b(eArr, H(j, j2));
        if (e == kEL) {
            return b(M(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.kEW = eArr;
        return (E) b(eArr, H(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cPn = cPn();
        while (true) {
            long cPo = cPo();
            long cPn2 = cPn();
            if (cPn == cPn2) {
                return (int) (cPo - cPn2);
            }
            cPn = cPn2;
        }
    }

    private void Dw(int i) {
        this.kEG = Math.min(i / 4, kEF);
    }

    private long cPo() {
        return ae.kEZ.getLongVolatile(this, kET);
    }

    private long cPn() {
        return ae.kEZ.getLongVolatile(this, kES);
    }

    private void ev(long j) {
        ae.kEZ.putOrderedLong(this, kET, j);
    }

    private void ew(long j) {
        ae.kEZ.putOrderedLong(this, kES, j);
    }

    private static long H(long j, long j2) {
        return eB(j & j2);
    }

    private static long eB(long j) {
        return kEP + (j << kEQ);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.kEZ.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.kEZ.getObjectVolatile(eArr, j);
    }
}
