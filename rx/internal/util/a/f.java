package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int iDH = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long iDI;
    private static final int iDJ;
    protected final long iDK;
    protected final E[] ipd;

    static {
        int arrayIndexScale = ae.iDS.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            iDJ = iDH + 2;
        } else if (8 == arrayIndexScale) {
            iDJ = iDH + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        iDI = ae.iDS.arrayBaseOffset(Object[].class) + (32 << (iDJ - iDH));
    }

    public f(int i) {
        int yE = h.yE(i);
        this.iDK = yE - 1;
        this.ipd = (E[]) new Object[(yE << iDH) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dO(long j) {
        return u(j, this.iDK);
    }

    protected final long u(long j, long j2) {
        return iDI + ((j & j2) << iDJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.iDS.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.iDS.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.iDS.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E dP(long j) {
        return b(this.ipd, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.iDS.getObjectVolatile(eArr, j);
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
