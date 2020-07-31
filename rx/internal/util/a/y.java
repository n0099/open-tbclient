package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public class y<E> extends aa<E> {
    static final int nUZ = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nVf = new Object();
    private static final long opb;
    private static final int opc;
    private static final long ope;
    private static final long opf;

    static {
        int Q = ae.opl.Q(Object[].class);
        if (4 == Q) {
            opc = 2;
        } else if (8 == Q) {
            opc = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        opb = ae.opl.R(Object[].class);
        try {
            opf = ae.opl.b(ad.class.getDeclaredField("producerIndex"));
            try {
                ope = ae.opl.b(aa.class.getDeclaredField("consumerIndex"));
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
        this.opk = eArr;
        this.opj = j;
        Ll(Lo);
        this.opi = eArr;
        this.oph = j;
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
        E[] eArr = this.opk;
        long j = this.producerIndex;
        long j2 = this.opj;
        long Z = Z(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, Z);
        }
        int i = this.nVa;
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
        this.opk = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, nVf);
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
        E[] eArr = this.opi;
        long j = this.consumerIndex;
        long j2 = this.oph;
        long Z = Z(j, j2);
        E e = (E) b(eArr, Z);
        boolean z = e == nVf;
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
        this.opi = eArr;
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
        E[] eArr = this.opi;
        long j = this.consumerIndex;
        long j2 = this.oph;
        E e = (E) b(eArr, Z(j, j2));
        if (e == nVf) {
            return b(U(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.opi = eArr;
        return (E) b(eArr, Z(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long dTh = dTh();
        while (true) {
            long dTg = dTg();
            long dTh2 = dTh();
            if (dTh == dTh2) {
                return (int) (dTg - dTh2);
            }
            dTh = dTh2;
        }
    }

    private void Ll(int i) {
        this.nVa = Math.min(i / 4, nUZ);
    }

    private long dTg() {
        return ae.opl.e(this, opf);
    }

    private long dTh() {
        return ae.opl.e(this, ope);
    }

    private void soProducerIndex(long j) {
        ae.opl.a(this, opf, j);
    }

    private void soConsumerIndex(long j) {
        ae.opl.a(this, ope, j);
    }

    private static long Z(long j, long j2) {
        return gS(j & j2);
    }

    private static long gS(long j) {
        return opb + (j << opc);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.opl.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.opl.d(eArr, j);
    }
}
