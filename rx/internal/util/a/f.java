package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class f<E> extends g<E> {
    protected static final int qDO = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long qDP;
    private static final int qDQ;
    protected final long qDR;
    protected final E[] qtz;

    static {
        int K = ae.qDZ.K(Object[].class);
        if (4 == K) {
            qDQ = qDO + 2;
        } else if (8 == K) {
            qDQ = qDO + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qDP = ae.qDZ.L(Object[].class) + (32 << (qDQ - qDO));
    }

    public f(int i) {
        int Sp = h.Sp(i);
        this.qDR = Sp - 1;
        this.qtz = (E[]) new Object[(Sp << qDO) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long jB(long j) {
        return ab(j, this.qDR);
    }

    protected final long ab(long j, long j2) {
        return qDP + ((j & j2) << qDQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.qDZ.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.qDZ.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.qDZ.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E jC(long j) {
        return b(this.qtz, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.qDZ.d(eArr, j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }
}
