package d.b.i0.d1.t;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f54054b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f54055a;

    public static f a() {
        if (f54054b == null) {
            synchronized (f.class) {
                if (f54054b == null) {
                    f54054b = new f();
                }
            }
        }
        return f54054b;
    }

    public boolean b() {
        return this.f54055a;
    }

    public void c(boolean z) {
        this.f54055a = z;
    }
}
