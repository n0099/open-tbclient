package d.b.g0.a.e1.d.a;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f44373e;

    /* renamed from: f  reason: collision with root package name */
    public int f44374f;

    /* renamed from: g  reason: collision with root package name */
    public int f44375g;

    /* renamed from: h  reason: collision with root package name */
    public int f44376h;
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
        return this.f44376h;
    }

    public int e() {
        return this.f44373e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f44373e == aVar.f44373e && this.f44374f == aVar.f44374f && this.f44376h == aVar.f44376h && this.f44375g == aVar.f44375g && this.l == aVar.l;
        }
        return false;
    }

    public int f() {
        return this.f44374f;
    }

    public int g() {
        return this.f44375g;
    }

    public boolean h() {
        return this.l;
    }

    public boolean i() {
        boolean z = false;
        return (this.i || this.f44375g >= 0) & ((this.j || this.f44376h >= 0) ? true : true);
    }

    public void j(boolean z) {
        this.l = z;
    }

    public void k(int i) {
        this.f44376h = i;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(int i) {
        this.f44373e = i;
    }

    public void n(int i) {
        this.f44374f = i;
    }

    public void o(int i) {
        this.f44375g = i;
    }

    public void p(boolean z) {
        this.i = z;
    }

    public String toString() {
        return "Position{l=" + this.f44373e + ", t=" + this.f44374f + ", w=" + this.f44375g + ", h=" + this.f44376h + ", WAuto=" + this.i + ", HAuto=" + this.j + ", fixed=" + this.l + '}';
    }

    public a(int i, int i2, int i3, int i4) {
        this.f44373e = i;
        this.f44374f = i2;
        this.f44375g = i3;
        this.f44376h = i4;
    }
}
