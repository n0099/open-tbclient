package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public class y<E> extends aa<E> {
    static final int mUl = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object mUr = new Object();
    private static final long nop;
    private static final int noq;
    private static final long nos;
    private static final long nou;

    static {
        int Q = ae.noB.Q(Object[].class);
        if (4 == Q) {
            noq = 2;
        } else if (8 == Q) {
            noq = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nop = ae.noB.R(Object[].class);
        try {
            nou = ae.noB.b(ad.class.getDeclaredField("producerIndex"));
            try {
                nos = ae.noB.b(aa.class.getDeclaredField("consumerIndex"));
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
        int Ja = h.Ja(i);
        long j = Ja - 1;
        E[] eArr = (E[]) new Object[Ja + 1];
        this.noA = eArr;
        this.noz = j;
        IX(Ja);
        this.noy = eArr;
        this.nox = j;
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
        E[] eArr = this.noA;
        long j = this.producerIndex;
        long j2 = this.noz;
        long V = V(j, j2);
        if (j < this.producerLookAhead) {
            return a(eArr, e, j, V);
        }
        int i = this.mUm;
        if (b(eArr, V(i + j, j2)) == null) {
            this.producerLookAhead = (i + j) - 1;
            return a(eArr, e, j, V);
        } else if (b(eArr, V(1 + j, j2)) != null) {
            return a(eArr, e, j, V);
        } else {
            a(eArr, j, V, e, j2);
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
        this.noA = eArr2;
        this.producerLookAhead = (j + j3) - 1;
        b(eArr2, j2, e);
        b(eArr, eArr2);
        b(eArr, j2, mUr);
        soProducerIndex(j + 1);
    }

    private void b(E[] eArr, E[] eArr2) {
        b(eArr, gz(eArr.length - 1), eArr2);
    }

    private E[] T(E[] eArr) {
        return (E[]) ((Object[]) b(eArr, gz(eArr.length - 1)));
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.noy;
        long j = this.consumerIndex;
        long j2 = this.nox;
        long V = V(j, j2);
        E e = (E) b(eArr, V);
        boolean z = e == mUr;
        if (e != null && !z) {
            b(eArr, V, (Object) null);
            soConsumerIndex(j + 1);
            return e;
        } else if (z) {
            return a(T(eArr), j, j2);
        } else {
            return null;
        }
    }

    private E a(E[] eArr, long j, long j2) {
        this.noy = eArr;
        long V = V(j, j2);
        E e = (E) b(eArr, V);
        if (e == null) {
            return null;
        }
        b(eArr, V, (Object) null);
        soConsumerIndex(1 + j);
        return e;
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.noy;
        long j = this.consumerIndex;
        long j2 = this.nox;
        E e = (E) b(eArr, V(j, j2));
        if (e == mUr) {
            return b(T(eArr), j, j2);
        }
        return e;
    }

    private E b(E[] eArr, long j, long j2) {
        this.noy = eArr;
        return (E) b(eArr, V(j, j2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long dCW = dCW();
        while (true) {
            long dCV = dCV();
            long dCW2 = dCW();
            if (dCW == dCW2) {
                return (int) (dCV - dCW2);
            }
            dCW = dCW2;
        }
    }

    private void IX(int i) {
        this.mUm = Math.min(i / 4, mUl);
    }

    private long dCV() {
        return ae.noB.e(this, nou);
    }

    private long dCW() {
        return ae.noB.e(this, nos);
    }

    private void soProducerIndex(long j) {
        ae.noB.a(this, nou, j);
    }

    private void soConsumerIndex(long j) {
        ae.noB.a(this, nos, j);
    }

    private static long V(long j, long j2) {
        return gz(j & j2);
    }

    private static long gz(long j) {
        return nop + (j << noq);
    }

    private static void b(Object[] objArr, long j, Object obj) {
        ae.noB.b(objArr, j, obj);
    }

    private static <E> Object b(E[] eArr, long j) {
        return ae.noB.d(eArr, j);
    }
}
