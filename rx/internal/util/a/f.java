package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class f<E> extends g<E> {
    protected static final int qDo = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long qDp;
    private static final int qDq;
    protected final long qDr;
    protected final E[] qsZ;

    static {
        int K = ae.qDz.K(Object[].class);
        if (4 == K) {
            qDq = qDo + 2;
        } else if (8 == K) {
            qDq = qDo + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qDp = ae.qDz.L(Object[].class) + (32 << (qDq - qDo));
    }

    public f(int i) {
        int So = h.So(i);
        this.qDr = So - 1;
        this.qsZ = (E[]) new Object[(So << qDo) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long jB(long j) {
        return ab(j, this.qDr);
    }

    protected final long ab(long j, long j2) {
        return qDp + ((j & j2) << qDq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.qDz.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.qDz.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.qDz.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E jC(long j) {
        return b(this.qsZ, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.qDz.d(eArr, j);
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
