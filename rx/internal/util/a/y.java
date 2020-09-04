package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes5.dex */
public class y<E> extends aa<E> {
    private static final long oJq;
    private static final int oJr;
    private static final long oJt;
    private static final long oJu;
    static final int opp = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object opw = new Object();

    static {
        int Q = ae.oJA.Q(Object[].class);
        if (4 == Q) {
            oJr = 2;
        } else if (8 == Q) {
            oJr = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        oJq = ae.oJA.R(Object[].class);
        try {
            oJu = ae.oJA.b(ad.class.getDeclaredField("producerIndex"));
            try {
                oJt = ae.oJA.b(aa.class.getDeclaredField("consumerIndex"));
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
        int NR = h.NR(i);
        long j = NR - 1;
        E[] eArr = (E[]) new Object[NR + 1];
        this.oJz = eArr;
        this.oJy = j;
        NO(NR);
        this.oJx = eArr;
        this.oJw = j;
        this.producerLookAhead = j - 1;
        soProducerIndex(0L);
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
        E[] eArr = this.oJz;
        long j = this.producerIndex;
        long j2 = this.oJy;
        long Z = Z(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, Z);
        }
        int i = this.opq;
        if (b(eArr, Z(i + j, j2)) == null) {
            this.producerLookAhead = (i + j) - 1;
            return a(eArr, e, j, Z);
        } else if (b(eArr, Z(1 + j, j2)) != null) {
            return a(eArr, e, j, Z);
        } else {
            a(eArr, j, Z, e, j2);
            return true;
        }
    }

    private boolean a(E[] eArr, E e, long j, long j2) {
        b(eArr, j2, e);
        soProducerIndex(1 + j);
        return true;
    }

    private void a(E[] eArr, long j, long j2, E e, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.oJz = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, opw);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, hh(eArr.length - 1), eArr2);
    }

    private E[] T(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, hh(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.oJx;
        long j = this.consumerIndex;
        long j2 = this.oJw;
        long Z = Z(j, j2);
        E e = (E) b(eArr, Z);
        boolean z = e == opw;
        if (e != null && !z) {
            b(eArr, Z, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(T(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.oJx = eArr;
        long Z = Z(j, j2);
        E e = (E) b(eArr, Z);
        if (e == null) {
            return null;
        }
        b(eArr, Z, (Object) null);
        soConsumerIndex(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.oJx;
        long j = this.consumerIndex;
        long j2 = this.oJw;
        E e = (E) b(eArr, Z(j, j2));
        if (e == opw) {
            return b(T(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.oJx = eArr;
        return (E) b(eArr, Z(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long eft = eft();
        while (true) {
            long efs = efs();
            long eft2 = eft();
            if (eft == eft2) {
                return (int) (efs - eft2);
            }
            eft = eft2;
        }
    }

    private void NO(int i) {
        this.opq = Math.min(i / 4, opp);
    }

    private long efs() {
        return ae.oJA.e(this, oJu);
    }

    private long eft() {
        return ae.oJA.e(this, oJt);
    }

    private void soProducerIndex(long j) {
        ae.oJA.a(this, oJu, j);
    }

    private void soConsumerIndex(long j) {
        ae.oJA.a(this, oJt, j);
    }

    private static long Z(long j, long j2) {
        return hh(j & j2);
    }

    private static long hh(long j) {
        return oJq + (j << oJr);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.oJA.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.oJA.d(eArr, j);
    }
}
