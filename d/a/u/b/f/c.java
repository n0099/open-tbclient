package d.a.u.b.f;
/* loaded from: classes2.dex */
public class c implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f64697e;

    /* renamed from: f  reason: collision with root package name */
    public int f64698f;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public int c() {
        return this.f64698f;
    }

    public int d() {
        return this.f64697e;
    }

    public void e(int i2) {
        this.f64698f = i2;
    }

    public void f(int i2) {
        this.f64697e = i2;
    }
}
