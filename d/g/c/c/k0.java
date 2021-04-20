package d.g.c.c;

import com.google.common.collect.Multisets;
import d.g.c.c.i0;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class k0<K> {

    /* renamed from: a  reason: collision with root package name */
    public transient Object[] f66989a;

    /* renamed from: b  reason: collision with root package name */
    public transient int[] f66990b;

    /* renamed from: c  reason: collision with root package name */
    public transient int f66991c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f66992d;

    /* renamed from: e  reason: collision with root package name */
    public transient int[] f66993e;

    /* renamed from: f  reason: collision with root package name */
    public transient long[] f66994f;

    /* renamed from: g  reason: collision with root package name */
    public transient float f66995g;

    /* renamed from: h  reason: collision with root package name */
    public transient int f66996h;

    /* loaded from: classes6.dex */
    public class a extends Multisets.b<K> {

        /* renamed from: e  reason: collision with root package name */
        public final K f66997e;

        /* renamed from: f  reason: collision with root package name */
        public int f66998f;

        public a(int i) {
            this.f66997e = (K) k0.this.f66989a[i];
            this.f66998f = i;
        }

        public void a() {
            int i = this.f66998f;
            if (i == -1 || i >= k0.this.C() || !d.g.c.a.k.a(this.f66997e, k0.this.f66989a[this.f66998f])) {
                this.f66998f = k0.this.m(this.f66997e);
            }
        }

        @Override // d.g.c.c.i0.a
        public int getCount() {
            a();
            int i = this.f66998f;
            if (i == -1) {
                return 0;
            }
            return k0.this.f66990b[i];
        }

        @Override // d.g.c.c.i0.a
        public K getElement() {
            return this.f66997e;
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
        if (this.f66993e.length >= 1073741824) {
            this.f66996h = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.f66995g)) + 1;
        int[] r = r(i);
        long[] jArr = this.f66994f;
        int length = r.length - 1;
        for (int i3 = 0; i3 < this.f66991c; i3++) {
            int h2 = h(jArr[i3]);
            int i4 = h2 & length;
            int i5 = r[i4];
            r[i4] = i3;
            jArr[i3] = (h2 << 32) | (i5 & 4294967295L);
        }
        this.f66996h = i2;
        this.f66993e = r;
    }

    public void B(int i, int i2) {
        d.g.c.a.n.n(i, this.f66991c);
        this.f66990b[i] = i2;
    }

    public int C() {
        return this.f66991c;
    }

    public void a() {
        this.f66992d++;
        Arrays.fill(this.f66989a, 0, this.f66991c, (Object) null);
        Arrays.fill(this.f66990b, 0, this.f66991c, 0);
        Arrays.fill(this.f66993e, -1);
        Arrays.fill(this.f66994f, -1L);
        this.f66991c = 0;
    }

    public void d(int i) {
        if (i > this.f66994f.length) {
            y(i);
        }
        if (i >= this.f66996h) {
            A(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    public int e() {
        return this.f66991c == 0 ? -1 : 0;
    }

    public int f(Object obj) {
        int m = m(obj);
        if (m == -1) {
            return 0;
        }
        return this.f66990b[m];
    }

    public i0.a<K> g(int i) {
        d.g.c.a.n.n(i, this.f66991c);
        return new a(i);
    }

    public K i(int i) {
        d.g.c.a.n.n(i, this.f66991c);
        return (K) this.f66989a[i];
    }

    public int k(int i) {
        d.g.c.a.n.n(i, this.f66991c);
        return this.f66990b[i];
    }

    public final int l() {
        return this.f66993e.length - 1;
    }

    public int m(Object obj) {
        int d2 = e0.d(obj);
        int i = this.f66993e[l() & d2];
        while (i != -1) {
            long j = this.f66994f[i];
            if (h(j) == d2 && d.g.c.a.k.a(obj, this.f66989a[i])) {
                return i;
            }
            i = j(j);
        }
        return -1;
    }

    public void n(int i, float f2) {
        d.g.c.a.n.e(i >= 0, "Initial capacity must be non-negative");
        d.g.c.a.n.e(f2 > 0.0f, "Illegal load factor");
        int a2 = e0.a(i, f2);
        this.f66993e = r(a2);
        this.f66995g = f2;
        this.f66989a = new Object[i];
        this.f66990b = new int[i];
        this.f66994f = q(i);
        this.f66996h = Math.max(1, (int) (a2 * f2));
    }

    public void o(int i, K k, int i2, int i3) {
        this.f66994f[i] = (i3 << 32) | 4294967295L;
        this.f66989a[i] = k;
        this.f66990b[i] = i2;
    }

    public void p(int i) {
        int C = C() - 1;
        if (i < C) {
            Object[] objArr = this.f66989a;
            objArr[i] = objArr[C];
            int[] iArr = this.f66990b;
            iArr[i] = iArr[C];
            objArr[C] = null;
            iArr[C] = 0;
            long[] jArr = this.f66994f;
            long j = jArr[C];
            jArr[i] = j;
            jArr[C] = -1;
            int h2 = h(j) & l();
            int[] iArr2 = this.f66993e;
            int i2 = iArr2[h2];
            if (i2 == C) {
                iArr2[h2] = i;
                return;
            }
            while (true) {
                long j2 = this.f66994f[i2];
                int j3 = j(j2);
                if (j3 == C) {
                    this.f66994f[i2] = D(j2, i);
                    return;
                }
                i2 = j3;
            }
        } else {
            this.f66989a[i] = null;
            this.f66990b[i] = 0;
            this.f66994f[i] = -1;
        }
    }

    public int s(int i) {
        int i2 = i + 1;
        if (i2 < this.f66991c) {
            return i2;
        }
        return -1;
    }

    public int t(int i, int i2) {
        return i - 1;
    }

    public int u(K k, int i) {
        m.d(i, "count");
        long[] jArr = this.f66994f;
        Object[] objArr = this.f66989a;
        int[] iArr = this.f66990b;
        int d2 = e0.d(k);
        int l = l() & d2;
        int i2 = this.f66991c;
        int[] iArr2 = this.f66993e;
        int i3 = iArr2[l];
        if (i3 == -1) {
            iArr2[l] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (h(j) == d2 && d.g.c.a.k.a(k, objArr[i3])) {
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
            this.f66991c = i5;
            if (i2 >= this.f66996h) {
                A(this.f66993e.length * 2);
            }
            this.f66992d++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    public int v(Object obj) {
        return w(obj, e0.d(obj));
    }

    public final int w(Object obj, int i) {
        int l = l() & i;
        int i2 = this.f66993e[l];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (h(this.f66994f[i2]) == i && d.g.c.a.k.a(obj, this.f66989a[i2])) {
                int i4 = this.f66990b[i2];
                if (i3 == -1) {
                    this.f66993e[l] = j(this.f66994f[i2]);
                } else {
                    long[] jArr = this.f66994f;
                    jArr[i3] = D(jArr[i3], j(jArr[i2]));
                }
                p(i2);
                this.f66991c--;
                this.f66992d++;
                return i4;
            }
            int j = j(this.f66994f[i2]);
            if (j == -1) {
                return 0;
            }
            i3 = i2;
            i2 = j;
        }
    }

    public int x(int i) {
        return w(this.f66989a[i], h(this.f66994f[i]));
    }

    public void y(int i) {
        this.f66989a = Arrays.copyOf(this.f66989a, i);
        this.f66990b = Arrays.copyOf(this.f66990b, i);
        long[] jArr = this.f66994f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.f66994f = copyOf;
    }

    public final void z(int i) {
        int length = this.f66994f.length;
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
