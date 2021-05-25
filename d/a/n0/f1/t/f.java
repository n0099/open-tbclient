package d.a.n0.f1.t;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f54763b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f54764a;

    public static f a() {
        if (f54763b == null) {
            synchronized (f.class) {
                if (f54763b == null) {
                    f54763b = new f();
                }
            }
        }
        return f54763b;
    }

    public boolean b() {
        return this.f54764a;
    }

    public void c(boolean z) {
        this.f54764a = z;
    }
}
