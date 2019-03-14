package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    private static final int kbA;
    private static final long kbC;
    private static final long kbD;
    static final int kbp = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kbv = new Object();
    private static final long kbz;

    static {
        int arrayIndexScale = ae.kbJ.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kbA = 2;
        } else if (8 == arrayIndexScale) {
            kbA = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kbz = ae.kbJ.arrayBaseOffset(Object[].class);
        try {
            kbD = ae.kbJ.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                kbC = ae.kbJ.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int Du = h.Du(i);
        long j = Du - 1;
        E[] eArr = (E[]) new Object[Du + 1];
        this.kbI = eArr;
        this.kbH = j;
        Ds(Du);
        this.kbG = eArr;
        this.kbF = j;
        this.kbn = j - 1;
        eq(0L);
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
        E[] eArr = this.kbI;
        long j = this.producerIndex;
        long j2 = this.kbH;
        long A = A(j, j2);
        if (j < this.kbn) {
            return a(eArr, e, j, A);
        }
        int i = this.kbq;
        if (b(eArr, A(i + j, j2)) == null) {
            this.kbn = (i + j) - 1;
            return a(eArr, e, j, A);
        } else if (b(eArr, A(1 + j, j2)) != null) {
            return a(eArr, e, j, A);
        } else {
            a(eArr, j, A, e, j2);
            return true;
        }
    }

    private boolean a(E[] eArr, E e, long j, long j2) {
        b(eArr, j2, e);
        eq(1 + j);
        return true;
    }

    private void a(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.kbI = eArr2;
        this.kbn = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, kbv);
        eq(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, ew(eArr.length - 1), eArr2);
    }

    private E[] N(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, ew(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.kbG;
        long j = this.consumerIndex;
        long j2 = this.kbF;
        long A = A(j, j2);
        E e = (E) b(eArr, A);
        boolean z = e == kbv;
        if (e != null && !z) {
            b(eArr, A, (Object) null);
            er(j + 1);
            return e;
        } else if (z) {
            return a(N(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.kbG = eArr;
        long A = A(j, j2);
        E e = (E) b(eArr, A);
        if (e == null) {
            return null;
        }
        b(eArr, A, (Object) null);
        er(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.kbG;
        long j = this.consumerIndex;
        long j2 = this.kbF;
        E e = (E) b(eArr, A(j, j2));
        if (e == kbv) {
            return b(N(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.kbG = eArr;
        return (E) b(eArr, A(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cEP = cEP();
        while (true) {
            long cEQ = cEQ();
            long cEP2 = cEP();
            if (cEP == cEP2) {
                return (int) (cEQ - cEP2);
            }
            cEP = cEP2;
        }
    }

    private void Ds(int i) {
        this.kbq = Math.min(i / 4, kbp);
    }

    private long cEQ() {
        return ae.kbJ.getLongVolatile(this, kbD);
    }

    private long cEP() {
        return ae.kbJ.getLongVolatile(this, kbC);
    }

    private void eq(long j) {
        ae.kbJ.putOrderedLong(this, kbD, j);
    }

    private void er(long j) {
        ae.kbJ.putOrderedLong(this, kbC, j);
    }

    private static long A(long j, long j2) {
        return ew(j & j2);
    }

    private static long ew(long j) {
        return kbz + (j << kbA);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.kbJ.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.kbJ.getObjectVolatile(eArr, j);
    }
}
