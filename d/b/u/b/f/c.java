package d.b.u.b.f;
/* loaded from: classes2.dex */
public class c implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f65663e;

    /* renamed from: f  reason: collision with root package name */
    public int f65664f;

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
        return this.f65664f;
    }

    public int d() {
        return this.f65663e;
    }

    public void e(int i) {
        this.f65664f = i;
    }

    public void f(int i) {
        this.f65663e = i;
    }
}
