package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public class y<E> extends aa<E> {
    static final int nAJ = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object nAP = new Object();
    private static final long nUH;
    private static final int nUI;
    private static final long nUK;
    private static final long nUL;

    static {
        int Q = ae.nUR.Q(Object[].class);
        if (4 == Q) {
            nUI = 2;
        } else if (8 == Q) {
            nUI = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nUH = ae.nUR.R(Object[].class);
        try {
            nUL = ae.nUR.b(ad.class.getDeclaredField("producerIndex"));
            try {
                nUK = ae.nUR.b(aa.class.getDeclaredField("consumerIndex"));
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
        int NG = h.NG(i);
        long j = NG - 1;
        E[] eArr = (E[]) new Object[NG + 1];
        this.nUQ = eArr;
        this.nUP = j;
        ND(NG);
        this.nUO = eArr;
        this.nUN = j;
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
        E[] eArr = this.nUQ;
        long j = this.producerIndex;
        long j2 = this.nUP;
        long an = an(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, an);
        }
        int i = this.nAK;
        if (b(eArr, an(i + j, j2)) == null) {
            this.producerLookAhead = (i + j) - 1;
            return a(eArr, e, j, an);
        } else if (b(eArr, an(1 + j, j2)) != null) {
            return a(eArr, e, j, an);
        } else {
            a(eArr, j, an, e, j2);
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
        this.nUQ = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, nAP);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, hy(eArr.length - 1), eArr2);
    }

    private E[] S(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, hy(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.nUO;
        long j = this.consumerIndex;
        long j2 = this.nUN;
        long an = an(j, j2);
        E e = (E) b(eArr, an);
        boolean z = e == nAP;
        if (e != null && !z) {
            b(eArr, an, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(S(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.nUO = eArr;
        long an = an(j, j2);
        E e = (E) b(eArr, an);
        if (e == null) {
            return null;
        }
        b(eArr, an, (Object) null);
        soConsumerIndex(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.nUO;
        long j = this.consumerIndex;
        long j2 = this.nUN;
        E e = (E) b(eArr, an(j, j2));
        if (e == nAP) {
            return b(S(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.nUO = eArr;
        return (E) b(eArr, an(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long dJX = dJX();
        while (true) {
            long dJW = dJW();
            long dJX2 = dJX();
            if (dJX == dJX2) {
                return (int) (dJW - dJX2);
            }
            dJX = dJX2;
        }
    }

    private void ND(int i) {
        this.nAK = Math.min(i / 4, nAJ);
    }

    private long dJW() {
        return ae.nUR.d(this, nUL);
    }

    private long dJX() {
        return ae.nUR.d(this, nUK);
    }

    private void soProducerIndex(long j) {
        ae.nUR.a(this, nUL, j);
    }

    private void soConsumerIndex(long j) {
        ae.nUR.a(this, nUK, j);
    }

    private static long an(long j, long j2) {
        return hy(j & j2);
    }

    private static long hy(long j) {
        return nUH + (j << nUI);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.nUR.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.nUR.c(eArr, j);
    }
}
