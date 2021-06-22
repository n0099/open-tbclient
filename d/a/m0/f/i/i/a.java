package d.a.m0.f.i.i;
/* loaded from: classes3.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f50409e;

    /* renamed from: f  reason: collision with root package name */
    public int f50410f;

    /* renamed from: g  reason: collision with root package name */
    public int f50411g;

    /* renamed from: h  reason: collision with root package name */
    public int f50412h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50413i = false;
    public boolean j = false;
    public boolean k;

    public a() {
    }

    public static a b() {
        a aVar = new a();
        aVar.j(true);
        aVar.h(true);
        aVar.i(-1);
        aVar.g(-1);
        return aVar;
    }

    public int c() {
        return this.f50412h;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int d() {
        return this.f50409e;
    }

    public int e() {
        return this.f50410f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f50409e == aVar.f50409e && this.f50410f == aVar.f50410f && this.f50412h == aVar.f50412h && this.f50411g == aVar.f50411g && this.k == aVar.k;
        }
        return false;
    }

    public int f() {
        return this.f50411g;
    }

    public void g(int i2) {
        this.f50412h = i2;
    }

    public void h(boolean z) {
        this.j = z;
    }

    public void i(int i2) {
        this.f50411g = i2;
    }

    public void j(boolean z) {
        this.f50413i = z;
    }

    public String toString() {
        return "Position{l=" + this.f50409e + ", t=" + this.f50410f + ", w=" + this.f50411g + ", h=" + this.f50412h + ", WAuto=" + this.f50413i + ", HAuto=" + this.j + ", fixed=" + this.k + '}';
    }

    public a(int i2, int i3, int i4, int i5) {
        this.f50409e = i2;
        this.f50410f = i3;
        this.f50411g = i4;
        this.f50412h = i5;
    }
}
