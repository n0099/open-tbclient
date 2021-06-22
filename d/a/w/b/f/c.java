package d.a.w.b.f;
/* loaded from: classes2.dex */
public class c implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public int f68572e;

    /* renamed from: f  reason: collision with root package name */
    public int f68573f;

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
        return this.f68573f;
    }

    public int d() {
        return this.f68572e;
    }

    public void e(int i2) {
        this.f68573f = i2;
    }

    public void f(int i2) {
        this.f68572e = i2;
    }
}
