package d.a.h0;

import com.baidu.smartcolor.utils.Tri;
/* loaded from: classes2.dex */
public class a {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public int f43678a = 0;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public int f43679b = 0;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public int f43680c = 32;

    /* renamed from: d  reason: collision with root package name */
    public String f43681d;

    /* renamed from: e  reason: collision with root package name */
    public String f43682e;

    /* renamed from: f  reason: collision with root package name */
    public Tri f43683f;

    /* renamed from: g  reason: collision with root package name */
    public Tri f43684g;

    /* renamed from: h  reason: collision with root package name */
    public Tri f43685h;

    /* renamed from: i  reason: collision with root package name */
    public Tri f43686i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* renamed from: d.a.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0597a {

        /* renamed from: a  reason: collision with root package name */
        public final a f43687a = new a();

        public a a() {
            return this.f43687a;
        }

        public C0597a b(Tri tri) {
            this.f43687a.f43684g = tri;
            return this;
        }

        public C0597a c(Tri tri) {
            this.f43687a.f43683f = tri;
            return this;
        }

        public C0597a d(int i2, int i3) {
            if (i2 > 0 && i3 <= 100 && i3 >= i2) {
                this.f43687a.j = i2;
                this.f43687a.k = i3;
                return this;
            }
            throw new IllegalArgumentException("argument out of valid range!");
        }

        public C0597a e(int i2, int i3) {
            if (i2 >= 10 && i3 <= 100 && i3 >= i2 && i2 % 10 == 0 && i3 % 10 == 0) {
                this.f43687a.l = i2;
                this.f43687a.m = i3;
                return this;
            }
            throw new IllegalArgumentException("argument out of valid range!");
        }
    }

    public a() {
        Tri tri = Tri.UNDEFINED;
        this.f43683f = tri;
        this.f43684g = tri;
        this.f43685h = tri;
        this.f43686i = tri;
    }

    public Tri g() {
        return this.f43686i;
    }

    public Tri h() {
        return this.f43685h;
    }

    public int i() {
        return this.f43679b;
    }

    public int j() {
        return this.f43678a;
    }

    public String k() {
        return this.f43682e;
    }

    public Tri l() {
        return this.f43683f;
    }

    public Tri m() {
        return this.f43684g;
    }

    @Deprecated
    public int n() {
        return this.f43680c;
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
        return this.f43681d;
    }
}
