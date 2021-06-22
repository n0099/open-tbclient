package d.a.w.b.f;
/* loaded from: classes2.dex */
public class d implements Cloneable {

    /* renamed from: i  reason: collision with root package name */
    public int f68578i;
    public int j;

    /* renamed from: e  reason: collision with root package name */
    public int f68574e = 3553;

    /* renamed from: f  reason: collision with root package name */
    public int f68575f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68576g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68577h = false;
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
        return this.f68575f;
    }

    public int e() {
        return this.f68574e;
    }

    public int f() {
        return this.f68578i;
    }

    public boolean g() {
        return this.f68575f != -1;
    }

    public void h(int i2) {
        this.f68575f = i2;
    }

    public String toString() {
        return "type = " + this.f68574e + " && id = " + this.f68575f + " && cameraFrame" + this.f68576g + " && frontCamera = " + this.f68577h + " && width * height = " + this.f68578i + " * " + this.j + " && timestamp = " + this.k;
    }
}
