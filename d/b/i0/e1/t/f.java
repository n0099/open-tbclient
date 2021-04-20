package d.b.i0.e1.t;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f55577b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f55578a;

    public static f a() {
        if (f55577b == null) {
            synchronized (f.class) {
                if (f55577b == null) {
                    f55577b = new f();
                }
            }
        }
        return f55577b;
    }

    public boolean b() {
        return this.f55578a;
    }

    public void c(boolean z) {
        this.f55578a = z;
    }
}
