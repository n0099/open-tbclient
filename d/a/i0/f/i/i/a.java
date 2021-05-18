package d.a.i0.f.i.i;
/* loaded from: classes3.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f46451e;

    /* renamed from: f  reason: collision with root package name */
    public int f46452f;

    /* renamed from: g  reason: collision with root package name */
    public int f46453g;

    /* renamed from: h  reason: collision with root package name */
    public int f46454h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46455i = false;
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
        return this.f46454h;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int d() {
        return this.f46451e;
    }

    public int e() {
        return this.f46452f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f46451e == aVar.f46451e && this.f46452f == aVar.f46452f && this.f46454h == aVar.f46454h && this.f46453g == aVar.f46453g && this.k == aVar.k;
        }
        return false;
    }

    public int f() {
        return this.f46453g;
    }

    public void g(int i2) {
        this.f46454h = i2;
    }

    public void h(boolean z) {
        this.j = z;
    }

    public void i(int i2) {
        this.f46453g = i2;
    }

    public void j(boolean z) {
        this.f46455i = z;
    }

    public String toString() {
        return "Position{l=" + this.f46451e + ", t=" + this.f46452f + ", w=" + this.f46453g + ", h=" + this.f46454h + ", WAuto=" + this.f46455i + ", HAuto=" + this.j + ", fixed=" + this.k + '}';
    }

    public a(int i2, int i3, int i4, int i5) {
        this.f46451e = i2;
        this.f46452f = i3;
        this.f46453g = i4;
        this.f46454h = i5;
    }
}
