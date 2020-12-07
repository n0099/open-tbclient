package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes12.dex */
public abstract class f<E> extends g<E> {
    protected static final int pUC = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long pUD;
    private static final int pUE;
    protected final E[] pKj;
    protected final long pUF;

    static {
        int Q = ae.pUN.Q(Object[].class);
        if (4 == Q) {
            pUE = pUC + 2;
        } else if (8 == Q) {
            pUE = pUC + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        pUD = ae.pUN.R(Object[].class) + (32 << (pUE - pUC));
    }

    public f(int i) {
        int RR = h.RR(i);
        this.pUF = RR - 1;
        this.pKj = (E[]) new Object[(RR << pUC) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long iL(long j) {
        return R(j, this.pUF);
    }

    protected final long R(long j, long j2) {
        return pUD + ((j & j2) << pUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.pUN.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.pUN.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.pUN.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E iM(long j) {
        return b(this.pKj, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.pUN.d(eArr, j);
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
