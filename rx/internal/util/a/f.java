package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class f<E> extends g<E> {
    protected static final int opc = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long opd;
    private static final int ope;
    protected final E[] nYb;
    protected final long opf;

    static {
        int Q = ae.opn.Q(Object[].class);
        if (4 == Q) {
            ope = opc + 2;
        } else if (8 == Q) {
            ope = opc + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        opd = ae.opn.R(Object[].class) + (32 << (ope - opc));
    }

    public f(int i) {
        int Lo = h.Lo(i);
        this.opf = Lo - 1;
        this.nYb = (E[]) new Object[(Lo << opc) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long gO(long j) {
        return X(j, this.opf);
    }

    protected final long X(long j, long j2) {
        return opd + ((j & j2) << ope);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.opn.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.opn.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.opn.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E gP(long j) {
        return b(this.nYb, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.opn.d(eArr, j);
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
