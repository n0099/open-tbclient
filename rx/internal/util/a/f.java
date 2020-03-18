package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class f<E> extends g<E> {
    protected static final int nUG = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long nUH;
    private static final int nUI;
    protected final E[] nDM;
    protected final long nUJ;

    static {
        int Q = ae.nUR.Q(Object[].class);
        if (4 == Q) {
            nUI = nUG + 2;
        } else if (8 == Q) {
            nUI = nUG + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nUH = ae.nUR.R(Object[].class) + (32 << (nUI - nUG));
    }

    public f(int i) {
        int NG = h.NG(i);
        this.nUJ = NG - 1;
        this.nDM = (E[]) new Object[(NG << nUG) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long hu(long j) {
        return al(j, this.nUJ);
    }

    protected final long al(long j, long j2) {
        return nUH + ((j & j2) << nUI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.nUR.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.nUR.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.nUR.b(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E hv(long j) {
        return b(this.nDM, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.nUR.c(eArr, j);
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
