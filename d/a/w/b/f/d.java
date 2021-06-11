package d.a.w.b.f;
/* loaded from: classes2.dex */
public class d implements Cloneable {

    /* renamed from: i  reason: collision with root package name */
    public int f68474i;
    public int j;

    /* renamed from: e  reason: collision with root package name */
    public int f68470e = 3553;

    /* renamed from: f  reason: collision with root package name */
    public int f68471f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68472g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68473h = false;
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
        return this.f68471f;
    }

    public int e() {
        return this.f68470e;
    }

    public int f() {
        return this.f68474i;
    }

    public boolean g() {
        return this.f68471f != -1;
    }

    public void h(int i2) {
        this.f68471f = i2;
    }

    public String toString() {
        return "type = " + this.f68470e + " && id = " + this.f68471f + " && cameraFrame" + this.f68472g + " && frontCamera = " + this.f68473h + " && width * height = " + this.f68474i + " * " + this.j + " && timestamp = " + this.k;
    }
}
