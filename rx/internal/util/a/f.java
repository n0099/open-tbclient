package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int iQP = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long iQQ;
    private static final int iQR;
    protected final E[] iCo;
    protected final long iQS;

    static {
        int arrayIndexScale = ae.iRa.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            iQR = iQP + 2;
        } else if (8 == arrayIndexScale) {
            iQR = iQP + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        iQQ = ae.iRa.arrayBaseOffset(Object[].class) + (32 << (iQR - iQP));
    }

    public f(int i) {
        int zI = h.zI(i);
        this.iQS = zI - 1;
        this.iCo = (E[]) new Object[(zI << iQP) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dV(long j) {
        return t(j, this.iQS);
    }

    protected final long t(long j, long j2) {
        return iQQ + ((j & j2) << iQR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.iRa.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.iRa.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.iRa.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E dW(long j) {
        return b(this.iCo, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.iRa.getObjectVolatile(eArr, j);
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
