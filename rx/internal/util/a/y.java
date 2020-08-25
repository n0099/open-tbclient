package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes5.dex */
public class y<E> extends aa<E> {
    private static final long oIY;
    private static final int oIZ;
    private static final long oJb;
    private static final long oJc;
    static final int ooX = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object opd = new Object();

    static {
        int Q = ae.oJi.Q(Object[].class);
        if (4 == Q) {
            oIZ = 2;
        } else if (8 == Q) {
            oIZ = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        oIY = ae.oJi.R(Object[].class);
        try {
            oJc = ae.oJi.b(ad.class.getDeclaredField("producerIndex"));
            try {
                oJb = ae.oJi.b(aa.class.getDeclaredField("consumerIndex"));
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
        this.oJh = eArr;
        this.oJg = j;
        NO(NR);
        this.oJf = eArr;
        this.oJe = j;
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
        E[] eArr = this.oJh;
        long j = this.producerIndex;
        long j2 = this.oJg;
        long Z = Z(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, Z);
        }
        int i = this.ooY;
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
        this.oJh = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, opd);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, hf(eArr.length - 1), eArr2);
    }

    private E[] T(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, hf(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.oJf;
        long j = this.consumerIndex;
        long j2 = this.oJe;
        long Z = Z(j, j2);
        E e = (E) b(eArr, Z);
        boolean z = e == opd;
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
        this.oJf = eArr;
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
        E[] eArr = this.oJf;
        long j = this.consumerIndex;
        long j2 = this.oJe;
        E e = (E) b(eArr, Z(j, j2));
        if (e == opd) {
            return b(T(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.oJf = eArr;
        return (E) b(eArr, Z(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long efk = efk();
        while (true) {
            long efj = efj();
            long efk2 = efk();
            if (efk == efk2) {
                return (int) (efj - efk2);
            }
            efk = efk2;
        }
    }

    private void NO(int i) {
        this.ooY = Math.min(i / 4, ooX);
    }

    private long efj() {
        return ae.oJi.e(this, oJc);
    }

    private long efk() {
        return ae.oJi.e(this, oJb);
    }

    private void soProducerIndex(long j) {
        ae.oJi.a(this, oJc, j);
    }

    private void soConsumerIndex(long j) {
        ae.oJi.a(this, oJb, j);
    }

    private static long Z(long j, long j2) {
        return hf(j & j2);
    }

    private static long hf(long j) {
        return oIY + (j << oIZ);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.oJi.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.oJi.d(eArr, j);
    }
}
