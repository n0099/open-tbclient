package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int kaR = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long kaS;
    private static final int kaT;
    protected final E[] jRE;
    protected final long kaU;

    static {
        int arrayIndexScale = ae.kbc.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kaT = kaR + 2;
        } else if (8 == arrayIndexScale) {
            kaT = kaR + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kaS = ae.kbc.arrayBaseOffset(Object[].class) + (32 << (kaT - kaR));
    }

    public f(int i) {
        int Dk = h.Dk(i);
        this.kaU = Dk - 1;
        this.jRE = (E[]) new Object[(Dk << kaR) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long er(long j) {
        return y(j, this.kaU);
    }

    protected final long y(long j, long j2) {
        return kaS + ((j & j2) << kaT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.kbc.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.kbc.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.kbc.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E es(long j) {
        return b(this.jRE, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.kbc.getObjectVolatile(eArr, j);
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
