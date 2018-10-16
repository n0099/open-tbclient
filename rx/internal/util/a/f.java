package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int iDG = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long iDH;
    private static final int iDI;
    protected final long iDJ;
    protected final E[] ipc;

    static {
        int arrayIndexScale = ae.iDR.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            iDI = iDG + 2;
        } else if (8 == arrayIndexScale) {
            iDI = iDG + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        iDH = ae.iDR.arrayBaseOffset(Object[].class) + (32 << (iDI - iDG));
    }

    public f(int i) {
        int yE = h.yE(i);
        this.iDJ = yE - 1;
        this.ipc = (E[]) new Object[(yE << iDG) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dO(long j) {
        return u(j, this.iDJ);
    }

    protected final long u(long j, long j2) {
        return iDH + ((j & j2) << iDI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.iDR.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.iDR.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.iDR.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E dP(long j) {
        return b(this.ipc, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.iDR.getObjectVolatile(eArr, j);
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
