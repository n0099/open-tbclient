package d.b.i0.d1.t;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f54045b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f54046a;

    public static c a() {
        if (f54045b == null) {
            synchronized (c.class) {
                if (f54045b == null) {
                    f54045b = new c();
                }
            }
        }
        return f54045b;
    }

    public boolean b() {
        return this.f54046a;
    }

    public void c(boolean z) {
        this.f54046a = z;
    }
}
