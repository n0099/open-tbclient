package h.o.d.j;

import java.util.Iterator;
/* loaded from: classes8.dex */
public abstract class f<E> extends g<E> {

    /* renamed from: g  reason: collision with root package name */
    public static final int f72070g = Integer.getInteger("sparse.shift", 0).intValue();

    /* renamed from: h  reason: collision with root package name */
    public static final long f72071h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f72072i;

    /* renamed from: e  reason: collision with root package name */
    public final long f72073e;

    /* renamed from: f  reason: collision with root package name */
    public final E[] f72074f;

    static {
        int b2 = f0.f72075a.b(Object[].class);
        if (4 == b2) {
            f72072i = f72070g + 2;
        } else if (8 == b2) {
            f72072i = f72070g + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f72071h = f0.f72075a.a(Object[].class) + (32 << (f72072i - f72070g));
    }

    public f(int i2) {
        int b2 = i.b(i2);
        this.f72073e = b2 - 1;
        this.f72074f = (E[]) new Object[(b2 << f72070g) + 64];
    }

    public final long a(long j) {
        return b(j, this.f72073e);
    }

    public final long b(long j, long j2) {
        return f72071h + ((j & j2) << f72072i);
    }

    public final E c(E[] eArr, long j) {
        return (E) f0.f72075a.e(eArr, j);
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
        return e(this.f72074f, j);
    }

    public final E e(E[] eArr, long j) {
        return (E) f0.f72075a.f(eArr, j);
    }

    public final void f(E[] eArr, long j, E e2) {
        f0.f72075a.j(eArr, j, e2);
    }

    public final void g(E[] eArr, long j, E e2) {
        f0.f72075a.h(eArr, j, e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
