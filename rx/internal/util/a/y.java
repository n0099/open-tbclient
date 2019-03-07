package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    static final int kbe = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kbk = new Object();
    private static final long kbo;
    private static final int kbp;
    private static final long kbr;
    private static final long kbs;

    static {
        int arrayIndexScale = ae.kby.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kbp = 2;
        } else if (8 == arrayIndexScale) {
            kbp = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kbo = ae.kby.arrayBaseOffset(Object[].class);
        try {
            kbs = ae.kby.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                kbr = ae.kby.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int Dt = h.Dt(i);
        long j = Dt - 1;
        E[] eArr = (E[]) new Object[Dt + 1];
        this.kbx = eArr;
        this.kbw = j;
        Dr(Dt);
        this.kbv = eArr;
        this.kbu = j;
        this.kbc = j - 1;
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
        E[] eArr = this.kbx;
        long j = this.producerIndex;
        long j2 = this.kbw;
        long A = A(j, j2);
        if (j < this.kbc) {
            return a(eArr, e, j, A);
        }
        int i = this.kbf;
        if (b(eArr, A(i + j, j2)) == null) {
            this.kbc = (i + j) - 1;
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
        this.kbx = eArr2;
        this.kbc = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, kbk);
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
        E[] eArr = this.kbv;
        long j = this.consumerIndex;
        long j2 = this.kbu;
        long A = A(j, j2);
        E e = (E) b(eArr, A);
        boolean z = e == kbk;
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
        this.kbv = eArr;
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
        E[] eArr = this.kbv;
        long j = this.consumerIndex;
        long j2 = this.kbu;
        E e = (E) b(eArr, A(j, j2));
        if (e == kbk) {
            return b(N(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.kbv = eArr;
        return (E) b(eArr, A(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cEC = cEC();
        while (true) {
            long cED = cED();
            long cEC2 = cEC();
            if (cEC == cEC2) {
                return (int) (cED - cEC2);
            }
            cEC = cEC2;
        }
    }

    private void Dr(int i) {
        this.kbf = Math.min(i / 4, kbe);
    }

    private long cED() {
        return ae.kby.getLongVolatile(this, kbs);
    }

    private long cEC() {
        return ae.kby.getLongVolatile(this, kbr);
    }

    private void eq(long j) {
        ae.kby.putOrderedLong(this, kbs, j);
    }

    private void er(long j) {
        ae.kby.putOrderedLong(this, kbr, j);
    }

    private static long A(long j, long j2) {
        return ew(j & j2);
    }

    private static long ew(long j) {
        return kbo + (j << kbp);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.kby.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.kby.getObjectVolatile(eArr, j);
    }
}
