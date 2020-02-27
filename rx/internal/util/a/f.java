package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class f<E> extends g<E> {
    protected static final int nSG = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long nSH;
    private static final int nSI;
    protected final E[] nBM;
    protected final long nSJ;

    static {
        int Q = ae.nSR.Q(Object[].class);
        if (4 == Q) {
            nSI = nSG + 2;
        } else if (8 == Q) {
            nSI = nSG + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nSH = ae.nSR.R(Object[].class) + (32 << (nSI - nSG));
    }

    public f(int i) {
        int NA = h.NA(i);
        this.nSJ = NA - 1;
        this.nBM = (E[]) new Object[(NA << nSG) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long ht(long j) {
        return al(j, this.nSJ);
    }

    protected final long al(long j, long j2) {
        return nSH + ((j & j2) << nSI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.nSR.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.nSR.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.nSR.b(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E hu(long j) {
        return b(this.nBM, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.nSR.c(eArr, j);
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
