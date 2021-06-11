package d.a.w.b.f;
/* loaded from: classes2.dex */
public class c implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f68468e;

    /* renamed from: f  reason: collision with root package name */
    public int f68469f;

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
        return this.f68469f;
    }

    public int d() {
        return this.f68468e;
    }

    public void e(int i2) {
        this.f68469f = i2;
    }

    public void f(int i2) {
        this.f68468e = i2;
    }
}
