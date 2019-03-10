package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int kbG = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long kbH;
    private static final int kbI;
    protected final E[] jSt;
    protected final long kbJ;

    static {
        int arrayIndexScale = ae.kbR.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kbI = kbG + 2;
        } else if (8 == arrayIndexScale) {
            kbI = kbG + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kbH = ae.kbR.arrayBaseOffset(Object[].class) + (32 << (kbI - kbG));
    }

    public f(int i) {
        int Du = h.Du(i);
        this.kbJ = Du - 1;
        this.jSt = (E[]) new Object[(Du << kbG) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long es(long j) {
        return y(j, this.kbJ);
    }

    protected final long y(long j, long j2) {
        return kbH + ((j & j2) << kbI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.kbR.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.kbR.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.kbR.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E et(long j) {
        return b(this.jSt, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.kbR.getObjectVolatile(eArr, j);
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
