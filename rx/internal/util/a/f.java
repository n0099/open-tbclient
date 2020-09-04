package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class f<E> extends g<E> {
    protected static final int oJp = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long oJq;
    private static final int oJr;
    protected final long oJs;
    protected final E[] osr;

    static {
        int Q = ae.oJA.Q(Object[].class);
        if (4 == Q) {
            oJr = oJp + 2;
        } else if (8 == Q) {
            oJr = oJp + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        oJq = ae.oJA.R(Object[].class) + (32 << (oJr - oJp));
    }

    public f(int i) {
        int NR = h.NR(i);
        this.oJs = NR - 1;
        this.osr = (E[]) new Object[(NR << oJp) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long hd(long j) {
        return X(j, this.oJs);
    }

    protected final long X(long j, long j2) {
        return oJq + ((j & j2) << oJr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.oJA.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.oJA.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.oJA.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E he(long j) {
        return b(this.osr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.oJA.d(eArr, j);
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
