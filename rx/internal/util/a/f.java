package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int kDX = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long kDY;
    private static final int kDZ;
    protected final long kEa;
    protected final E[] kuP;

    static {
        int arrayIndexScale = ae.kEi.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kDZ = kDX + 2;
        } else if (8 == arrayIndexScale) {
            kDZ = kDX + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kDY = ae.kEi.arrayBaseOffset(Object[].class) + (32 << (kDZ - kDX));
    }

    public f(int i) {
        int Dx = h.Dx(i);
        this.kEa = Dx - 1;
        this.kuP = (E[]) new Object[(Dx << kDX) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long ew(long j) {
        return F(j, this.kEa);
    }

    protected final long F(long j, long j2) {
        return kDY + ((j & j2) << kDZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.kEi.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.kEi.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.kEi.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E ex(long j) {
        return b(this.kuP, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.kEi.getObjectVolatile(eArr, j);
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
