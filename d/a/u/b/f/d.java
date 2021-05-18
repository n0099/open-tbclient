package d.a.u.b.f;
/* loaded from: classes2.dex */
public class d implements Cloneable {

    /* renamed from: i  reason: collision with root package name */
    public int f64703i;
    public int j;

    /* renamed from: e  reason: collision with root package name */
    public int f64699e = 3553;

    /* renamed from: f  reason: collision with root package name */
    public int f64700f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64701g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64702h = false;
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
        return this.f64700f;
    }

    public int e() {
        return this.f64699e;
    }

    public int f() {
        return this.f64703i;
    }

    public boolean g() {
        return this.f64700f != -1;
    }

    public void h(int i2) {
        this.f64700f = i2;
    }

    public String toString() {
        return "type = " + this.f64699e + " && id = " + this.f64700f + " && cameraFrame" + this.f64701g + " && frontCamera = " + this.f64702h + " && width * height = " + this.f64703i + " * " + this.j + " && timestamp = " + this.k;
    }
}
