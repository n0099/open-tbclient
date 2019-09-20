package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public class y<E> extends aa<E> {
    static final int kDY = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object kEe = new Object();
    private static final long kEi;
    private static final int kEj;
    private static final long kEl;
    private static final long kEm;

    static {
        int arrayIndexScale = ae.kEs.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kEj = 2;
        } else if (8 == arrayIndexScale) {
            kEj = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kEi = ae.kEs.arrayBaseOffset(Object[].class);
        try {
            kEm = ae.kEs.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                kEl = ae.kEs.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
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
        int Fb = h.Fb(i);
        long j = Fb - 1;
        E[] eArr = (E[]) new Object[Fb + 1];
        this.kEr = eArr;
        this.kEq = j;
        EZ(Fb);
        this.kEp = eArr;
        this.kEo = j;
        this.kDW = j - 1;
        fa(0L);
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
        E[] eArr = this.kEr;
        long j = this.producerIndex;
        long j2 = this.kEq;
        long B = B(j, j2);
        if (j < this.kDW) {
            return a(eArr, e, j, B);
        }
        int i = this.kDZ;
        if (b(eArr, B(i + j, j2)) == null) {
            this.kDW = (i + j) - 1;
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
        fa(1 + j);
        return true;
    }

    private void a(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.kEr = eArr2;
        this.kDW = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, kEe);
        fa(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, fg(eArr.length - 1), eArr2);
    }

    private E[] P(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, fg(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.kEp;
        long j = this.consumerIndex;
        long j2 = this.kEo;
        long B = B(j, j2);
        E e = (E) b(eArr, B);
        boolean z = e == kEe;
        if (e != null && !z) {
            b(eArr, B, (Object) null);
            fb(j + 1);
            return e;
        } else if (z) {
            return a(P(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.kEp = eArr;
        long B = B(j, j2);
        E e = (E) b(eArr, B);
        if (e == null) {
            return null;
        }
        b(eArr, B, (Object) null);
        fb(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.kEp;
        long j = this.consumerIndex;
        long j2 = this.kEo;
        E e = (E) b(eArr, B(j, j2));
        if (e == kEe) {
            return b(P(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.kEp = eArr;
        return (E) b(eArr, B(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long cRi = cRi();
        while (true) {
            long cRj = cRj();
            long cRi2 = cRi();
            if (cRi == cRi2) {
                return (int) (cRj - cRi2);
            }
            cRi = cRi2;
        }
    }

    private void EZ(int i) {
        this.kDZ = Math.min(i / 4, kDY);
    }

    private long cRj() {
        return ae.kEs.getLongVolatile(this, kEm);
    }

    private long cRi() {
        return ae.kEs.getLongVolatile(this, kEl);
    }

    private void fa(long j) {
        ae.kEs.putOrderedLong(this, kEm, j);
    }

    private void fb(long j) {
        ae.kEs.putOrderedLong(this, kEl, j);
    }

    private static long B(long j, long j2) {
        return fg(j & j2);
    }

    private static long fg(long j) {
        return kEi + (j << kEj);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.kEs.putOrderedObject(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.kEs.getObjectVolatile(eArr, j);
    }
}
