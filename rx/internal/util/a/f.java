package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class f<E> extends g<E> {
    protected static final int nor = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long nos;
    private static final int nou;
    protected final E[] mXo;
    protected final long nov;

    static {
        int Q = ae.noE.Q(Object[].class);
        if (4 == Q) {
            nou = nor + 2;
        } else if (8 == Q) {
            nou = nor + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nos = ae.noE.R(Object[].class) + (32 << (nou - nor));
    }

    public f(int i) {
        int Ja = h.Ja(i);
        this.nov = Ja - 1;
        this.mXo = (E[]) new Object[(Ja << nor) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long gv(long j) {
        return T(j, this.nov);
    }

    protected final long T(long j, long j2) {
        return nos + ((j & j2) << nou);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.noE.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.noE.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.noE.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E gw(long j) {
        return b(this.mXo, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.noE.d(eArr, j);
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
