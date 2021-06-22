package d.a.o0.f1.t;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f58567b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f58568a;

    public static c a() {
        if (f58567b == null) {
            synchronized (c.class) {
                if (f58567b == null) {
                    f58567b = new c();
                }
            }
        }
        return f58567b;
    }

    public boolean b() {
        return this.f58568a;
    }

    public void c(boolean z) {
        this.f58568a = z;
    }
}
