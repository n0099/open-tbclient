package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes16.dex */
public abstract class f<E> extends g<E> {
    protected static final int pim = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long pio;
    private static final int pip;
    protected final E[] oRn;
    protected final long piq;

    static {
        int Q = ae.piy.Q(Object[].class);
        if (4 == Q) {
            pip = pim + 2;
        } else if (8 == Q) {
            pip = pim + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        pio = ae.piy.R(Object[].class) + (32 << (pip - pim));
    }

    public f(int i) {
        int Pc = h.Pc(i);
        this.piq = Pc - 1;
        this.oRn = (E[]) new Object[(Pc << pim) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long hJ(long j) {
        return U(j, this.piq);
    }

    protected final long U(long j, long j2) {
        return pio + ((j & j2) << pip);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.piy.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.piy.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.piy.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E hK(long j) {
        return b(this.oRn, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.piy.d(eArr, j);
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
