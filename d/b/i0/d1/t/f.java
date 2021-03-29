package d.b.i0.d1.t;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f54055b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f54056a;

    public static f a() {
        if (f54055b == null) {
            synchronized (f.class) {
                if (f54055b == null) {
                    f54055b = new f();
                }
            }
        }
        return f54055b;
    }

    public boolean b() {
        return this.f54056a;
    }

    public void c(boolean z) {
        this.f54056a = z;
    }
}
