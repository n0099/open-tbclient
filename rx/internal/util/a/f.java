package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int kEh = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long kEi;
    private static final int kEj;
    protected final long kEk;
    protected final E[] kuY;

    static {
        int arrayIndexScale = ae.kEs.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kEj = kEh + 2;
        } else if (8 == arrayIndexScale) {
            kEj = kEh + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kEi = ae.kEs.arrayBaseOffset(Object[].class) + (32 << (kEj - kEh));
    }

    public f(int i) {
        int Fb = h.Fb(i);
        this.kEk = Fb - 1;
        this.kuY = (E[]) new Object[(Fb << kEh) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long fc(long j) {
        return z(j, this.kEk);
    }

    protected final long z(long j, long j2) {
        return kEi + ((j & j2) << kEj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.kEs.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.kEs.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.kEs.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E fd(long j) {
        return b(this.kuY, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.kEs.getObjectVolatile(eArr, j);
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
