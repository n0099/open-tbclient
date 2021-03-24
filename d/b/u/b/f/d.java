package d.b.u.b.f;
/* loaded from: classes2.dex */
public class d implements Cloneable {
    public int i;
    public int j;

    /* renamed from: e  reason: collision with root package name */
    public int f64706e = 3553;

    /* renamed from: f  reason: collision with root package name */
    public int f64707f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64708g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64709h = false;
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
        return this.f64707f;
    }

    public int e() {
        return this.f64706e;
    }

    public int f() {
        return this.i;
    }

    public boolean g() {
        return this.f64707f != -1;
    }

    public void h(int i) {
        this.f64707f = i;
    }

    public String toString() {
        return "type = " + this.f64706e + " && id = " + this.f64707f + " && cameraFrame" + this.f64708g + " && frontCamera = " + this.f64709h + " && width * height = " + this.i + " * " + this.j + " && timestamp = " + this.k;
    }
}
