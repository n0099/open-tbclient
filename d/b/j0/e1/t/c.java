package d.b.j0.e1.t;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f55988b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f55989a;

    public static c a() {
        if (f55988b == null) {
            synchronized (c.class) {
                if (f55988b == null) {
                    f55988b = new c();
                }
            }
        }
        return f55988b;
    }

    public boolean b() {
        return this.f55989a;
    }

    public void c(boolean z) {
        this.f55989a = z;
    }
}
