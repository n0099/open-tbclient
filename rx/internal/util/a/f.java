package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int kth = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long kti;
    private static final int ktj;
    protected final E[] kjX;
    protected final long ktk;

    static {
        int arrayIndexScale = ae.kts.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            ktj = kth + 2;
        } else if (8 == arrayIndexScale) {
            ktj = kth + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kti = ae.kts.arrayBaseOffset(Object[].class) + (32 << (ktj - kth));
    }

    public f(int i) {
        int Em = h.Em(i);
        this.ktk = Em - 1;
        this.kjX = (E[]) new Object[(Em << kth) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eQ(long j) {
        return z(j, this.ktk);
    }

    protected final long z(long j, long j2) {
        return kti + ((j & j2) << ktj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.kts.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.kts.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.kts.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E eR(long j) {
        return b(this.kjX, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.kts.getObjectVolatile(eArr, j);
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
