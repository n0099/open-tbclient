package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    static final int ksY = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kte = new Object();
    private static final long kti;
    private static final int ktj;
    private static final long ktl;
    private static final long ktm;

    static {
        int arrayIndexScale = ae.kts.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            ktj = 2;
        } else if (8 == arrayIndexScale) {
            ktj = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kti = ae.kts.arrayBaseOffset(Object[].class);
        try {
            ktm = ae.kts.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                ktl = ae.kts.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        this.ktr = eArr;
        this.ktq = j;
        Ek(Em);
        this.ktp = eArr;
        this.kto = j;
        this.ksW = j - 1;
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
        E[] eArr = this.ktr;
        long j = this.producerIndex;
        long j2 = this.ktq;
        long B = B(j, j2);
        if (j < this.ksW) {
            return a(eArr, e, j, B);
        }
        int i = this.ksZ;
        if (b(eArr, B(i + j, j2)) == null) {
            this.ksW = (i + j) - 1;
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
        this.ktr = eArr2;
        this.ksW = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, kte);
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
        E[] eArr = this.ktp;
        long j = this.consumerIndex;
        long j2 = this.kto;
        long B = B(j, j2);
        E e = (E) b(eArr, B);
        boolean z = e == kte;
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
        this.ktp = eArr;
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
        E[] eArr = this.ktp;
        long j = this.consumerIndex;
        long j2 = this.kto;
        E e = (E) b(eArr, B(j, j2));
        if (e == kte) {
            return b(O(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.ktp = eArr;
        return (E) b(eArr, B(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cMm = cMm();
        while (true) {
            long cMn = cMn();
            long cMm2 = cMm();
            if (cMm == cMm2) {
                return (int) (cMn - cMm2);
            }
            cMm = cMm2;
        }
    }

    private void Ek(int i) {
        this.ksZ = Math.min(i / 4, ksY);
    }

    private long cMn() {
        return ae.kts.getLongVolatile(this, ktm);
    }

    private long cMm() {
        return ae.kts.getLongVolatile(this, ktl);
    }

    private void eO(long j) {
        ae.kts.putOrderedLong(this, ktm, j);
    }

    private void eP(long j) {
        ae.kts.putOrderedLong(this, ktl, j);
    }

    private static long B(long j, long j2) {
        return eU(j & j2);
    }

    private static long eU(long j) {
        return kti + (j << ktj);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.kts.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.kts.getObjectVolatile(eArr, j);
    }
}
