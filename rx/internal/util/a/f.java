package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes16.dex */
public abstract class f<E> extends g<E> {
    protected static final int pZD = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long pZE;
    private static final int pZF;
    protected final E[] pIK;
    protected final long pZG;

    static {
        int Q = ae.pZO.Q(Object[].class);
        if (4 == Q) {
            pZF = pZD + 2;
        } else if (8 == Q) {
            pZF = pZD + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        pZE = ae.pZO.R(Object[].class) + (32 << (pZF - pZD));
    }

    public f(int i) {
        int QT = h.QT(i);
        this.pZG = QT - 1;
        this.pIK = (E[]) new Object[(QT << pZD) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long hZ(long j) {
        return V(j, this.pZG);
    }

    protected final long V(long j, long j2) {
        return pZE + ((j & j2) << pZF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.pZO.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.pZO.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.pZO.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E ia(long j) {
        return b(this.pIK, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.pZO.d(eArr, j);
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
