package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    static final int ksX = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object ktd = new Object();
    private static final long kth;
    private static final int kti;
    private static final long ktk;
    private static final long ktl;

    static {
        int arrayIndexScale = ae.ktr.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kti = 2;
        } else if (8 == arrayIndexScale) {
            kti = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kth = ae.ktr.arrayBaseOffset(Object[].class);
        try {
            ktl = ae.ktr.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                ktk = ae.ktr.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int Em = h.Em(i);
        long j = Em - 1;
        E[] eArr = (E[]) new Object[Em + 1];
        this.ktq = eArr;
        this.ktp = j;
        Ek(Em);
        this.kto = eArr;
        this.ktn = j;
        this.ksV = j - 1;
        eO(0L);
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
        E[] eArr = this.ktq;
        long j = this.producerIndex;
        long j2 = this.ktp;
        long B = B(j, j2);
        if (j < this.ksV) {
            return a(eArr, e, j, B);
        }
        int i = this.ksY;
        if (b(eArr, B(i + j, j2)) == null) {
            this.ksV = (i + j) - 1;
            return a(eArr, e, j, B);
        } else if (b(eArr, B(1 + j, j2)) != null) {
            return a(eArr, e, j, B);
        } else {
            a(eArr, j, B, e, j2);
            return true;
        }
    }

    private boolean a(E[] eArr, E e, long j, long j2) {
        b(eArr, j2, e);
        eO(1 + j);
        return true;
    }

    private void a(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.ktq = eArr2;
        this.ksV = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, ktd);
        eO(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, eU(eArr.length - 1), eArr2);
    }

    private E[] O(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, eU(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.kto;
        long j = this.consumerIndex;
        long j2 = this.ktn;
        long B = B(j, j2);
        E e = (E) b(eArr, B);
        boolean z = e == ktd;
        if (e != null && !z) {
            b(eArr, B, (Object) null);
            eP(j + 1);
            return e;
        } else if (z) {
            return a(O(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.kto = eArr;
        long B = B(j, j2);
        E e = (E) b(eArr, B);
        if (e == null) {
            return null;
        }
        b(eArr, B, (Object) null);
        eP(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.kto;
        long j = this.consumerIndex;
        long j2 = this.ktn;
        E e = (E) b(eArr, B(j, j2));
        if (e == ktd) {
            return b(O(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.kto = eArr;
        return (E) b(eArr, B(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cMk = cMk();
        while (true) {
            long cMl = cMl();
            long cMk2 = cMk();
            if (cMk == cMk2) {
                return (int) (cMl - cMk2);
            }
            cMk = cMk2;
        }
    }

    private void Ek(int i) {
        this.ksY = Math.min(i / 4, ksX);
    }

    private long cMl() {
        return ae.ktr.getLongVolatile(this, ktl);
    }

    private long cMk() {
        return ae.ktr.getLongVolatile(this, ktk);
    }

    private void eO(long j) {
        ae.ktr.putOrderedLong(this, ktl, j);
    }

    private void eP(long j) {
        ae.ktr.putOrderedLong(this, ktk, j);
    }

    private static long B(long j, long j2) {
        return eU(j & j2);
    }

    private static long eU(long j) {
        return kth + (j << kti);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.ktr.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.ktr.getObjectVolatile(eArr, j);
    }
}
