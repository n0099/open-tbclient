package d.b.u.b.f;
/* loaded from: classes2.dex */
public class d implements Cloneable {
    public int i;
    public int j;

    /* renamed from: e  reason: collision with root package name */
    public int f64707e = 3553;

    /* renamed from: f  reason: collision with root package name */
    public int f64708f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64709g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64710h = false;
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
        return this.f64708f;
    }

    public int e() {
        return this.f64707e;
    }

    public int f() {
        return this.i;
    }

    public boolean g() {
        return this.f64708f != -1;
    }

    public void h(int i) {
        this.f64708f = i;
    }

    public String toString() {
        return "type = " + this.f64707e + " && id = " + this.f64708f + " && cameraFrame" + this.f64709g + " && frontCamera = " + this.f64710h + " && width * height = " + this.i + " * " + this.j + " && timestamp = " + this.k;
    }
}
