package h.o.d.k;

import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class f<E> extends g<E> {

    /* renamed from: g  reason: collision with root package name */
    public static final int f67963g = Integer.getInteger("sparse.shift", 0).intValue();

    /* renamed from: h  reason: collision with root package name */
    public static final long f67964h;
    public static final int i;

    /* renamed from: e  reason: collision with root package name */
    public final long f67965e;

    /* renamed from: f  reason: collision with root package name */
    public final E[] f67966f;

    static {
        int b2 = f0.f67967a.b(Object[].class);
        if (4 == b2) {
            i = f67963g + 2;
        } else if (8 == b2) {
            i = f67963g + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f67964h = f0.f67967a.a(Object[].class) + (32 << (i - f67963g));
    }

    public f(int i2) {
        int b2 = i.b(i2);
        this.f67965e = b2 - 1;
        this.f67966f = (E[]) new Object[(b2 << f67963g) + 64];
    }

    public final long a(long j) {
        return b(j, this.f67965e);
    }

    public final long b(long j, long j2) {
        return f67964h + ((j & j2) << i);
    }

    public final E c(E[] eArr, long j) {
        return (E) f0.f67967a.e(eArr, j);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final E d(long j) {
        return e(this.f67966f, j);
    }

    public final E e(E[] eArr, long j) {
        return (E) f0.f67967a.f(eArr, j);
    }

    public final void f(E[] eArr, long j, E e2) {
        f0.f67967a.j(eArr, j, e2);
    }

    public final void g(E[] eArr, long j, E e2) {
        f0.f67967a.h(eArr, j, e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
