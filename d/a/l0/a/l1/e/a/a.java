package d.a.l0.a.l1.e.a;
/* loaded from: classes3.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f47050e;

    /* renamed from: f  reason: collision with root package name */
    public int f47051f;

    /* renamed from: g  reason: collision with root package name */
    public int f47052g;

    /* renamed from: h  reason: collision with root package name */
    public int f47053h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47054i = false;
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
        return this.f47053h;
    }

    public int e() {
        return this.f47050e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f47050e == aVar.f47050e && this.f47051f == aVar.f47051f && this.f47053h == aVar.f47053h && this.f47052g == aVar.f47052g && this.l == aVar.l;
        }
        return false;
    }

    public int f() {
        return this.f47051f;
    }

    public int g() {
        return this.f47052g;
    }

    public boolean h() {
        return this.l;
    }

    public boolean i() {
        boolean z = false;
        return (this.f47054i || this.f47052g >= 0) & ((this.j || this.f47053h >= 0) ? true : true);
    }

    public void j(boolean z) {
        this.l = z;
    }

    public void k(int i2) {
        this.f47053h = i2;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(int i2) {
        this.f47050e = i2;
    }

    public void n(int i2) {
        this.f47051f = i2;
    }

    public void o(int i2) {
        this.f47052g = i2;
    }

    public void p(boolean z) {
        this.f47054i = z;
    }

    public String toString() {
        return "Position{l=" + this.f47050e + ", t=" + this.f47051f + ", w=" + this.f47052g + ", h=" + this.f47053h + ", WAuto=" + this.f47054i + ", HAuto=" + this.j + ", fixed=" + this.l + '}';
    }

    public a(int i2, int i3, int i4, int i5) {
        this.f47050e = i2;
        this.f47051f = i3;
        this.f47052g = i4;
        this.f47053h = i5;
    }
}
