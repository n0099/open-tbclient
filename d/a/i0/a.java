package d.a.i0;

import com.baidu.smartcolor.utils.Tri;
/* loaded from: classes2.dex */
public class a {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public int f43863a = 0;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public int f43864b = 0;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public int f43865c = 32;

    /* renamed from: d  reason: collision with root package name */
    public String f43866d;

    /* renamed from: e  reason: collision with root package name */
    public String f43867e;

    /* renamed from: f  reason: collision with root package name */
    public Tri f43868f;

    /* renamed from: g  reason: collision with root package name */
    public Tri f43869g;

    /* renamed from: h  reason: collision with root package name */
    public Tri f43870h;

    /* renamed from: i  reason: collision with root package name */
    public Tri f43871i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* renamed from: d.a.i0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0603a {

        /* renamed from: a  reason: collision with root package name */
        public final a f43872a = new a();

        public a a() {
            return this.f43872a;
        }

        public C0603a b(Tri tri) {
            this.f43872a.f43869g = tri;
            return this;
        }

        public C0603a c(Tri tri) {
            this.f43872a.f43868f = tri;
            return this;
        }

        public C0603a d(int i2, int i3) {
            if (i2 > 0 && i3 <= 100 && i3 >= i2) {
                this.f43872a.j = i2;
                this.f43872a.k = i3;
                return this;
            }
            throw new IllegalArgumentException("argument out of valid range!");
        }

        public C0603a e(int i2, int i3) {
            if (i2 >= 10 && i3 <= 100 && i3 >= i2 && i2 % 10 == 0 && i3 % 10 == 0) {
                this.f43872a.l = i2;
                this.f43872a.m = i3;
                return this;
            }
            throw new IllegalArgumentException("argument out of valid range!");
        }
    }

    public a() {
        Tri tri = Tri.UNDEFINED;
        this.f43868f = tri;
        this.f43869g = tri;
        this.f43870h = tri;
        this.f43871i = tri;
    }

    public Tri g() {
        return this.f43871i;
    }

    public Tri h() {
        return this.f43870h;
    }

    public int i() {
        return this.f43864b;
    }

    public int j() {
        return this.f43863a;
    }

    public String k() {
        return this.f43867e;
    }

    public Tri l() {
        return this.f43868f;
    }

    public Tri m() {
        return this.f43869g;
    }

    @Deprecated
    public int n() {
        return this.f43865c;
    }

    public int o() {
        return this.k;
    }

    public int p() {
        return this.m;
    }

    public int q() {
        return this.j;
    }

    public int r() {
        return this.l;
    }

    public String s() {
        return this.f43866d;
    }
}
