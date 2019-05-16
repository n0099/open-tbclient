package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int ktg = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long kth;
    private static final int kti;
    protected final E[] kjW;
    protected final long ktj;

    static {
        int arrayIndexScale = ae.ktr.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kti = ktg + 2;
        } else if (8 == arrayIndexScale) {
            kti = ktg + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kth = ae.ktr.arrayBaseOffset(Object[].class) + (32 << (kti - ktg));
    }

    public f(int i) {
        int Em = h.Em(i);
        this.ktj = Em - 1;
        this.kjW = (E[]) new Object[(Em << ktg) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eQ(long j) {
        return z(j, this.ktj);
    }

    protected final long z(long j, long j2) {
        return kth + ((j & j2) << kti);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.ktr.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.ktr.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.ktr.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E eR(long j) {
        return b(this.kjW, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.ktr.getObjectVolatile(eArr, j);
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
