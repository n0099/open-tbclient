package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes14.dex */
public abstract class f<E> extends g<E> {
    protected static final int qkB = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long qkC;
    private static final int qkD;
    protected final E[] pTH;
    protected final long qkE;

    static {
        int Q = ae.qkM.Q(Object[].class);
        if (4 == Q) {
            qkD = qkB + 2;
        } else if (8 == Q) {
            qkD = qkB + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qkC = ae.qkM.R(Object[].class) + (32 << (qkD - qkB));
    }

    public f(int i) {
        int RR = h.RR(i);
        this.qkE = RR - 1;
        this.pTH = (E[]) new Object[(RR << qkB) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long iy(long j) {
        return W(j, this.qkE);
    }

    protected final long W(long j, long j2) {
        return qkC + ((j & j2) << qkD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.qkM.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.qkM.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.qkM.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E iz(long j) {
        return b(this.pTH, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.qkM.d(eArr, j);
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
