package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes14.dex */
public abstract class f<E> extends g<E> {
    protected static final int qtk = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long qtl;
    private static final int qtm;
    protected final E[] qiU;
    protected final long qtn;

    static {
        int K = ae.qtv.K(Object[].class);
        if (4 == K) {
            qtm = qtk + 2;
        } else if (8 == K) {
            qtm = qtk + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qtl = ae.qtv.L(Object[].class) + (32 << (qtm - qtk));
    }

    public f(int i) {
        int RT = h.RT(i);
        this.qtn = RT - 1;
        this.qiU = (E[]) new Object[(RT << qtk) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long jy(long j) {
        return X(j, this.qtn);
    }

    protected final long X(long j, long j2) {
        return qtl + ((j & j2) << qtm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.qtv.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.qtv.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.qtv.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E jz(long j) {
        return b(this.qiU, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.qtv.d(eArr, j);
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
