package d.b.t.b.f;
/* loaded from: classes2.dex */
public class d implements Cloneable {
    public int i;
    public int j;

    /* renamed from: e  reason: collision with root package name */
    public int f65401e = 3553;

    /* renamed from: f  reason: collision with root package name */
    public int f65402f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65403g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f65404h = false;
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
        return this.f65402f;
    }

    public int e() {
        return this.f65401e;
    }

    public int f() {
        return this.i;
    }

    public boolean g() {
        return this.f65402f != -1;
    }

    public void h(int i) {
        this.f65402f = i;
    }

    public String toString() {
        return "type = " + this.f65401e + " && id = " + this.f65402f + " && cameraFrame" + this.f65403g + " && frontCamera = " + this.f65404h + " && width * height = " + this.i + " * " + this.j + " && timestamp = " + this.k;
    }
}
