package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int kBP = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long kBQ;
    private static final int kBR;
    protected final long kBS;
    protected final E[] ksF;

    static {
        int arrayIndexScale = ae.kCa.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kBR = kBP + 2;
        } else if (8 == arrayIndexScale) {
            kBR = kBP + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kBQ = ae.kCa.arrayBaseOffset(Object[].class) + (32 << (kBR - kBP));
    }

    public f(int i) {
        int EX = h.EX(i);
        this.kBS = EX - 1;
        this.ksF = (E[]) new Object[(EX << kBP) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eZ(long j) {
        return z(j, this.kBS);
    }

    protected final long z(long j, long j2) {
        return kBQ + ((j & j2) << kBR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.kCa.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.kCa.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.kCa.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E fa(long j) {
        return b(this.ksF, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.kCa.getObjectVolatile(eArr, j);
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
