package f.a.x.f;

import f.a.x.c.e;
import f.a.x.i.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class a<T> implements e<T> {
    public static final int m = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object n = new Object();

    /* renamed from: f  reason: collision with root package name */
    public int f67520f;

    /* renamed from: g  reason: collision with root package name */
    public long f67521g;

    /* renamed from: h  reason: collision with root package name */
    public final int f67522h;
    public AtomicReferenceArray<Object> i;
    public final int j;
    public AtomicReferenceArray<Object> k;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicLong f67519e = new AtomicLong();
    public final AtomicLong l = new AtomicLong();

    public a(int i) {
        int a2 = h.a(Math.max(8, i));
        int i2 = a2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a2 + 1);
        this.i = atomicReferenceArray;
        this.f67522h = i2;
        a(a2);
        this.k = atomicReferenceArray;
        this.j = i2;
        this.f67521g = i2 - 1;
        r(0L);
    }

    public static int b(int i) {
        return i;
    }

    public static int c(long j, int i) {
        int i2 = ((int) j) & i;
        b(i2);
        return i2;
    }

    public static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public static void p(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    public final void a(int i) {
        this.f67520f = Math.min(i / 4, m);
    }

    @Override // f.a.x.c.f
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final long d() {
        return this.l.get();
    }

    public final long e() {
        return this.f67519e.get();
    }

    public final long f() {
        return this.l.get();
    }

    public final AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        b(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, i);
        p(atomicReferenceArray, i, null);
        return atomicReferenceArray2;
    }

    public final long i() {
        return this.f67519e.get();
    }

    @Override // f.a.x.c.f
    public boolean isEmpty() {
        return i() == f();
    }

    public final T j(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.k = atomicReferenceArray;
        return (T) g(atomicReferenceArray, c(j, i));
    }

    public final T k(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.k = atomicReferenceArray;
        int c2 = c(j, i);
        T t = (T) g(atomicReferenceArray, c2);
        if (t != null) {
            p(atomicReferenceArray, c2, null);
            o(j + 1);
        }
        return t;
    }

    public boolean l(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.i;
        long i = i();
        int i2 = this.f67522h;
        long j = 2 + i;
        if (g(atomicReferenceArray, c(j, i2)) == null) {
            int c2 = c(i, i2);
            p(atomicReferenceArray, c2 + 1, t2);
            p(atomicReferenceArray, c2, t);
            r(j);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.i = atomicReferenceArray2;
        int c3 = c(i, i2);
        p(atomicReferenceArray2, c3 + 1, t2);
        p(atomicReferenceArray2, c3, t);
        q(atomicReferenceArray, atomicReferenceArray2);
        p(atomicReferenceArray, c3, n);
        r(j);
        return true;
    }

    public final void m(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.i = atomicReferenceArray2;
        this.f67521g = (j2 + j) - 1;
        p(atomicReferenceArray2, i, t);
        q(atomicReferenceArray, atomicReferenceArray2);
        p(atomicReferenceArray, i, n);
        r(j + 1);
    }

    public int n() {
        long f2 = f();
        while (true) {
            long i = i();
            long f3 = f();
            if (f2 == f3) {
                return (int) (i - f3);
            }
            f2 = f3;
        }
    }

    public final void o(long j) {
        this.l.lazySet(j);
    }

    @Override // f.a.x.c.f
    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.i;
            long e2 = e();
            int i = this.f67522h;
            int c2 = c(e2, i);
            if (e2 < this.f67521g) {
                return s(atomicReferenceArray, t, e2, c2);
            }
            long j = this.f67520f + e2;
            if (g(atomicReferenceArray, c(j, i)) == null) {
                this.f67521g = j - 1;
                return s(atomicReferenceArray, t, e2, c2);
            } else if (g(atomicReferenceArray, c(1 + e2, i)) == null) {
                return s(atomicReferenceArray, t, e2, c2);
            } else {
                m(atomicReferenceArray, e2, c2, t, i);
                return true;
            }
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.k;
        long d2 = d();
        int i = this.j;
        T t = (T) g(atomicReferenceArray, c(d2, i));
        return t == n ? j(h(atomicReferenceArray, i + 1), d2, i) : t;
    }

    @Override // f.a.x.c.e, f.a.x.c.f
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.k;
        long d2 = d();
        int i = this.j;
        int c2 = c(d2, i);
        T t = (T) g(atomicReferenceArray, c2);
        boolean z = t == n;
        if (t == null || z) {
            if (z) {
                return k(h(atomicReferenceArray, i + 1), d2, i);
            }
            return null;
        }
        p(atomicReferenceArray, c2, null);
        o(d2 + 1);
        return t;
    }

    public final void q(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        int length = atomicReferenceArray.length() - 1;
        b(length);
        p(atomicReferenceArray, length, atomicReferenceArray2);
    }

    public final void r(long j) {
        this.f67519e.lazySet(j);
    }

    public final boolean s(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        p(atomicReferenceArray, i, t);
        r(j + 1);
        return true;
    }
}
