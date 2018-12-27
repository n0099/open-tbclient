package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int iPI = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long iPJ;
    private static final int iPK;
    protected final E[] iBh;
    protected final long iPL;

    static {
        int arrayIndexScale = ae.iPT.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            iPK = iPI + 2;
        } else if (8 == arrayIndexScale) {
            iPK = iPI + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        iPJ = ae.iPT.arrayBaseOffset(Object[].class) + (32 << (iPK - iPI));
    }

    public f(int i) {
        int zG = h.zG(i);
        this.iPL = zG - 1;
        this.iBh = (E[]) new Object[(zG << iPI) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long dV(long j) {
        return t(j, this.iPL);
    }

    protected final long t(long j, long j2) {
        return iPJ + ((j & j2) << iPK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.iPT.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.iPT.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.iPT.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E dW(long j) {
        return b(this.iBh, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.iPT.getObjectVolatile(eArr, j);
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
