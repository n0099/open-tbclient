package d.a.w.b.f;
/* loaded from: classes2.dex */
public class d implements Cloneable {

    /* renamed from: i  reason: collision with root package name */
    public int f64756i;
    public int j;

    /* renamed from: e  reason: collision with root package name */
    public int f64752e = 3553;

    /* renamed from: f  reason: collision with root package name */
    public int f64753f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64754g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64755h = false;
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
        return this.f64753f;
    }

    public int e() {
        return this.f64752e;
    }

    public int f() {
        return this.f64756i;
    }

    public boolean g() {
        return this.f64753f != -1;
    }

    public void h(int i2) {
        this.f64753f = i2;
    }

    public String toString() {
        return "type = " + this.f64752e + " && id = " + this.f64753f + " && cameraFrame" + this.f64754g + " && frontCamera = " + this.f64755h + " && width * height = " + this.f64756i + " * " + this.j + " && timestamp = " + this.k;
    }
}
