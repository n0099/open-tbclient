package d.a.l0.f.i.i;
/* loaded from: classes3.dex */
public class a implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f46627e;

    /* renamed from: f  reason: collision with root package name */
    public int f46628f;

    /* renamed from: g  reason: collision with root package name */
    public int f46629g;

    /* renamed from: h  reason: collision with root package name */
    public int f46630h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f46631i = false;
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
        return this.f46630h;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int d() {
        return this.f46627e;
    }

    public int e() {
        return this.f46628f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f46627e == aVar.f46627e && this.f46628f == aVar.f46628f && this.f46630h == aVar.f46630h && this.f46629g == aVar.f46629g && this.k == aVar.k;
        }
        return false;
    }

    public int f() {
        return this.f46629g;
    }

    public void g(int i2) {
        this.f46630h = i2;
    }

    public void h(boolean z) {
        this.j = z;
    }

    public void i(int i2) {
        this.f46629g = i2;
    }

    public void j(boolean z) {
        this.f46631i = z;
    }

    public String toString() {
        return "Position{l=" + this.f46627e + ", t=" + this.f46628f + ", w=" + this.f46629g + ", h=" + this.f46630h + ", WAuto=" + this.f46631i + ", HAuto=" + this.j + ", fixed=" + this.k + '}';
    }

    public a(int i2, int i3, int i4, int i5) {
        this.f46627e = i2;
        this.f46628f = i3;
        this.f46629g = i4;
        this.f46630h = i5;
    }
}
