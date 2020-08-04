package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public class y<E> extends aa<E> {
    static final int nVb = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nVh = new Object();
    private static final long opd;
    private static final int ope;
    private static final long opg;
    private static final long oph;

    static {
        int Q = ae.opn.Q(Object[].class);
        if (4 == Q) {
            ope = 2;
        } else if (8 == Q) {
            ope = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        opd = ae.opn.R(Object[].class);
        try {
            oph = ae.opn.b(ad.class.getDeclaredField("producerIndex"));
            try {
                opg = ae.opn.b(aa.class.getDeclaredField("consumerIndex"));
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
        int Lo = h.Lo(i);
        long j = Lo - 1;
        E[] eArr = (E[]) new Object[Lo + 1];
        this.opm = eArr;
        this.opl = j;
        Ll(Lo);
        this.opk = eArr;
        this.opj = j;
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
        E[] eArr = this.opm;
        long j = this.producerIndex;
        long j2 = this.opl;
        long Z = Z(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, Z);
        }
        int i = this.nVc;
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
        this.opm = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, nVh);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, gS(eArr.length - 1), eArr2);
    }

    private E[] U(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, gS(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.opk;
        long j = this.consumerIndex;
        long j2 = this.opj;
        long Z = Z(j, j2);
        E e = (E) b(eArr, Z);
        boolean z = e == nVh;
        if (e != null && !z) {
            b(eArr, Z, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(U(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.opk = eArr;
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
        E[] eArr = this.opk;
        long j = this.consumerIndex;
        long j2 = this.opj;
        E e = (E) b(eArr, Z(j, j2));
        if (e == nVh) {
            return b(U(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.opk = eArr;
        return (E) b(eArr, Z(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long dTi = dTi();
        while (true) {
            long dTh = dTh();
            long dTi2 = dTi();
            if (dTi == dTi2) {
                return (int) (dTh - dTi2);
            }
            dTi = dTi2;
        }
    }

    private void Ll(int i) {
        this.nVc = Math.min(i / 4, nVb);
    }

    private long dTh() {
        return ae.opn.e(this, oph);
    }

    private long dTi() {
        return ae.opn.e(this, opg);
    }

    private void soProducerIndex(long j) {
        ae.opn.a(this, oph, j);
    }

    private void soConsumerIndex(long j) {
        ae.opn.a(this, opg, j);
    }

    private static long Z(long j, long j2) {
        return gS(j & j2);
    }

    private static long gS(long j) {
        return opd + (j << ope);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.opn.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.opn.d(eArr, j);
    }
}
