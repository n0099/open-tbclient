package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class f<E> extends g<E> {
    protected static final int nRS = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long nRT;
    private static final int nRU;
    protected final E[] nBk;
    protected final long nRV;

    static {
        int R = ae.nSd.R(Object[].class);
        if (4 == R) {
            nRU = nRS + 2;
        } else if (8 == R) {
            nRU = nRS + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nRT = ae.nSd.S(Object[].class) + (32 << (nRU - nRS));
    }

    public f(int i) {
        int Nx = h.Nx(i);
        this.nRV = Nx - 1;
        this.nBk = (E[]) new Object[(Nx << nRS) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long hv(long j) {
        return al(j, this.nRV);
    }

    protected final long al(long j, long j2) {
        return nRT + ((j & j2) << nRU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.nSd.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.nSd.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.nSd.b(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E hw(long j) {
        return b(this.nBk, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.nSd.c(eArr, j);
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
