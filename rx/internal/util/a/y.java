package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    static final int ktb = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kth = new Object();
    private static final long ktl;
    private static final int ktm;
    private static final long kto;
    private static final long ktp;

    static {
        int arrayIndexScale = ae.ktv.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            ktm = 2;
        } else if (8 == arrayIndexScale) {
            ktm = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        ktl = ae.ktv.arrayBaseOffset(Object[].class);
        try {
            ktp = ae.ktv.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                kto = ae.ktv.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        this.ktu = eArr;
        this.ktt = j;
        Ek(Em);
        this.kts = eArr;
        this.ktr = j;
        this.ksZ = j - 1;
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
        E[] eArr = this.ktu;
        long j = this.producerIndex;
        long j2 = this.ktt;
        long B = B(j, j2);
        if (j < this.ksZ) {
            return a(eArr, e, j, B);
        }
        int i = this.ktc;
        if (b(eArr, B(i + j, j2)) == null) {
            this.ksZ = (i + j) - 1;
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
        this.ktu = eArr2;
        this.ksZ = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, kth);
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
        E[] eArr = this.kts;
        long j = this.consumerIndex;
        long j2 = this.ktr;
        long B = B(j, j2);
        E e = (E) b(eArr, B);
        boolean z = e == kth;
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
        this.kts = eArr;
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
        E[] eArr = this.kts;
        long j = this.consumerIndex;
        long j2 = this.ktr;
        E e = (E) b(eArr, B(j, j2));
        if (e == kth) {
            return b(O(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.kts = eArr;
        return (E) b(eArr, B(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cMl = cMl();
        while (true) {
            long cMm = cMm();
            long cMl2 = cMl();
            if (cMl == cMl2) {
                return (int) (cMm - cMl2);
            }
            cMl = cMl2;
        }
    }

    private void Ek(int i) {
        this.ktc = Math.min(i / 4, ktb);
    }

    private long cMm() {
        return ae.ktv.getLongVolatile(this, ktp);
    }

    private long cMl() {
        return ae.ktv.getLongVolatile(this, kto);
    }

    private void eO(long j) {
        ae.ktv.putOrderedLong(this, ktp, j);
    }

    private void eP(long j) {
        ae.ktv.putOrderedLong(this, kto, j);
    }

    private static long B(long j, long j2) {
        return eU(j & j2);
    }

    private static long eU(long j) {
        return ktl + (j << ktm);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.ktv.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.ktv.getObjectVolatile(eArr, j);
    }
}
