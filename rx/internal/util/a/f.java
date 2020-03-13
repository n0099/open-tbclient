package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class f<E> extends g<E> {
    protected static final int nST = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long nSU;
    private static final int nSV;
    protected final E[] nBZ;
    protected final long nSW;

    static {
        int Q = ae.nTe.Q(Object[].class);
        if (4 == Q) {
            nSV = nST + 2;
        } else if (8 == Q) {
            nSV = nST + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nSU = ae.nTe.R(Object[].class) + (32 << (nSV - nST));
    }

    public f(int i) {
        int NA = h.NA(i);
        this.nSW = NA - 1;
        this.nBZ = (E[]) new Object[(NA << nST) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long ht(long j) {
        return al(j, this.nSW);
    }

    protected final long al(long j, long j2) {
        return nSU + ((j & j2) << nSV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.nTe.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.nTe.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.nTe.b(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E hu(long j) {
        return b(this.nBZ, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.nTe.c(eArr, j);
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
