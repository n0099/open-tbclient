package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int kbn = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long kbo;
    private static final int kbp;
    protected final E[] jSa;
    protected final long kbq;

    static {
        int arrayIndexScale = ae.kby.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kbp = kbn + 2;
        } else if (8 == arrayIndexScale) {
            kbp = kbn + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kbo = ae.kby.arrayBaseOffset(Object[].class) + (32 << (kbp - kbn));
    }

    public f(int i) {
        int Dt = h.Dt(i);
        this.kbq = Dt - 1;
        this.jSa = (E[]) new Object[(Dt << kbn) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long es(long j) {
        return y(j, this.kbq);
    }

    protected final long y(long j, long j2) {
        return kbo + ((j & j2) << kbp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.kby.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.kby.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.kby.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E et(long j) {
        return b(this.jSa, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.kby.getObjectVolatile(eArr, j);
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
