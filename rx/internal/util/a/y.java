package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    static final int kAA = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kAG = new Object();
    private static final long kAK;
    private static final int kAL;
    private static final long kAN;
    private static final long kAO;

    static {
        int arrayIndexScale = ae.kAU.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kAL = 2;
        } else if (8 == arrayIndexScale) {
            kAL = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kAK = ae.kAU.arrayBaseOffset(Object[].class);
        try {
            kAO = ae.kAU.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                kAN = ae.kAU.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int EV = h.EV(i);
        long j = EV - 1;
        E[] eArr = (E[]) new Object[EV + 1];
        this.kAT = eArr;
        this.kAS = j;
        ET(EV);
        this.kAR = eArr;
        this.kAQ = j;
        this.kAy = j - 1;
        eX(0L);
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
        E[] eArr = this.kAT;
        long j = this.producerIndex;
        long j2 = this.kAS;
        long B = B(j, j2);
        if (j < this.kAy) {
            return a(eArr, e, j, B);
        }
        int i = this.kAB;
        if (b(eArr, B(i + j, j2)) == null) {
            this.kAy = (i + j) - 1;
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
        eX(1 + j);
        return true;
    }

    private void a(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.kAT = eArr2;
        this.kAy = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, kAG);
        eX(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, fd(eArr.length - 1), eArr2);
    }

    private E[] P(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, fd(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.kAR;
        long j = this.consumerIndex;
        long j2 = this.kAQ;
        long B = B(j, j2);
        E e = (E) b(eArr, B);
        boolean z = e == kAG;
        if (e != null && !z) {
            b(eArr, B, (Object) null);
            eY(j + 1);
            return e;
        } else if (z) {
            return a(P(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.kAR = eArr;
        long B = B(j, j2);
        E e = (E) b(eArr, B);
        if (e == null) {
            return null;
        }
        b(eArr, B, (Object) null);
        eY(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.kAR;
        long j = this.consumerIndex;
        long j2 = this.kAQ;
        E e = (E) b(eArr, B(j, j2));
        if (e == kAG) {
            return b(P(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.kAR = eArr;
        return (E) b(eArr, B(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cQb = cQb();
        while (true) {
            long cQc = cQc();
            long cQb2 = cQb();
            if (cQb == cQb2) {
                return (int) (cQc - cQb2);
            }
            cQb = cQb2;
        }
    }

    private void ET(int i) {
        this.kAB = Math.min(i / 4, kAA);
    }

    private long cQc() {
        return ae.kAU.getLongVolatile(this, kAO);
    }

    private long cQb() {
        return ae.kAU.getLongVolatile(this, kAN);
    }

    private void eX(long j) {
        ae.kAU.putOrderedLong(this, kAO, j);
    }

    private void eY(long j) {
        ae.kAU.putOrderedLong(this, kAN, j);
    }

    private static long B(long j, long j2) {
        return fd(j & j2);
    }

    private static long fd(long j) {
        return kAK + (j << kAL);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.kAU.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.kAU.getObjectVolatile(eArr, j);
    }
}
