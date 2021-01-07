package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes15.dex */
public abstract class f<E> extends g<E> {
    protected static final int qxM = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long qxN;
    private static final int qxO;
    protected final E[] qnw;
    protected final long qxP;

    static {
        int K = ae.qxX.K(Object[].class);
        if (4 == K) {
            qxO = qxM + 2;
        } else if (8 == K) {
            qxO = qxM + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qxN = ae.qxX.L(Object[].class) + (32 << (qxO - qxM));
    }

    public f(int i) {
        int TA = h.TA(i);
        this.qxP = TA - 1;
        this.qnw = (E[]) new Object[(TA << qxM) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long jy(long j) {
        return X(j, this.qxP);
    }

    protected final long X(long j, long j2) {
        return qxN + ((j & j2) << qxO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.qxX.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.qxX.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.qxX.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E jz(long j) {
        return b(this.qnw, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.qxX.d(eArr, j);
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
