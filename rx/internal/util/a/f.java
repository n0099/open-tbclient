package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class f<E> extends g<E> {
    protected static final int opa = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long opb;
    private static final int opc;
    protected final E[] nXZ;
    protected final long opd;

    static {
        int Q = ae.opl.Q(Object[].class);
        if (4 == Q) {
            opc = opa + 2;
        } else if (8 == Q) {
            opc = opa + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        opb = ae.opl.R(Object[].class) + (32 << (opc - opa));
    }

    public f(int i) {
        int Lo = h.Lo(i);
        this.opd = Lo - 1;
        this.nXZ = (E[]) new Object[(Lo << opa) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long gO(long j) {
        return X(j, this.opd);
    }

    protected final long X(long j, long j2) {
        return opb + ((j & j2) << opc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.opl.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.opl.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.opl.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E gP(long j) {
        return b(this.nXZ, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.opl.d(eArr, j);
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
