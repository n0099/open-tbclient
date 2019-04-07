package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class f<E> extends g<E> {
    protected static final int kaQ = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long kaR;
    private static final int kaS;
    protected final E[] jRD;
    protected final long kaT;

    static {
        int arrayIndexScale = ae.kbb.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            kaS = kaQ + 2;
        } else if (8 == arrayIndexScale) {
            kaS = kaQ + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        kaR = ae.kbb.arrayBaseOffset(Object[].class) + (32 << (kaS - kaQ));
    }

    public f(int i) {
        int Dk = h.Dk(i);
        this.kaT = Dk - 1;
        this.jRD = (E[]) new Object[(Dk << kaQ) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long er(long j) {
        return y(j, this.kaT);
    }

    protected final long y(long j, long j2) {
        return kaR + ((j & j2) << kaS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.kbb.putObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.kbb.putOrderedObject(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.kbb.getObject(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E es(long j) {
        return b(this.jRD, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.kbb.getObjectVolatile(eArr, j);
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
