package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class f<E> extends g<E> {
    protected static final int nJr = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long nJs;
    private static final int nJt;
    protected final long nJu;
    protected final E[] nsq;

    static {
        int Q = ae.nJC.Q(Object[].class);
        if (4 == Q) {
            nJt = nJr + 2;
        } else if (8 == Q) {
            nJt = nJr + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nJs = ae.nJC.R(Object[].class) + (32 << (nJt - nJr));
    }

    public f(int i) {
        int JL = h.JL(i);
        this.nJu = JL - 1;
        this.nsq = (E[]) new Object[(JL << nJr) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long gw(long j) {
        return U(j, this.nJu);
    }

    protected final long U(long j, long j2) {
        return nJs + ((j & j2) << nJt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.nJC.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.nJC.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.nJC.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E gx(long j) {
        return b(this.nsq, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.nJC.d(eArr, j);
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
