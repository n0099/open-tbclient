package d.b.g0.a.e1.d.a;
/* loaded from: classes3.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f44372e;

    /* renamed from: f  reason: collision with root package name */
    public int f44373f;

    /* renamed from: g  reason: collision with root package name */
    public int f44374g;

    /* renamed from: h  reason: collision with root package name */
    public int f44375h;
    public boolean i = false;
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
        return this.f44375h;
    }

    public int e() {
        return this.f44372e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f44372e == aVar.f44372e && this.f44373f == aVar.f44373f && this.f44375h == aVar.f44375h && this.f44374g == aVar.f44374g && this.l == aVar.l;
        }
        return false;
    }

    public int f() {
        return this.f44373f;
    }

    public int g() {
        return this.f44374g;
    }

    public boolean h() {
        return this.l;
    }

    public boolean i() {
        boolean z = false;
        return (this.i || this.f44374g >= 0) & ((this.j || this.f44375h >= 0) ? true : true);
    }

    public void j(boolean z) {
        this.l = z;
    }

    public void k(int i) {
        this.f44375h = i;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(int i) {
        this.f44372e = i;
    }

    public void n(int i) {
        this.f44373f = i;
    }

    public void o(int i) {
        this.f44374g = i;
    }

    public void p(boolean z) {
        this.i = z;
    }

    public String toString() {
        return "Position{l=" + this.f44372e + ", t=" + this.f44373f + ", w=" + this.f44374g + ", h=" + this.f44375h + ", WAuto=" + this.i + ", HAuto=" + this.j + ", fixed=" + this.l + '}';
    }

    public a(int i, int i2, int i3, int i4) {
        this.f44372e = i;
        this.f44373f = i2;
        this.f44374g = i3;
        this.f44375h = i4;
    }
}
