package h.o.d.k;

import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class f<E> extends g<E> {

    /* renamed from: g  reason: collision with root package name */
    public static final int f67968g = Integer.getInteger("sparse.shift", 0).intValue();

    /* renamed from: h  reason: collision with root package name */
    public static final long f67969h;
    public static final int i;

    /* renamed from: e  reason: collision with root package name */
    public final long f67970e;

    /* renamed from: f  reason: collision with root package name */
    public final E[] f67971f;

    static {
        int b2 = f0.f67972a.b(Object[].class);
        if (4 == b2) {
            i = f67968g + 2;
        } else if (8 == b2) {
            i = f67968g + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f67969h = f0.f67972a.a(Object[].class) + (32 << (i - f67968g));
    }

    public f(int i2) {
        int b2 = i.b(i2);
        this.f67970e = b2 - 1;
        this.f67971f = (E[]) new Object[(b2 << f67968g) + 64];
    }

    public final long a(long j) {
        return b(j, this.f67970e);
    }

    public final long b(long j, long j2) {
        return f67969h + ((j & j2) << i);
    }

    public final E c(E[] eArr, long j) {
        return (E) f0.f67972a.e(eArr, j);
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
        return e(this.f67971f, j);
    }

    public final E e(E[] eArr, long j) {
        return (E) f0.f67972a.f(eArr, j);
    }

    public final void f(E[] eArr, long j, E e2) {
        f0.f67972a.j(eArr, j, e2);
    }

    public final void g(E[] eArr, long j, E e2) {
        f0.f67972a.h(eArr, j, e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
