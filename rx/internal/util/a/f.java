package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class f<E> extends g<E> {
    protected static final int nKB = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long nKC;
    private static final int nKD;
    protected final long nKE;
    protected final E[] ntA;

    static {
        int Q = ae.nKM.Q(Object[].class);
        if (4 == Q) {
            nKD = nKB + 2;
        } else if (8 == Q) {
            nKD = nKB + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        nKC = ae.nKM.R(Object[].class) + (32 << (nKD - nKB));
    }

    public f(int i) {
        int JN = h.JN(i);
        this.nKE = JN - 1;
        this.ntA = (E[]) new Object[(JN << nKB) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long gw(long j) {
        return U(j, this.nKE);
    }

    protected final long U(long j, long j2) {
        return nKC + ((j & j2) << nKD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.nKM.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.nKM.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.nKM.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E gx(long j) {
        return b(this.ntA, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.nKM.d(eArr, j);
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
