package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int kEO = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long kEP;
    private static final int kEQ;
    protected final long kER;
    protected final E[] kvG;

    static {
        int arrayIndexScale = ae.kEZ.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kEQ = kEO + 2;
        } else if (8 == arrayIndexScale) {
            kEQ = kEO + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kEP = ae.kEZ.arrayBaseOffset(Object[].class) + (32 << (kEQ - kEO));
    }

    public f(int i) {
        int Dy = h.Dy(i);
        this.kER = Dy - 1;
        this.kvG = (E[]) new Object[(Dy << kEO) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long ex(long j) {
        return F(j, this.kER);
    }

    protected final long F(long j, long j2) {
        return kEP + ((j & j2) << kEQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.kEZ.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.kEZ.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.kEZ.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E ey(long j) {
        return b(this.kvG, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.kEZ.getObjectVolatile(eArr, j);
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
