package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    private static final int iMA;
    protected static final int iMy = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long iMz;
    protected final long iMB;
    protected final E[] ixX;

    static {
        int arrayIndexScale = ae.iMJ.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            iMA = iMy + 2;
        } else if (8 == arrayIndexScale) {
            iMA = iMy + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        iMz = ae.iMJ.arrayBaseOffset(Object[].class) + (32 << (iMA - iMy));
    }

    public f(int i) {
        int zt = h.zt(i);
        this.iMB = zt - 1;
        this.ixX = (E[]) new Object[(zt << iMy) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dQ(long j) {
        return t(j, this.iMB);
    }

    protected final long t(long j, long j2) {
        return iMz + ((j & j2) << iMA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.iMJ.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.iMJ.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.iMJ.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E dR(long j) {
        return b(this.ixX, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.iMJ.getObjectVolatile(eArr, j);
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
