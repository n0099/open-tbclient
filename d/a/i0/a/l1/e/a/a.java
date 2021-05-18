package d.a.i0.a.l1.e.a;
/* loaded from: classes3.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f43200e;

    /* renamed from: f  reason: collision with root package name */
    public int f43201f;

    /* renamed from: g  reason: collision with root package name */
    public int f43202g;

    /* renamed from: h  reason: collision with root package name */
    public int f43203h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43204i = false;
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
        return this.f43203h;
    }

    public int e() {
        return this.f43200e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f43200e == aVar.f43200e && this.f43201f == aVar.f43201f && this.f43203h == aVar.f43203h && this.f43202g == aVar.f43202g && this.l == aVar.l;
        }
        return false;
    }

    public int f() {
        return this.f43201f;
    }

    public int g() {
        return this.f43202g;
    }

    public boolean h() {
        return this.l;
    }

    public boolean i() {
        boolean z = false;
        return (this.f43204i || this.f43202g >= 0) & ((this.j || this.f43203h >= 0) ? true : true);
    }

    public void j(boolean z) {
        this.l = z;
    }

    public void k(int i2) {
        this.f43203h = i2;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(int i2) {
        this.f43200e = i2;
    }

    public void n(int i2) {
        this.f43201f = i2;
    }

    public void o(int i2) {
        this.f43202g = i2;
    }

    public void p(boolean z) {
        this.f43204i = z;
    }

    public String toString() {
        return "Position{l=" + this.f43200e + ", t=" + this.f43201f + ", w=" + this.f43202g + ", h=" + this.f43203h + ", WAuto=" + this.f43204i + ", HAuto=" + this.j + ", fixed=" + this.l + '}';
    }

    public a(int i2, int i3, int i4, int i5) {
        this.f43200e = i2;
        this.f43201f = i3;
        this.f43202g = i4;
        this.f43203h = i5;
    }
}
