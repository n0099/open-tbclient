package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes16.dex */
public abstract class f<E> extends g<E> {
    protected static final int qiY = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long qiZ;
    private static final int qja;
    protected final E[] pSe;
    protected final long qjb;

    static {
        int Q = ae.qjj.Q(Object[].class);
        if (4 == Q) {
            qja = qiY + 2;
        } else if (8 == Q) {
            qja = qiY + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qiZ = ae.qjj.R(Object[].class) + (32 << (qja - qiY));
    }

    public f(int i) {
        int Ro = h.Ro(i);
        this.qjb = Ro - 1;
        this.pSe = (E[]) new Object[(Ro << qiY) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long iv(long j) {
        return W(j, this.qjb);
    }

    protected final long W(long j, long j2) {
        return qiZ + ((j & j2) << qja);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.qjj.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.qjj.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.qjj.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E iw(long j) {
        return b(this.pSe, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.qjj.d(eArr, j);
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
