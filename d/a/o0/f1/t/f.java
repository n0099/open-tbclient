package d.a.o0.f1.t;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f58577b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f58578a;

    public static f a() {
        if (f58577b == null) {
            synchronized (f.class) {
                if (f58577b == null) {
                    f58577b = new f();
                }
            }
        }
        return f58577b;
    }

    public boolean b() {
        return this.f58578a;
    }

    public void c(boolean z) {
        this.f58578a = z;
    }
}
