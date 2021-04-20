package d.b.g0.a.e1.d.a;
/* loaded from: classes2.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f44765e;

    /* renamed from: f  reason: collision with root package name */
    public int f44766f;

    /* renamed from: g  reason: collision with root package name */
    public int f44767g;

    /* renamed from: h  reason: collision with root package name */
    public int f44768h;
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
        return this.f44768h;
    }

    public int e() {
        return this.f44765e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f44765e == aVar.f44765e && this.f44766f == aVar.f44766f && this.f44768h == aVar.f44768h && this.f44767g == aVar.f44767g && this.l == aVar.l;
        }
        return false;
    }

    public int f() {
        return this.f44766f;
    }

    public int g() {
        return this.f44767g;
    }

    public boolean h() {
        return this.l;
    }

    public boolean i() {
        boolean z = false;
        return (this.i || this.f44767g >= 0) & ((this.j || this.f44768h >= 0) ? true : true);
    }

    public void j(boolean z) {
        this.l = z;
    }

    public void k(int i) {
        this.f44768h = i;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(int i) {
        this.f44765e = i;
    }

    public void n(int i) {
        this.f44766f = i;
    }

    public void o(int i) {
        this.f44767g = i;
    }

    public void p(boolean z) {
        this.i = z;
    }

    public String toString() {
        return "Position{l=" + this.f44765e + ", t=" + this.f44766f + ", w=" + this.f44767g + ", h=" + this.f44768h + ", WAuto=" + this.i + ", HAuto=" + this.j + ", fixed=" + this.l + '}';
    }

    public a(int i, int i2, int i3, int i4) {
        this.f44765e = i;
        this.f44766f = i2;
        this.f44767g = i3;
        this.f44768h = i4;
    }
}
