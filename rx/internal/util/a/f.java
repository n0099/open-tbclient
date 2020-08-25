package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes5.dex */
public abstract class f<E> extends g<E> {
    protected static final int oIX = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long oIY;
    private static final int oIZ;
    protected final long oJa;
    protected final E[] orZ;

    static {
        int Q = ae.oJi.Q(Object[].class);
        if (4 == Q) {
            oIZ = oIX + 2;
        } else if (8 == Q) {
            oIZ = oIX + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        oIY = ae.oJi.R(Object[].class) + (32 << (oIZ - oIX));
    }

    public f(int i) {
        int NR = h.NR(i);
        this.oJa = NR - 1;
        this.orZ = (E[]) new Object[(NR << oIX) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long hb(long j) {
        return X(j, this.oJa);
    }

    protected final long X(long j, long j2) {
        return oIY + ((j & j2) << oIZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.oJi.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.oJi.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.oJi.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E hc(long j) {
        return b(this.orZ, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.oJi.d(eArr, j);
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
