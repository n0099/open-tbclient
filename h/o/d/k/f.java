package h.o.d.k;

import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class f<E> extends g<E> {

    /* renamed from: g  reason: collision with root package name */
    public static final int f69125g = Integer.getInteger("sparse.shift", 0).intValue();

    /* renamed from: h  reason: collision with root package name */
    public static final long f69126h;
    public static final int i;

    /* renamed from: e  reason: collision with root package name */
    public final long f69127e;

    /* renamed from: f  reason: collision with root package name */
    public final E[] f69128f;

    static {
        int b2 = f0.f69129a.b(Object[].class);
        if (4 == b2) {
            i = f69125g + 2;
        } else if (8 == b2) {
            i = f69125g + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f69126h = f0.f69129a.a(Object[].class) + (32 << (i - f69125g));
    }

    public f(int i2) {
        int b2 = i.b(i2);
        this.f69127e = b2 - 1;
        this.f69128f = (E[]) new Object[(b2 << f69125g) + 64];
    }

    public final long a(long j) {
        return b(j, this.f69127e);
    }

    public final long b(long j, long j2) {
        return f69126h + ((j & j2) << i);
    }

    public final E c(E[] eArr, long j) {
        return (E) f0.f69129a.e(eArr, j);
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
        return e(this.f69128f, j);
    }

    public final E e(E[] eArr, long j) {
        return (E) f0.f69129a.f(eArr, j);
    }

    public final void f(E[] eArr, long j, E e2) {
        f0.f69129a.j(eArr, j, e2);
    }

    public final void g(E[] eArr, long j, E e2) {
        f0.f69129a.h(eArr, j, e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
