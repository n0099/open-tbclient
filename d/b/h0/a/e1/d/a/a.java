package d.b.h0.a.e1.d.a;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f45094e;

    /* renamed from: f  reason: collision with root package name */
    public int f45095f;

    /* renamed from: g  reason: collision with root package name */
    public int f45096g;

    /* renamed from: h  reason: collision with root package name */
    public int f45097h;
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
        return this.f45097h;
    }

    public int e() {
        return this.f45094e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f45094e == aVar.f45094e && this.f45095f == aVar.f45095f && this.f45097h == aVar.f45097h && this.f45096g == aVar.f45096g && this.l == aVar.l;
        }
        return false;
    }

    public int f() {
        return this.f45095f;
    }

    public int g() {
        return this.f45096g;
    }

    public boolean h() {
        return this.l;
    }

    public boolean i() {
        boolean z = false;
        return (this.i || this.f45096g >= 0) & ((this.j || this.f45097h >= 0) ? true : true);
    }

    public void j(boolean z) {
        this.l = z;
    }

    public void k(int i) {
        this.f45097h = i;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(int i) {
        this.f45094e = i;
    }

    public void n(int i) {
        this.f45095f = i;
    }

    public void o(int i) {
        this.f45096g = i;
    }

    public void p(boolean z) {
        this.i = z;
    }

    public String toString() {
        return "Position{l=" + this.f45094e + ", t=" + this.f45095f + ", w=" + this.f45096g + ", h=" + this.f45097h + ", WAuto=" + this.i + ", HAuto=" + this.j + ", fixed=" + this.l + '}';
    }

    public a(int i, int i2, int i3, int i4) {
        this.f45094e = i;
        this.f45095f = i2;
        this.f45096g = i3;
        this.f45097h = i4;
    }
}
