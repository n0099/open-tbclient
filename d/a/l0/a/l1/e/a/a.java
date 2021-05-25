package d.a.l0.a.l1.e.a;
/* loaded from: classes3.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f43374e;

    /* renamed from: f  reason: collision with root package name */
    public int f43375f;

    /* renamed from: g  reason: collision with root package name */
    public int f43376g;

    /* renamed from: h  reason: collision with root package name */
    public int f43377h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43378i = false;
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
        return this.f43377h;
    }

    public int e() {
        return this.f43374e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f43374e == aVar.f43374e && this.f43375f == aVar.f43375f && this.f43377h == aVar.f43377h && this.f43376g == aVar.f43376g && this.l == aVar.l;
        }
        return false;
    }

    public int f() {
        return this.f43375f;
    }

    public int g() {
        return this.f43376g;
    }

    public boolean h() {
        return this.l;
    }

    public boolean i() {
        boolean z = false;
        return (this.f43378i || this.f43376g >= 0) & ((this.j || this.f43377h >= 0) ? true : true);
    }

    public void j(boolean z) {
        this.l = z;
    }

    public void k(int i2) {
        this.f43377h = i2;
    }

    public void l(boolean z) {
        this.j = z;
    }

    public void m(int i2) {
        this.f43374e = i2;
    }

    public void n(int i2) {
        this.f43375f = i2;
    }

    public void o(int i2) {
        this.f43376g = i2;
    }

    public void p(boolean z) {
        this.f43378i = z;
    }

    public String toString() {
        return "Position{l=" + this.f43374e + ", t=" + this.f43375f + ", w=" + this.f43376g + ", h=" + this.f43377h + ", WAuto=" + this.f43378i + ", HAuto=" + this.j + ", fixed=" + this.l + '}';
    }

    public a(int i2, int i3, int i4, int i5) {
        this.f43374e = i2;
        this.f43375f = i3;
        this.f43376g = i4;
        this.f43377h = i5;
    }
}
