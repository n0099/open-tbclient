package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int iFr = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long iFs;
    private static final int iFt;
    protected final long iFu;
    protected final E[] iqN;

    static {
        int arrayIndexScale = ae.iFC.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            iFt = iFr + 2;
        } else if (8 == arrayIndexScale) {
            iFt = iFr + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        iFs = ae.iFC.arrayBaseOffset(Object[].class) + (32 << (iFt - iFr));
    }

    public f(int i) {
        int yX = h.yX(i);
        this.iFu = yX - 1;
        this.iqN = (E[]) new Object[(yX << iFr) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dJ(long j) {
        return t(j, this.iFu);
    }

    protected final long t(long j, long j2) {
        return iFs + ((j & j2) << iFt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.iFC.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.iFC.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.iFC.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E dK(long j) {
        return b(this.iqN, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.iFC.getObjectVolatile(eArr, j);
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
