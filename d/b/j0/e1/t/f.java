package d.b.j0.e1.t;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f55998b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f55999a;

    public static f a() {
        if (f55998b == null) {
            synchronized (f.class) {
                if (f55998b == null) {
                    f55998b = new f();
                }
            }
        }
        return f55998b;
    }

    public boolean b() {
        return this.f55999a;
    }

    public void c(boolean z) {
        this.f55999a = z;
    }
}
