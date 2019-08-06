package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    static final int kBG = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kBM = new Object();
    private static final long kBQ;
    private static final int kBR;
    private static final long kBT;
    private static final long kBU;

    static {
        int arrayIndexScale = ae.kCa.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kBR = 2;
        } else if (8 == arrayIndexScale) {
            kBR = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kBQ = ae.kCa.arrayBaseOffset(Object[].class);
        try {
            kBU = ae.kCa.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                kBT = ae.kCa.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int EX = h.EX(i);
        long j = EX - 1;
        E[] eArr = (E[]) new Object[EX + 1];
        this.kBZ = eArr;
        this.kBY = j;
        EV(EX);
        this.kBX = eArr;
        this.kBW = j;
        this.kBE = j - 1;
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
        E[] eArr = this.kBZ;
        long j = this.producerIndex;
        long j2 = this.kBY;
        long B = B(j, j2);
        if (j < this.kBE) {
            return a(eArr, e, j, B);
        }
        int i = this.kBH;
        if (b(eArr, B(i + j, j2)) == null) {
            this.kBE = (i + j) - 1;
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
        this.kBZ = eArr2;
        this.kBE = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, kBM);
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
        E[] eArr = this.kBX;
        long j = this.consumerIndex;
        long j2 = this.kBW;
        long B = B(j, j2);
        E e = (E) b(eArr, B);
        boolean z = e == kBM;
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
        this.kBX = eArr;
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
        E[] eArr = this.kBX;
        long j = this.consumerIndex;
        long j2 = this.kBW;
        E e = (E) b(eArr, B(j, j2));
        if (e == kBM) {
            return b(P(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.kBX = eArr;
        return (E) b(eArr, B(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cQw = cQw();
        while (true) {
            long cQx = cQx();
            long cQw2 = cQw();
            if (cQw == cQw2) {
                return (int) (cQx - cQw2);
            }
            cQw = cQw2;
        }
    }

    private void EV(int i) {
        this.kBH = Math.min(i / 4, kBG);
    }

    private long cQx() {
        return ae.kCa.getLongVolatile(this, kBU);
    }

    private long cQw() {
        return ae.kCa.getLongVolatile(this, kBT);
    }

    private void eX(long j) {
        ae.kCa.putOrderedLong(this, kBU, j);
    }

    private void eY(long j) {
        ae.kCa.putOrderedLong(this, kBT, j);
    }

    private static long B(long j, long j2) {
        return fd(j & j2);
    }

    private static long fd(long j) {
        return kBQ + (j << kBR);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.kCa.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.kCa.getObjectVolatile(eArr, j);
    }
}
