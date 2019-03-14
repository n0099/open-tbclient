package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    private static final int kbA;
    protected static final int kby = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long kbz;
    protected final E[] jSl;
    protected final long kbB;

    static {
        int arrayIndexScale = ae.kbJ.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kbA = kby + 2;
        } else if (8 == arrayIndexScale) {
            kbA = kby + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kbz = ae.kbJ.arrayBaseOffset(Object[].class) + (32 << (kbA - kby));
    }

    public f(int i) {
        int Du = h.Du(i);
        this.kbB = Du - 1;
        this.jSl = (E[]) new Object[(Du << kby) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long es(long j) {
        return y(j, this.kbB);
    }

    protected final long y(long j, long j2) {
        return kbz + ((j & j2) << kbA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.kbJ.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.kbJ.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.kbJ.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E et(long j) {
        return b(this.jSl, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.kbJ.getObjectVolatile(eArr, j);
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
