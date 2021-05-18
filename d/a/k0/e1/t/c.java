package d.a.k0.e1.t;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f54563b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f54564a;

    public static c a() {
        if (f54563b == null) {
            synchronized (c.class) {
                if (f54563b == null) {
                    f54563b = new c();
                }
            }
        }
        return f54563b;
    }

    public boolean b() {
        return this.f54564a;
    }

    public void c(boolean z) {
        this.f54564a = z;
    }
}
