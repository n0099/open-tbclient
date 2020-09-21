package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class f<E> extends g<E> {
    protected static final int oSU = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long oSV;
    private static final int oSW;
    protected final E[] oBY;
    protected final long oSX;

    static {
        int Q = ae.oTf.Q(Object[].class);
        if (4 == Q) {
            oSW = oSU + 2;
        } else if (8 == Q) {
            oSW = oSU + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        oSV = ae.oTf.R(Object[].class) + (32 << (oSW - oSU));
    }

    public f(int i) {
        int Ow = h.Ow(i);
        this.oSX = Ow - 1;
        this.oBY = (E[]) new Object[(Ow << oSU) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long hr(long j) {
        return U(j, this.oSX);
    }

    protected final long U(long j, long j2) {
        return oSV + ((j & j2) << oSW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.oTf.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.oTf.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.oTf.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E hs(long j) {
        return b(this.oBY, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.oTf.d(eArr, j);
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
