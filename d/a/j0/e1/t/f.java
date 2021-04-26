package d.a.j0.e1.t;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static volatile f f53866b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f53867a;

    public static f a() {
        if (f53866b == null) {
            synchronized (f.class) {
                if (f53866b == null) {
                    f53866b = new f();
                }
            }
        }
        return f53866b;
    }

    public boolean b() {
        return this.f53867a;
    }

    public void c(boolean z) {
        this.f53867a = z;
    }
}
