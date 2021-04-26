package d.a.h0.a.e1.d.a;
/* loaded from: classes3.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f42403e;

    /* renamed from: f  reason: collision with root package name */
    public int f42404f;

    /* renamed from: g  reason: collision with root package name */
    public int f42405g;

    /* renamed from: h  reason: collision with root package name */
    public int f42406h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42407i = false;
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
        return this.f42406h;
    }

    public int e() {
        return this.f42403e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f42403e == aVar.f42403e && this.f42404f == aVar.f42404f && this.f42406h == aVar.f42406h && this.f42405g == aVar.f42405g && this.l == aVar.l;
        }
        return false;
    }

    public int f() {
        return this.f42404f;
    }

    public int g() {
        return this.f42405g;
    }

    public boolean h() {
        return this.l;
    }

    public boolean i() {
        boolean z = false;
        return (this.f42407i || this.f42405g >= 0) & ((this.j || this.f42406h >= 0) ? true : true);
    }

    public void j(boolean z) {
        this.l = z;
    }

    public void k(int i2) {
        this.f42406h = i2;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(int i2) {
        this.f42403e = i2;
    }

    public void n(int i2) {
        this.f42404f = i2;
    }

    public void o(int i2) {
        this.f42405g = i2;
    }

    public void p(boolean z) {
        this.f42407i = z;
    }

    public String toString() {
        return "Position{l=" + this.f42403e + ", t=" + this.f42404f + ", w=" + this.f42405g + ", h=" + this.f42406h + ", WAuto=" + this.f42407i + ", HAuto=" + this.j + ", fixed=" + this.l + '}';
    }

    public a(int i2, int i3, int i4, int i5) {
        this.f42403e = i2;
        this.f42404f = i3;
        this.f42405g = i4;
        this.f42406h = i5;
    }
}
