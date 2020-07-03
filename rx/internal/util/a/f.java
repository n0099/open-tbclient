package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class f<E> extends g<E> {
    protected static final int ogp = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long ogq;
    private static final int ogr;
    protected final E[] nPn;
    protected final long ogs;

    static {
        int Q = ae.ogA.Q(Object[].class);
        if (4 == Q) {
            ogr = ogp + 2;
        } else if (8 == Q) {
            ogr = ogp + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        ogq = ae.ogA.R(Object[].class) + (32 << (ogr - ogp));
    }

    public f(int i) {
        int KU = h.KU(i);
        this.ogs = KU - 1;
        this.nPn = (E[]) new Object[(KU << ogp) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long gB(long j) {
        return V(j, this.ogs);
    }

    protected final long V(long j, long j2) {
        return ogq + ((j & j2) << ogr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.ogA.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.ogA.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.ogA.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E gC(long j) {
        return b(this.nPn, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.ogA.d(eArr, j);
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
