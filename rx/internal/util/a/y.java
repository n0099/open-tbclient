package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    static final int kaI = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kaO = new Object();
    private static final long kaS;
    private static final int kaT;
    private static final long kaV;
    private static final long kaW;

    static {
        int arrayIndexScale = ae.kbc.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kaT = 2;
        } else if (8 == arrayIndexScale) {
            kaT = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kaS = ae.kbc.arrayBaseOffset(Object[].class);
        try {
            kaW = ae.kbc.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                kaV = ae.kbc.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int Dk = h.Dk(i);
        long j = Dk - 1;
        E[] eArr = (E[]) new Object[Dk + 1];
        this.kbb = eArr;
        this.kba = j;
        Di(Dk);
        this.kaZ = eArr;
        this.kaY = j;
        this.kaG = j - 1;
        ep(0L);
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
        E[] eArr = this.kbb;
        long j = this.producerIndex;
        long j2 = this.kba;
        long A = A(j, j2);
        if (j < this.kaG) {
            return a(eArr, e, j, A);
        }
        int i = this.kaJ;
        if (b(eArr, A(i + j, j2)) == null) {
            this.kaG = (i + j) - 1;
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
        ep(1 + j);
        return true;
    }

    private void a(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.kbb = eArr2;
        this.kaG = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, kaO);
        ep(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, ev(eArr.length - 1), eArr2);
    }

    private E[] N(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, ev(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.kaZ;
        long j = this.consumerIndex;
        long j2 = this.kaY;
        long A = A(j, j2);
        E e = (E) b(eArr, A);
        boolean z = e == kaO;
        if (e != null && !z) {
            b(eArr, A, (Object) null);
            eq(j + 1);
            return e;
        } else if (z) {
            return a(N(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.kaZ = eArr;
        long A = A(j, j2);
        E e = (E) b(eArr, A);
        if (e == null) {
            return null;
        }
        b(eArr, A, (Object) null);
        eq(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.kaZ;
        long j = this.consumerIndex;
        long j2 = this.kaY;
        E e = (E) b(eArr, A(j, j2));
        if (e == kaO) {
            return b(N(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.kaZ = eArr;
        return (E) b(eArr, A(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cEE = cEE();
        while (true) {
            long cEF = cEF();
            long cEE2 = cEE();
            if (cEE == cEE2) {
                return (int) (cEF - cEE2);
            }
            cEE = cEE2;
        }
    }

    private void Di(int i) {
        this.kaJ = Math.min(i / 4, kaI);
    }

    private long cEF() {
        return ae.kbc.getLongVolatile(this, kaW);
    }

    private long cEE() {
        return ae.kbc.getLongVolatile(this, kaV);
    }

    private void ep(long j) {
        ae.kbc.putOrderedLong(this, kaW, j);
    }

    private void eq(long j) {
        ae.kbc.putOrderedLong(this, kaV, j);
    }

    private static long A(long j, long j2) {
        return ev(j & j2);
    }

    private static long ev(long j) {
        return kaS + (j << kaT);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.kbc.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.kbc.getObjectVolatile(eArr, j);
    }
}
