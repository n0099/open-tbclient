package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes4.dex */
public abstract class f<E> extends g<E> {
    protected static final int qEq = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long qEr;
    private static final int qEs;
    protected final long qEt;
    protected final E[] qub;

    static {
        int K = ae.qEB.K(Object[].class);
        if (4 == K) {
            qEs = qEq + 2;
        } else if (8 == K) {
            qEs = qEq + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qEr = ae.qEB.L(Object[].class) + (32 << (qEs - qEq));
    }

    public f(int i) {
        int So = h.So(i);
        this.qEt = So - 1;
        this.qub = (E[]) new Object[(So << qEq) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long jA(long j) {
        return ab(j, this.qEt);
    }

    protected final long ab(long j, long j2) {
        return qEr + ((j & j2) << qEs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.qEB.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.qEB.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.qEB.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E jB(long j) {
        return b(this.qub, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.qEB.d(eArr, j);
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
