package d.h.c.c;

import com.google.common.collect.Multisets;
import d.h.c.c.i0;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class k0<K> {

    /* renamed from: a  reason: collision with root package name */
    public transient Object[] f67136a;

    /* renamed from: b  reason: collision with root package name */
    public transient int[] f67137b;

    /* renamed from: c  reason: collision with root package name */
    public transient int f67138c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f67139d;

    /* renamed from: e  reason: collision with root package name */
    public transient int[] f67140e;

    /* renamed from: f  reason: collision with root package name */
    public transient long[] f67141f;

    /* renamed from: g  reason: collision with root package name */
    public transient float f67142g;

    /* renamed from: h  reason: collision with root package name */
    public transient int f67143h;

    /* loaded from: classes6.dex */
    public class a extends Multisets.b<K> {

        /* renamed from: e  reason: collision with root package name */
        public final K f67144e;

        /* renamed from: f  reason: collision with root package name */
        public int f67145f;

        public a(int i) {
            this.f67144e = (K) k0.this.f67136a[i];
            this.f67145f = i;
        }

        public void a() {
            int i = this.f67145f;
            if (i == -1 || i >= k0.this.C() || !d.h.c.a.k.a(this.f67144e, k0.this.f67136a[this.f67145f])) {
                this.f67145f = k0.this.m(this.f67144e);
            }
        }

        @Override // d.h.c.c.i0.a
        public int getCount() {
            a();
            int i = this.f67145f;
            if (i == -1) {
                return 0;
            }
            return k0.this.f67137b[i];
        }

        @Override // d.h.c.c.i0.a
        public K getElement() {
            return this.f67144e;
        }
    }

    public k0() {
        n(3, 1.0f);
    }

    public static long D(long j, int i) {
        return (j & (-4294967296L)) | (i & 4294967295L);
    }

    public static <K> k0<K> b() {
        return new k0<>();
    }

    public static <K> k0<K> c(int i) {
        return new k0<>(i);
    }

    public static int h(long j) {
        return (int) (j >>> 32);
    }

    public static int j(long j) {
        return (int) j;
    }

    public static long[] q(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] r(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public final void A(int i) {
        if (this.f67140e.length >= 1073741824) {
            this.f67143h = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.f67142g)) + 1;
        int[] r = r(i);
        long[] jArr = this.f67141f;
        int length = r.length - 1;
        for (int i3 = 0; i3 < this.f67138c; i3++) {
            int h2 = h(jArr[i3]);
            int i4 = h2 & length;
            int i5 = r[i4];
            r[i4] = i3;
            jArr[i3] = (h2 << 32) | (i5 & 4294967295L);
        }
        this.f67143h = i2;
        this.f67140e = r;
    }

    public void B(int i, int i2) {
        d.h.c.a.n.n(i, this.f67138c);
        this.f67137b[i] = i2;
    }

    public int C() {
        return this.f67138c;
    }

    public void a() {
        this.f67139d++;
        Arrays.fill(this.f67136a, 0, this.f67138c, (Object) null);
        Arrays.fill(this.f67137b, 0, this.f67138c, 0);
        Arrays.fill(this.f67140e, -1);
        Arrays.fill(this.f67141f, -1L);
        this.f67138c = 0;
    }

    public void d(int i) {
        if (i > this.f67141f.length) {
            y(i);
        }
        if (i >= this.f67143h) {
            A(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    public int e() {
        return this.f67138c == 0 ? -1 : 0;
    }

    public int f(Object obj) {
        int m = m(obj);
        if (m == -1) {
            return 0;
        }
        return this.f67137b[m];
    }

    public i0.a<K> g(int i) {
        d.h.c.a.n.n(i, this.f67138c);
        return new a(i);
    }

    public K i(int i) {
        d.h.c.a.n.n(i, this.f67138c);
        return (K) this.f67136a[i];
    }

    public int k(int i) {
        d.h.c.a.n.n(i, this.f67138c);
        return this.f67137b[i];
    }

    public final int l() {
        return this.f67140e.length - 1;
    }

    public int m(Object obj) {
        int d2 = e0.d(obj);
        int i = this.f67140e[l() & d2];
        while (i != -1) {
            long j = this.f67141f[i];
            if (h(j) == d2 && d.h.c.a.k.a(obj, this.f67136a[i])) {
                return i;
            }
            i = j(j);
        }
        return -1;
    }

    public void n(int i, float f2) {
        d.h.c.a.n.e(i >= 0, "Initial capacity must be non-negative");
        d.h.c.a.n.e(f2 > 0.0f, "Illegal load factor");
        int a2 = e0.a(i, f2);
        this.f67140e = r(a2);
        this.f67142g = f2;
        this.f67136a = new Object[i];
        this.f67137b = new int[i];
        this.f67141f = q(i);
        this.f67143h = Math.max(1, (int) (a2 * f2));
    }

    public void o(int i, K k, int i2, int i3) {
        this.f67141f[i] = (i3 << 32) | 4294967295L;
        this.f67136a[i] = k;
        this.f67137b[i] = i2;
    }

    public void p(int i) {
        int C = C() - 1;
        if (i < C) {
            Object[] objArr = this.f67136a;
            objArr[i] = objArr[C];
            int[] iArr = this.f67137b;
            iArr[i] = iArr[C];
            objArr[C] = null;
            iArr[C] = 0;
            long[] jArr = this.f67141f;
            long j = jArr[C];
            jArr[i] = j;
            jArr[C] = -1;
            int h2 = h(j) & l();
            int[] iArr2 = this.f67140e;
            int i2 = iArr2[h2];
            if (i2 == C) {
                iArr2[h2] = i;
                return;
            }
            while (true) {
                long j2 = this.f67141f[i2];
                int j3 = j(j2);
                if (j3 == C) {
                    this.f67141f[i2] = D(j2, i);
                    return;
                }
                i2 = j3;
            }
        } else {
            this.f67136a[i] = null;
            this.f67137b[i] = 0;
            this.f67141f[i] = -1;
        }
    }

    public int s(int i) {
        int i2 = i + 1;
        if (i2 < this.f67138c) {
            return i2;
        }
        return -1;
    }

    public int t(int i, int i2) {
        return i - 1;
    }

    public int u(K k, int i) {
        m.d(i, "count");
        long[] jArr = this.f67141f;
        Object[] objArr = this.f67136a;
        int[] iArr = this.f67137b;
        int d2 = e0.d(k);
        int l = l() & d2;
        int i2 = this.f67138c;
        int[] iArr2 = this.f67140e;
        int i3 = iArr2[l];
        if (i3 == -1) {
            iArr2[l] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (h(j) == d2 && d.h.c.a.k.a(k, objArr[i3])) {
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                    return i4;
                }
                int j2 = j(j);
                if (j2 == -1) {
                    jArr[i3] = D(j, i2);
                    break;
                }
                i3 = j2;
            }
        }
        if (i2 != Integer.MAX_VALUE) {
            int i5 = i2 + 1;
            z(i5);
            o(i2, k, i, d2);
            this.f67138c = i5;
            if (i2 >= this.f67143h) {
                A(this.f67140e.length * 2);
            }
            this.f67139d++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    public int v(Object obj) {
        return w(obj, e0.d(obj));
    }

    public final int w(Object obj, int i) {
        int l = l() & i;
        int i2 = this.f67140e[l];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (h(this.f67141f[i2]) == i && d.h.c.a.k.a(obj, this.f67136a[i2])) {
                int i4 = this.f67137b[i2];
                if (i3 == -1) {
                    this.f67140e[l] = j(this.f67141f[i2]);
                } else {
                    long[] jArr = this.f67141f;
                    jArr[i3] = D(jArr[i3], j(jArr[i2]));
                }
                p(i2);
                this.f67138c--;
                this.f67139d++;
                return i4;
            }
            int j = j(this.f67141f[i2]);
            if (j == -1) {
                return 0;
            }
            i3 = i2;
            i2 = j;
        }
    }

    public int x(int i) {
        return w(this.f67136a[i], h(this.f67141f[i]));
    }

    public void y(int i) {
        this.f67136a = Arrays.copyOf(this.f67136a, i);
        this.f67137b = Arrays.copyOf(this.f67137b, i);
        long[] jArr = this.f67141f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.f67141f = copyOf;
    }

    public final void z(int i) {
        int length = this.f67141f.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                y(max);
            }
        }
    }

    public k0(k0<? extends K> k0Var) {
        n(k0Var.C(), 1.0f);
        int e2 = k0Var.e();
        while (e2 != -1) {
            u(k0Var.i(e2), k0Var.k(e2));
            e2 = k0Var.s(e2);
        }
    }

    public k0(int i) {
        this(i, 1.0f);
    }

    public k0(int i, float f2) {
        n(i, f2);
    }
}
