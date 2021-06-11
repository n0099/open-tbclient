package h.o.d.j;

import java.util.Iterator;
/* loaded from: classes8.dex */
public abstract class f<E> extends g<E> {

    /* renamed from: g  reason: collision with root package name */
    public static final int f71966g = Integer.getInteger("sparse.shift", 0).intValue();

    /* renamed from: h  reason: collision with root package name */
    public static final long f71967h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f71968i;

    /* renamed from: e  reason: collision with root package name */
    public final long f71969e;

    /* renamed from: f  reason: collision with root package name */
    public final E[] f71970f;

    static {
        int b2 = f0.f71971a.b(Object[].class);
        if (4 == b2) {
            f71968i = f71966g + 2;
        } else if (8 == b2) {
            f71968i = f71966g + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f71967h = f0.f71971a.a(Object[].class) + (32 << (f71968i - f71966g));
    }

    public f(int i2) {
        int b2 = i.b(i2);
        this.f71969e = b2 - 1;
        this.f71970f = (E[]) new Object[(b2 << f71966g) + 64];
    }

    public final long a(long j) {
        return b(j, this.f71969e);
    }

    public final long b(long j, long j2) {
        return f71967h + ((j & j2) << f71968i);
    }

    public final E c(E[] eArr, long j) {
        return (E) f0.f71971a.e(eArr, j);
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
        return e(this.f71970f, j);
    }

    public final E e(E[] eArr, long j) {
        return (E) f0.f71971a.f(eArr, j);
    }

    public final void f(E[] eArr, long j, E e2) {
        f0.f71971a.j(eArr, j, e2);
    }

    public final void g(E[] eArr, long j, E e2) {
        f0.f71971a.h(eArr, j, e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
