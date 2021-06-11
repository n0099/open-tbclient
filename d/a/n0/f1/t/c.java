package d.a.n0.f1.t;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f58442b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f58443a;

    public static c a() {
        if (f58442b == null) {
            synchronized (c.class) {
                if (f58442b == null) {
                    f58442b = new c();
                }
            }
        }
        return f58442b;
    }

    public boolean b() {
        return this.f58443a;
    }

    public void c(boolean z) {
        this.f58443a = z;
    }
}
