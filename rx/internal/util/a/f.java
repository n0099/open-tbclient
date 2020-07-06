package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class f<E> extends g<E> {
    protected static final int ogs = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long ogt;
    private static final int ogu;
    protected final E[] nPq;
    protected final long ogv;

    static {
        int Q = ae.ogD.Q(Object[].class);
        if (4 == Q) {
            ogu = ogs + 2;
        } else if (8 == Q) {
            ogu = ogs + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        ogt = ae.ogD.R(Object[].class) + (32 << (ogu - ogs));
    }

    public f(int i) {
        int KU = h.KU(i);
        this.ogv = KU - 1;
        this.nPq = (E[]) new Object[(KU << ogs) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long gB(long j) {
        return V(j, this.ogv);
    }

    protected final long V(long j, long j2) {
        return ogt + ((j & j2) << ogu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.ogD.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.ogD.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.ogD.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E gC(long j) {
        return b(this.nPq, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.ogD.d(eArr, j);
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
