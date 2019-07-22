package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int kAJ = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long kAK;
    private static final int kAL;
    protected final long kAM;
    protected final E[] krz;

    static {
        int arrayIndexScale = ae.kAU.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kAL = kAJ + 2;
        } else if (8 == arrayIndexScale) {
            kAL = kAJ + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kAK = ae.kAU.arrayBaseOffset(Object[].class) + (32 << (kAL - kAJ));
    }

    public f(int i) {
        int EV = h.EV(i);
        this.kAM = EV - 1;
        this.krz = (E[]) new Object[(EV << kAJ) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eZ(long j) {
        return z(j, this.kAM);
    }

    protected final long z(long j, long j2) {
        return kAK + ((j & j2) << kAL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.kAU.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.kAU.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.kAU.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E fa(long j) {
        return b(this.krz, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.kAU.getObjectVolatile(eArr, j);
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
