package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes15.dex */
public class y<E> extends aa<E> {
    static final int qja = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object qjg = new Object();
    private static final long qwf;
    private static final int qwg;
    private static final long qwi;
    private static final long qwj;

    static {
        int K = ae.qwp.K(Object[].class);
        if (4 == K) {
            qwg = 2;
        } else if (8 == K) {
            qwg = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qwf = ae.qwp.L(Object[].class);
        try {
            qwj = ae.qwp.c(ad.class.getDeclaredField("producerIndex"));
            try {
                qwi = ae.qwp.c(aa.class.getDeclaredField("consumerIndex"));
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
        int Tk = h.Tk(i);
        long j = Tk - 1;
        E[] eArr = (E[]) new Object[Tk + 1];
        this.qwo = eArr;
        this.qwn = j;
        Th(Tk);
        this.qwm = eArr;
        this.qwl = j;
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
        E[] eArr = this.qwo;
        long j = this.producerIndex;
        long j2 = this.qwn;
        long Y = Y(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, Y);
        }
        int i = this.qjb;
        if (b(eArr, Y(i + j, j2)) == null) {
            this.producerLookAhead = (i + j) - 1;
            return a(eArr, e, j, Y);
        } else if (b(eArr, Y(1 + j, j2)) != null) {
            return a(eArr, e, j, Y);
        } else {
            a(eArr, j, Y, e, j2);
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
        this.qwo = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, qjg);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, jz(eArr.length - 1), eArr2);
    }

    private E[] W(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, jz(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.qwm;
        long j = this.consumerIndex;
        long j2 = this.qwl;
        long Y = Y(j, j2);
        E e = (E) b(eArr, Y);
        boolean z = e == qjg;
        if (e != null && !z) {
            b(eArr, Y, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(W(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.qwm = eArr;
        long Y = Y(j, j2);
        E e = (E) b(eArr, Y);
        if (e == null) {
            return null;
        }
        b(eArr, Y, (Object) null);
        soConsumerIndex(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.qwm;
        long j = this.consumerIndex;
        long j2 = this.qwl;
        E e = (E) b(eArr, Y(j, j2));
        if (e == qjg) {
            return b(W(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.qwm = eArr;
        return (E) b(eArr, Y(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long eLr = eLr();
        while (true) {
            long eLq = eLq();
            long eLr2 = eLr();
            if (eLr == eLr2) {
                return (int) (eLq - eLr2);
            }
            eLr = eLr2;
        }
    }

    private void Th(int i) {
        this.qjb = Math.min(i / 4, qja);
    }

    private long eLq() {
        return ae.qwp.e(this, qwj);
    }

    private long eLr() {
        return ae.qwp.e(this, qwi);
    }

    private void soProducerIndex(long j) {
        ae.qwp.a(this, qwj, j);
    }

    private void soConsumerIndex(long j) {
        ae.qwp.a(this, qwi, j);
    }

    private static long Y(long j, long j2) {
        return jz(j & j2);
    }

    private static long jz(long j) {
        return qwf + (j << qwg);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.qwp.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.qwp.d(eArr, j);
    }
}
