package d.a.k0.e1.t;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f54573b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f54574a;

    public static f a() {
        if (f54573b == null) {
            synchronized (f.class) {
                if (f54573b == null) {
                    f54573b = new f();
                }
            }
        }
        return f54573b;
    }

    public boolean b() {
        return this.f54574a;
    }

    public void c(boolean z) {
        this.f54574a = z;
    }
}
