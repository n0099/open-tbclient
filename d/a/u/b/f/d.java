package d.a.u.b.f;
/* loaded from: classes2.dex */
public class d implements Cloneable {

    /* renamed from: i  reason: collision with root package name */
    public int f64016i;
    public int j;

    /* renamed from: e  reason: collision with root package name */
    public int f64012e = 3553;

    /* renamed from: f  reason: collision with root package name */
    public int f64013f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64014g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64015h = false;
    public long k = 0;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public int c() {
        return this.j;
    }

    public int d() {
        return this.f64013f;
    }

    public int e() {
        return this.f64012e;
    }

    public int f() {
        return this.f64016i;
    }

    public boolean g() {
        return this.f64013f != -1;
    }

    public void h(int i2) {
        this.f64013f = i2;
    }

    public String toString() {
        return "type = " + this.f64012e + " && id = " + this.f64013f + " && cameraFrame" + this.f64014g + " && frontCamera = " + this.f64015h + " && width * height = " + this.f64016i + " * " + this.j + " && timestamp = " + this.k;
    }
}
