package h.o.d.j;

import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class f<E> extends g<E> {

    /* renamed from: g  reason: collision with root package name */
    public static final int f68667g = Integer.getInteger("sparse.shift", 0).intValue();

    /* renamed from: h  reason: collision with root package name */
    public static final long f68668h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f68669i;

    /* renamed from: e  reason: collision with root package name */
    public final long f68670e;

    /* renamed from: f  reason: collision with root package name */
    public final E[] f68671f;

    static {
        int b2 = f0.f68672a.b(Object[].class);
        if (4 == b2) {
            f68669i = f68667g + 2;
        } else if (8 == b2) {
            f68669i = f68667g + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f68668h = f0.f68672a.a(Object[].class) + (32 << (f68669i - f68667g));
    }

    public f(int i2) {
        int b2 = i.b(i2);
        this.f68670e = b2 - 1;
        this.f68671f = (E[]) new Object[(b2 << f68667g) + 64];
    }

    public final long a(long j) {
        return b(j, this.f68670e);
    }

    public final long b(long j, long j2) {
        return f68668h + ((j & j2) << f68669i);
    }

    public final E c(E[] eArr, long j) {
        return (E) f0.f68672a.e(eArr, j);
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
        return e(this.f68671f, j);
    }

    public final E e(E[] eArr, long j) {
        return (E) f0.f68672a.f(eArr, j);
    }

    public final void f(E[] eArr, long j, E e2) {
        f0.f68672a.j(eArr, j, e2);
    }

    public final void g(E[] eArr, long j, E e2) {
        f0.f68672a.h(eArr, j, e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
