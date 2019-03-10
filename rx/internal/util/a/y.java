package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    private static final long kbH;
    private static final int kbI;
    private static final long kbK;
    private static final long kbL;
    static final int kbx = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kbD = new Object();

    static {
        int arrayIndexScale = ae.kbR.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kbI = 2;
        } else if (8 == arrayIndexScale) {
            kbI = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kbH = ae.kbR.arrayBaseOffset(Object[].class);
        try {
            kbL = ae.kbR.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                kbK = ae.kbR.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        this.kbQ = eArr;
        this.kbP = j;
        Ds(Du);
        this.kbO = eArr;
        this.kbN = j;
        this.kbv = j - 1;
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
        E[] eArr = this.kbQ;
        long j = this.producerIndex;
        long j2 = this.kbP;
        long A = A(j, j2);
        if (j < this.kbv) {
            return a(eArr, e, j, A);
        }
        int i = this.kby;
        if (b(eArr, A(i + j, j2)) == null) {
            this.kbv = (i + j) - 1;
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
        this.kbQ = eArr2;
        this.kbv = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, kbD);
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
        E[] eArr = this.kbO;
        long j = this.consumerIndex;
        long j2 = this.kbN;
        long A = A(j, j2);
        E e = (E) b(eArr, A);
        boolean z = e == kbD;
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
        this.kbO = eArr;
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
        E[] eArr = this.kbO;
        long j = this.consumerIndex;
        long j2 = this.kbN;
        E e = (E) b(eArr, A(j, j2));
        if (e == kbD) {
            return b(N(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.kbO = eArr;
        return (E) b(eArr, A(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cEM = cEM();
        while (true) {
            long cEN = cEN();
            long cEM2 = cEM();
            if (cEM == cEM2) {
                return (int) (cEN - cEM2);
            }
            cEM = cEM2;
        }
    }

    private void Ds(int i) {
        this.kby = Math.min(i / 4, kbx);
    }

    private long cEN() {
        return ae.kbR.getLongVolatile(this, kbL);
    }

    private long cEM() {
        return ae.kbR.getLongVolatile(this, kbK);
    }

    private void eq(long j) {
        ae.kbR.putOrderedLong(this, kbL, j);
    }

    private void er(long j) {
        ae.kbR.putOrderedLong(this, kbK, j);
    }

    private static long A(long j, long j2) {
        return ew(j & j2);
    }

    private static long ew(long j) {
        return kbH + (j << kbI);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.kbR.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.kbR.getObjectVolatile(eArr, j);
    }
}
