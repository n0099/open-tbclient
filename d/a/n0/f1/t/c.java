package d.a.n0.f1.t;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f54753b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f54754a;

    public static c a() {
        if (f54753b == null) {
            synchronized (c.class) {
                if (f54753b == null) {
                    f54753b = new c();
                }
            }
        }
        return f54753b;
    }

    public boolean b() {
        return this.f54754a;
    }

    public void c(boolean z) {
        this.f54754a = z;
    }
}
