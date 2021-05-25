package d.a.w.b.f;
/* loaded from: classes2.dex */
public class c implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f64750e;

    /* renamed from: f  reason: collision with root package name */
    public int f64751f;

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
        return this.f64751f;
    }

    public int d() {
        return this.f64750e;
    }

    public void e(int i2) {
        this.f64751f = i2;
    }

    public void f(int i2) {
        this.f64750e = i2;
    }
}
