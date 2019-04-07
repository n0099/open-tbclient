package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    static final int kaH = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kaN = new Object();
    private static final long kaR;
    private static final int kaS;
    private static final long kaU;
    private static final long kaV;

    static {
        int arrayIndexScale = ae.kbb.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kaS = 2;
        } else if (8 == arrayIndexScale) {
            kaS = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kaR = ae.kbb.arrayBaseOffset(Object[].class);
        try {
            kaV = ae.kbb.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                kaU = ae.kbb.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        this.kba = eArr;
        this.kaZ = j;
        Di(Dk);
        this.kaY = eArr;
        this.kaX = j;
        this.kaF = j - 1;
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
        E[] eArr = this.kba;
        long j = this.producerIndex;
        long j2 = this.kaZ;
        long A = A(j, j2);
        if (j < this.kaF) {
            return a(eArr, e, j, A);
        }
        int i = this.kaI;
        if (b(eArr, A(i + j, j2)) == null) {
            this.kaF = (i + j) - 1;
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
        this.kba = eArr2;
        this.kaF = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, kaN);
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
        E[] eArr = this.kaY;
        long j = this.consumerIndex;
        long j2 = this.kaX;
        long A = A(j, j2);
        E e = (E) b(eArr, A);
        boolean z = e == kaN;
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
        this.kaY = eArr;
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
        E[] eArr = this.kaY;
        long j = this.consumerIndex;
        long j2 = this.kaX;
        E e = (E) b(eArr, A(j, j2));
        if (e == kaN) {
            return b(N(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.kaY = eArr;
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
        this.kaI = Math.min(i / 4, kaH);
    }

    private long cEF() {
        return ae.kbb.getLongVolatile(this, kaV);
    }

    private long cEE() {
        return ae.kbb.getLongVolatile(this, kaU);
    }

    private void ep(long j) {
        ae.kbb.putOrderedLong(this, kaV, j);
    }

    private void eq(long j) {
        ae.kbb.putOrderedLong(this, kaU, j);
    }

    private static long A(long j, long j2) {
        return ev(j & j2);
    }

    private static long ev(long j) {
        return kaR + (j << kaS);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.kbb.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.kbb.getObjectVolatile(eArr, j);
    }
}
