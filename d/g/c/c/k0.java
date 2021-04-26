package d.g.c.c;

import com.google.common.collect.Multisets;
import d.g.c.c.i0;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class k0<K> {

    /* renamed from: a  reason: collision with root package name */
    public transient Object[] f65551a;

    /* renamed from: b  reason: collision with root package name */
    public transient int[] f65552b;

    /* renamed from: c  reason: collision with root package name */
    public transient int f65553c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f65554d;

    /* renamed from: e  reason: collision with root package name */
    public transient int[] f65555e;

    /* renamed from: f  reason: collision with root package name */
    public transient long[] f65556f;

    /* renamed from: g  reason: collision with root package name */
    public transient float f65557g;

    /* renamed from: h  reason: collision with root package name */
    public transient int f65558h;

    /* loaded from: classes6.dex */
    public class a extends Multisets.b<K> {

        /* renamed from: e  reason: collision with root package name */
        public final K f65559e;

        /* renamed from: f  reason: collision with root package name */
        public int f65560f;

        public a(int i2) {
            this.f65559e = (K) k0.this.f65551a[i2];
            this.f65560f = i2;
        }

        public void a() {
            int i2 = this.f65560f;
            if (i2 == -1 || i2 >= k0.this.C() || !d.g.c.a.k.a(this.f65559e, k0.this.f65551a[this.f65560f])) {
                this.f65560f = k0.this.m(this.f65559e);
            }
        }

        @Override // d.g.c.c.i0.a
        public int getCount() {
            a();
            int i2 = this.f65560f;
            if (i2 == -1) {
                return 0;
            }
            return k0.this.f65552b[i2];
        }

        @Override // d.g.c.c.i0.a
        public K getElement() {
            return this.f65559e;
        }
    }

    public k0() {
        n(3, 1.0f);
    }

    public static long D(long j, int i2) {
        return (j & (-4294967296L)) | (i2 & 4294967295L);
    }

    public static <K> k0<K> b() {
        return new k0<>();
    }

    public static <K> k0<K> c(int i2) {
        return new k0<>(i2);
    }

    public static int h(long j) {
        return (int) (j >>> 32);
    }

    public static int j(long j) {
        return (int) j;
    }

    public static long[] q(int i2) {
        long[] jArr = new long[i2];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] r(int i2) {
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public final void A(int i2) {
        if (this.f65555e.length >= 1073741824) {
            this.f65558h = Integer.MAX_VALUE;
            return;
        }
        int i3 = ((int) (i2 * this.f65557g)) + 1;
        int[] r = r(i2);
        long[] jArr = this.f65556f;
        int length = r.length - 1;
        for (int i4 = 0; i4 < this.f65553c; i4++) {
            int h2 = h(jArr[i4]);
            int i5 = h2 & length;
            int i6 = r[i5];
            r[i5] = i4;
            jArr[i4] = (h2 << 32) | (i6 & 4294967295L);
        }
        this.f65558h = i3;
        this.f65555e = r;
    }

    public void B(int i2, int i3) {
        d.g.c.a.n.n(i2, this.f65553c);
        this.f65552b[i2] = i3;
    }

    public int C() {
        return this.f65553c;
    }

    public void a() {
        this.f65554d++;
        Arrays.fill(this.f65551a, 0, this.f65553c, (Object) null);
        Arrays.fill(this.f65552b, 0, this.f65553c, 0);
        Arrays.fill(this.f65555e, -1);
        Arrays.fill(this.f65556f, -1L);
        this.f65553c = 0;
    }

    public void d(int i2) {
        if (i2 > this.f65556f.length) {
            y(i2);
        }
        if (i2 >= this.f65558h) {
            A(Math.max(2, Integer.highestOneBit(i2 - 1) << 1));
        }
    }

    public int e() {
        return this.f65553c == 0 ? -1 : 0;
    }

    public int f(Object obj) {
        int m = m(obj);
        if (m == -1) {
            return 0;
        }
        return this.f65552b[m];
    }

    public i0.a<K> g(int i2) {
        d.g.c.a.n.n(i2, this.f65553c);
        return new a(i2);
    }

    public K i(int i2) {
        d.g.c.a.n.n(i2, this.f65553c);
        return (K) this.f65551a[i2];
    }

    public int k(int i2) {
        d.g.c.a.n.n(i2, this.f65553c);
        return this.f65552b[i2];
    }

    public final int l() {
        return this.f65555e.length - 1;
    }

    public int m(Object obj) {
        int d2 = e0.d(obj);
        int i2 = this.f65555e[l() & d2];
        while (i2 != -1) {
            long j = this.f65556f[i2];
            if (h(j) == d2 && d.g.c.a.k.a(obj, this.f65551a[i2])) {
                return i2;
            }
            i2 = j(j);
        }
        return -1;
    }

    public void n(int i2, float f2) {
        d.g.c.a.n.e(i2 >= 0, "Initial capacity must be non-negative");
        d.g.c.a.n.e(f2 > 0.0f, "Illegal load factor");
        int a2 = e0.a(i2, f2);
        this.f65555e = r(a2);
        this.f65557g = f2;
        this.f65551a = new Object[i2];
        this.f65552b = new int[i2];
        this.f65556f = q(i2);
        this.f65558h = Math.max(1, (int) (a2 * f2));
    }

    public void o(int i2, K k, int i3, int i4) {
        this.f65556f[i2] = (i4 << 32) | 4294967295L;
        this.f65551a[i2] = k;
        this.f65552b[i2] = i3;
    }

    public void p(int i2) {
        int C = C() - 1;
        if (i2 < C) {
            Object[] objArr = this.f65551a;
            objArr[i2] = objArr[C];
            int[] iArr = this.f65552b;
            iArr[i2] = iArr[C];
            objArr[C] = null;
            iArr[C] = 0;
            long[] jArr = this.f65556f;
            long j = jArr[C];
            jArr[i2] = j;
            jArr[C] = -1;
            int h2 = h(j) & l();
            int[] iArr2 = this.f65555e;
            int i3 = iArr2[h2];
            if (i3 == C) {
                iArr2[h2] = i2;
                return;
            }
            while (true) {
                long j2 = this.f65556f[i3];
                int j3 = j(j2);
                if (j3 == C) {
                    this.f65556f[i3] = D(j2, i2);
                    return;
                }
                i3 = j3;
            }
        } else {
            this.f65551a[i2] = null;
            this.f65552b[i2] = 0;
            this.f65556f[i2] = -1;
        }
    }

    public int s(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.f65553c) {
            return i3;
        }
        return -1;
    }

    public int t(int i2, int i3) {
        return i2 - 1;
    }

    public int u(K k, int i2) {
        m.d(i2, "count");
        long[] jArr = this.f65556f;
        Object[] objArr = this.f65551a;
        int[] iArr = this.f65552b;
        int d2 = e0.d(k);
        int l = l() & d2;
        int i3 = this.f65553c;
        int[] iArr2 = this.f65555e;
        int i4 = iArr2[l];
        if (i4 == -1) {
            iArr2[l] = i3;
        } else {
            while (true) {
                long j = jArr[i4];
                if (h(j) == d2 && d.g.c.a.k.a(k, objArr[i4])) {
                    int i5 = iArr[i4];
                    iArr[i4] = i2;
                    return i5;
                }
                int j2 = j(j);
                if (j2 == -1) {
                    jArr[i4] = D(j, i3);
                    break;
                }
                i4 = j2;
            }
        }
        if (i3 != Integer.MAX_VALUE) {
            int i6 = i3 + 1;
            z(i6);
            o(i3, k, i2, d2);
            this.f65553c = i6;
            if (i3 >= this.f65558h) {
                A(this.f65555e.length * 2);
            }
            this.f65554d++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    public int v(Object obj) {
        return w(obj, e0.d(obj));
    }

    public final int w(Object obj, int i2) {
        int l = l() & i2;
        int i3 = this.f65555e[l];
        if (i3 == -1) {
            return 0;
        }
        int i4 = -1;
        while (true) {
            if (h(this.f65556f[i3]) == i2 && d.g.c.a.k.a(obj, this.f65551a[i3])) {
                int i5 = this.f65552b[i3];
                if (i4 == -1) {
                    this.f65555e[l] = j(this.f65556f[i3]);
                } else {
                    long[] jArr = this.f65556f;
                    jArr[i4] = D(jArr[i4], j(jArr[i3]));
                }
                p(i3);
                this.f65553c--;
                this.f65554d++;
                return i5;
            }
            int j = j(this.f65556f[i3]);
            if (j == -1) {
                return 0;
            }
            i4 = i3;
            i3 = j;
        }
    }

    public int x(int i2) {
        return w(this.f65551a[i2], h(this.f65556f[i2]));
    }

    public void y(int i2) {
        this.f65551a = Arrays.copyOf(this.f65551a, i2);
        this.f65552b = Arrays.copyOf(this.f65552b, i2);
        long[] jArr = this.f65556f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i2);
        if (i2 > length) {
            Arrays.fill(copyOf, length, i2, -1L);
        }
        this.f65556f = copyOf;
    }

    public final void z(int i2) {
        int length = this.f65556f.length;
        if (i2 > length) {
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

    public k0(int i2) {
        this(i2, 1.0f);
    }

    public k0(int i2, float f2) {
        n(i2, f2);
    }
}
