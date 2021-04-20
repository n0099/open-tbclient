package d.b.i0.e1.t;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f55567b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f55568a;

    public static c a() {
        if (f55567b == null) {
            synchronized (c.class) {
                if (f55567b == null) {
                    f55567b = new c();
                }
            }
        }
        return f55567b;
    }

    public boolean b() {
        return this.f55568a;
    }

    public void c(boolean z) {
        this.f55568a = z;
    }
}
