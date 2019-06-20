package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int ktk = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long ktl;
    private static final int ktm;
    protected final E[] kka;
    protected final long ktn;

    static {
        int arrayIndexScale = ae.ktv.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            ktm = ktk + 2;
        } else if (8 == arrayIndexScale) {
            ktm = ktk + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        ktl = ae.ktv.arrayBaseOffset(Object[].class) + (32 << (ktm - ktk));
    }

    public f(int i) {
        int Em = h.Em(i);
        this.ktn = Em - 1;
        this.kka = (E[]) new Object[(Em << ktk) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long eQ(long j) {
        return z(j, this.ktn);
    }

    protected final long z(long j, long j2) {
        return ktl + ((j & j2) << ktm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.ktv.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.ktv.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.ktv.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E eR(long j) {
        return b(this.kka, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.ktv.getObjectVolatile(eArr, j);
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
