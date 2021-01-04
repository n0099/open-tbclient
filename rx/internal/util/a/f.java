package rx.internal.util.a;

import java.util.Iterator;
/* loaded from: classes15.dex */
public abstract class f<E> extends g<E> {
    protected static final int qwe = Integer.getInteger("sparse.shift", 0).intValue();
    private static final long qwf;
    private static final int qwg;
    protected final E[] qlO;
    protected final long qwh;

    static {
        int K = ae.qwp.K(Object[].class);
        if (4 == K) {
            qwg = qwe + 2;
        } else if (8 == K) {
            qwg = qwe + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        qwf = ae.qwp.L(Object[].class) + (32 << (qwg - qwe));
    }

    public f(int i) {
        int Tk = h.Tk(i);
        this.qwh = Tk - 1;
        this.qlO = (E[]) new Object[(Tk << qwe) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long jv(long j) {
        return W(j, this.qwh);
    }

    protected final long W(long j, long j2) {
        return qwf + ((j & j2) << qwg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(E[] eArr, long j, E e) {
        ae.qwp.a(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(E[] eArr, long j, E e) {
        ae.qwp.b(eArr, j, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(E[] eArr, long j) {
        return (E) ae.qwp.c(eArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E jw(long j) {
        return b(this.qlO, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(E[] eArr, long j) {
        return (E) ae.qwp.d(eArr, j);
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
