package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class f<E> extends g<E> {
    protected static final int nRN = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long nRO;
    private static final int nRP;
    protected final E[] nBf;
    protected final long nRQ;

    static {
        int R = ae.nRY.R(Object[].class);
        if (4 == R) {
            nRP = nRN + 2;
        } else if (8 == R) {
            nRP = nRN + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nRO = ae.nRY.S(Object[].class) + (32 << (nRP - nRN));
    }

    public f(int i) {
        int Nx = h.Nx(i);
        this.nRQ = Nx - 1;
        this.nBf = (E[]) new Object[(Nx << nRN) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long hv(long j) {
        return al(j, this.nRQ);
    }

    protected final long al(long j, long j2) {
        return nRO + ((j & j2) << nRP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.nRY.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.nRY.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.nRY.b(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E hw(long j) {
        return b(this.nBf, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.nRY.c(eArr, j);
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
