package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes12.dex */
public abstract class f<E> extends g<E> {
    protected static final int pUE = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long pUF;
    private static final int pUG;
    protected final E[] pKl;
    protected final long pUH;

    static {
        int Q = ae.pUP.Q(Object[].class);
        if (4 == Q) {
            pUG = pUE + 2;
        } else if (8 == Q) {
            pUG = pUE + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        pUF = ae.pUP.R(Object[].class) + (32 << (pUG - pUE));
    }

    public f(int i) {
        int RR = h.RR(i);
        this.pUH = RR - 1;
        this.pKl = (E[]) new Object[(RR << pUE) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long iL(long j) {
        return R(j, this.pUH);
    }

    protected final long R(long j, long j2) {
        return pUF + ((j & j2) << pUG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.pUP.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.pUP.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.pUP.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E iM(long j) {
        return b(this.pKl, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.pUP.d(eArr, j);
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
