package d.b.i0.d1.t;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f54044b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f54045a;

    public static c a() {
        if (f54044b == null) {
            synchronized (c.class) {
                if (f54044b == null) {
                    f54044b = new c();
                }
            }
        }
        return f54044b;
    }

    public boolean b() {
        return this.f54045a;
    }

    public void c(boolean z) {
        this.f54045a = z;
    }
}
