package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes4.dex */
public abstract class f<E> extends g<E> {
    protected static final int niQ = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long niR;
    private static final int niS;
    protected final E[] mYL;
    protected final long niT;

    static {
        int Q = ae.njb.Q(Object[].class);
        if (4 == Q) {
            niS = niQ + 2;
        } else if (8 == Q) {
            niS = niQ + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        niR = ae.njb.R(Object[].class) + (32 << (niS - niQ));
    }

    public f(int i) {
        int MK = h.MK(i);
        this.niT = MK - 1;
        this.mYL = (E[]) new Object[(MK << niQ) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long gX(long j) {
        return ag(j, this.niT);
    }

    protected final long ag(long j, long j2) {
        return niR + ((j & j2) << niS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.njb.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.njb.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.njb.b(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E gY(long j) {
        return b(this.mYL, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.njb.c(eArr, j);
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
