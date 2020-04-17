package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class f<E> extends g<E> {
    protected static final int noo = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long nop;
    private static final int noq;
    protected final E[] mXl;
    protected final long nor;

    static {
        int Q = ae.noB.Q(Object[].class);
        if (4 == Q) {
            noq = noo + 2;
        } else if (8 == Q) {
            noq = noo + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nop = ae.noB.R(Object[].class) + (32 << (noq - noo));
    }

    public f(int i) {
        int Ja = h.Ja(i);
        this.nor = Ja - 1;
        this.mXl = (E[]) new Object[(Ja << noo) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long gv(long j) {
        return T(j, this.nor);
    }

    protected final long T(long j, long j2) {
        return nop + ((j & j2) << noq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.noB.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.noB.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.noB.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E gw(long j) {
        return b(this.mXl, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.noB.d(eArr, j);
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
