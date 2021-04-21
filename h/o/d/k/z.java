package h.o.d.k;

import java.util.Iterator;
/* loaded from: classes7.dex */
public class z<E> extends b0<E> {
    public static final long l;
    public static final long m;
    public static final long n;
    public static final int o;
    public static final int k = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object p = new Object();

    static {
        int b2 = f0.f69129a.b(Object[].class);
        if (4 == b2) {
            o = 2;
        } else if (8 == b2) {
            o = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        n = f0.f69129a.a(Object[].class);
        try {
            l = f0.f69129a.g(e0.class.getDeclaredField("producerIndex"));
            try {
                m = f0.f69129a.g(b0.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e2) {
                InternalError internalError = new InternalError();
                internalError.initCause(e2);
                throw internalError;
            }
        } catch (NoSuchFieldException e3) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e3);
            throw internalError2;
        }
    }

    public z(int i) {
        int b2 = i.b(i);
        long j = b2 - 1;
        E[] eArr = (E[]) new Object[b2 + 1];
        this.f69123h = eArr;
        this.f69122g = j;
        a(b2);
        this.j = eArr;
        this.i = j;
        this.f69121f = j - 1;
        n(0L);
    }

    public static long b(long j) {
        return n + (j << o);
    }

    public static long c(long j, long j2) {
        return b(j & j2);
    }

    public static <E> Object e(E[] eArr, long j) {
        return f0.f69129a.f(eArr, j);
    }

    public static void l(Object[] objArr, long j, Object obj) {
        f0.f69129a.j(objArr, j, obj);
    }

    public final void a(int i) {
        this.f69120e = Math.min(i / 4, k);
    }

    public final long d() {
        return f0.f69129a.d(this, m);
    }

    public final E[] f(E[] eArr) {
        return (E[]) ((Object[]) e(eArr, b(eArr.length - 1)));
    }

    public final long g() {
        return f0.f69129a.d(this, l);
    }

    public final E h(E[] eArr, long j, long j2) {
        this.j = eArr;
        return (E) e(eArr, c(j, j2));
    }

    public final E i(E[] eArr, long j, long j2) {
        this.j = eArr;
        long c2 = c(j, j2);
        E e2 = (E) e(eArr, c2);
        if (e2 == null) {
            return null;
        }
        l(eArr, c2, null);
        k(j + 1);
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final void j(E[] eArr, long j, long j2, E e2, long j3) {
        E[] eArr2 = (E[]) new Object[eArr.length];
        this.f69123h = eArr2;
        this.f69121f = (j3 + j) - 1;
        l(eArr2, j2, e2);
        m(eArr, eArr2);
        l(eArr, j2, p);
        n(j + 1);
    }

    public final void k(long j) {
        f0.f69129a.i(this, m, j);
    }

    public final void m(E[] eArr, E[] eArr2) {
        l(eArr, b(eArr.length - 1), eArr2);
    }

    public final void n(long j) {
        f0.f69129a.i(this, l, j);
    }

    public final boolean o(E[] eArr, E e2, long j, long j2) {
        l(eArr, j2, e2);
        n(j + 1);
        return true;
    }

    @Override // java.util.Queue
    public final boolean offer(E e2) {
        if (e2 != null) {
            E[] eArr = this.f69123h;
            long j = this.producerIndex;
            long j2 = this.f69122g;
            long c2 = c(j, j2);
            if (j < this.f69121f) {
                return o(eArr, e2, j, c2);
            }
            long j3 = this.f69120e + j;
            if (e(eArr, c(j3, j2)) == null) {
                this.f69121f = j3 - 1;
                return o(eArr, e2, j, c2);
            } else if (e(eArr, c(1 + j, j2)) != null) {
                return o(eArr, e2, j, c2);
            } else {
                j(eArr, j, c2, e2, j2);
                return true;
            }
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue
    public final E peek() {
        E[] eArr = this.j;
        long j = this.consumerIndex;
        long j2 = this.i;
        E e2 = (E) e(eArr, c(j, j2));
        return e2 == p ? h(f(eArr), j, j2) : e2;
    }

    @Override // java.util.Queue
    public final E poll() {
        E[] eArr = this.j;
        long j = this.consumerIndex;
        long j2 = this.i;
        long c2 = c(j, j2);
        E e2 = (E) e(eArr, c2);
        boolean z = e2 == p;
        if (e2 == null || z) {
            if (z) {
                return i(f(eArr), j, j2);
            }
            return null;
        }
        l(eArr, c2, null);
        k(j + 1);
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        long d2 = d();
        while (true) {
            long g2 = g();
            long d3 = d();
            if (d2 == d3) {
                return (int) (g2 - d3);
            }
            d2 = d3;
        }
    }
}
