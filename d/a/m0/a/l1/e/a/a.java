package d.a.m0.a.l1.e.a;
/* loaded from: classes3.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f47158e;

    /* renamed from: f  reason: collision with root package name */
    public int f47159f;

    /* renamed from: g  reason: collision with root package name */
    public int f47160g;

    /* renamed from: h  reason: collision with root package name */
    public int f47161h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47162i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l;

    public a() {
    }

    public static a b() {
        a aVar = new a();
        aVar.p(true);
        aVar.l(true);
        aVar.o(-1);
        aVar.k(-1);
        return aVar;
    }

    public boolean c(a aVar) {
        return !equals(aVar) || this.k;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int d() {
        return this.f47161h;
    }

    public int e() {
        return this.f47158e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f47158e == aVar.f47158e && this.f47159f == aVar.f47159f && this.f47161h == aVar.f47161h && this.f47160g == aVar.f47160g && this.l == aVar.l;
        }
        return false;
    }

    public int f() {
        return this.f47159f;
    }

    public int g() {
        return this.f47160g;
    }

    public boolean h() {
        return this.l;
    }

    public boolean i() {
        boolean z = false;
        return (this.f47162i || this.f47160g >= 0) & ((this.j || this.f47161h >= 0) ? true : true);
    }

    public void j(boolean z) {
        this.l = z;
    }

    public void k(int i2) {
        this.f47161h = i2;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(int i2) {
        this.f47158e = i2;
    }

    public void n(int i2) {
        this.f47159f = i2;
    }

    public void o(int i2) {
        this.f47160g = i2;
    }

    public void p(boolean z) {
        this.f47162i = z;
    }

    public String toString() {
        return "Position{l=" + this.f47158e + ", t=" + this.f47159f + ", w=" + this.f47160g + ", h=" + this.f47161h + ", WAuto=" + this.f47162i + ", HAuto=" + this.j + ", fixed=" + this.l + '}';
    }

    public a(int i2, int i3, int i4, int i5) {
        this.f47158e = i2;
        this.f47159f = i3;
        this.f47160g = i4;
        this.f47161h = i5;
    }
}
