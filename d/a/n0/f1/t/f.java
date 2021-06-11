package d.a.n0.f1.t;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f58452b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f58453a;

    public static f a() {
        if (f58452b == null) {
            synchronized (f.class) {
                if (f58452b == null) {
                    f58452b = new f();
                }
            }
        }
        return f58452b;
    }

    public boolean b() {
        return this.f58453a;
    }

    public void c(boolean z) {
        this.f58453a = z;
    }
}
