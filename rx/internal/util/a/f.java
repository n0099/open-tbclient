package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes14.dex */
public abstract class f<E> extends g<E> {
    protected static final int qtl = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long qtm;
    private static final int qtn;
    protected final E[] qiV;
    protected final long qto;

    static {
        int K = ae.qtw.K(Object[].class);
        if (4 == K) {
            qtn = qtl + 2;
        } else if (8 == K) {
            qtn = qtl + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qtm = ae.qtw.L(Object[].class) + (32 << (qtn - qtl));
    }

    public f(int i) {
        int RT = h.RT(i);
        this.qto = RT - 1;
        this.qiV = (E[]) new Object[(RT << qtl) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long jy(long j) {
        return X(j, this.qto);
    }

    protected final long X(long j, long j2) {
        return qtm + ((j & j2) << qtn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.qtw.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.qtw.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.qtw.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E jz(long j) {
        return b(this.qiV, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.qtw.d(eArr, j);
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
