package d.a.h0;

import com.baidu.smartcolor.utils.Tri;
/* loaded from: classes2.dex */
public class a {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public int f39997a = 0;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public int f39998b = 0;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public int f39999c = 32;

    /* renamed from: d  reason: collision with root package name */
    public String f40000d;

    /* renamed from: e  reason: collision with root package name */
    public String f40001e;

    /* renamed from: f  reason: collision with root package name */
    public Tri f40002f;

    /* renamed from: g  reason: collision with root package name */
    public Tri f40003g;

    /* renamed from: h  reason: collision with root package name */
    public Tri f40004h;

    /* renamed from: i  reason: collision with root package name */
    public Tri f40005i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* renamed from: d.a.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0541a {

        /* renamed from: a  reason: collision with root package name */
        public final a f40006a = new a();

        public a a() {
            return this.f40006a;
        }

        public C0541a b(Tri tri) {
            this.f40006a.f40003g = tri;
            return this;
        }

        public C0541a c(Tri tri) {
            this.f40006a.f40002f = tri;
            return this;
        }

        public C0541a d(int i2, int i3) {
            if (i2 > 0 && i3 <= 100 && i3 >= i2) {
                this.f40006a.j = i2;
                this.f40006a.k = i3;
                return this;
            }
            throw new IllegalArgumentException("argument out of valid range!");
        }

        public C0541a e(int i2, int i3) {
            if (i2 >= 10 && i3 <= 100 && i3 >= i2 && i2 % 10 == 0 && i3 % 10 == 0) {
                this.f40006a.l = i2;
                this.f40006a.m = i3;
                return this;
            }
            throw new IllegalArgumentException("argument out of valid range!");
        }
    }

    public a() {
        Tri tri = Tri.UNDEFINED;
        this.f40002f = tri;
        this.f40003g = tri;
        this.f40004h = tri;
        this.f40005i = tri;
    }

    public Tri g() {
        return this.f40005i;
    }

    public Tri h() {
        return this.f40004h;
    }

    public int i() {
        return this.f39998b;
    }

    public int j() {
        return this.f39997a;
    }

    public String k() {
        return this.f40001e;
    }

    public Tri l() {
        return this.f40002f;
    }

    public Tri m() {
        return this.f40003g;
    }

    @Deprecated
    public int n() {
        return this.f39999c;
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
        return this.f40000d;
    }
}
