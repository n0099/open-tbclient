package d.b.u.b.f;
/* loaded from: classes2.dex */
public class c implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f64704e;

    /* renamed from: f  reason: collision with root package name */
    public int f64705f;

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
        return this.f64705f;
    }

    public int d() {
        return this.f64704e;
    }

    public void e(int i) {
        this.f64705f = i;
    }

    public void f(int i) {
        this.f64704e = i;
    }
}
