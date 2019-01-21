package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int iQQ = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long iQR;
    private static final int iQS;
    protected final E[] iCp;
    protected final long iQT;

    static {
        int arrayIndexScale = ae.iRb.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            iQS = iQQ + 2;
        } else if (8 == arrayIndexScale) {
            iQS = iQQ + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        iQR = ae.iRb.arrayBaseOffset(Object[].class) + (32 << (iQS - iQQ));
    }

    public f(int i) {
        int zI = h.zI(i);
        this.iQT = zI - 1;
        this.iCp = (E[]) new Object[(zI << iQQ) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dV(long j) {
        return t(j, this.iQT);
    }

    protected final long t(long j, long j2) {
        return iQR + ((j & j2) << iQS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.iRb.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.iRb.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.iRb.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E dW(long j) {
        return b(this.iCp, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.iRb.getObjectVolatile(eArr, j);
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
