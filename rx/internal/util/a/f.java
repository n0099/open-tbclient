package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class f<E> extends g<E> {
    protected static final int nSI = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long nSJ;
    private static final int nSK;
    protected final E[] nBO;
    protected final long nSL;

    static {
        int Q = ae.nST.Q(Object[].class);
        if (4 == Q) {
            nSK = nSI + 2;
        } else if (8 == Q) {
            nSK = nSI + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nSJ = ae.nST.R(Object[].class) + (32 << (nSK - nSI));
    }

    public f(int i) {
        int NA = h.NA(i);
        this.nSL = NA - 1;
        this.nBO = (E[]) new Object[(NA << nSI) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long ht(long j) {
        return al(j, this.nSL);
    }

    protected final long al(long j, long j2) {
        return nSJ + ((j & j2) << nSK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.nST.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.nST.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.nST.b(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E hu(long j) {
        return b(this.nBO, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.nST.c(eArr, j);
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
