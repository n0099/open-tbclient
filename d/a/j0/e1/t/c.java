package d.a.j0.e1.t;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f53856b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f53857a;

    public static c a() {
        if (f53856b == null) {
            synchronized (c.class) {
                if (f53856b == null) {
                    f53856b = new c();
                }
            }
        }
        return f53856b;
    }

    public boolean b() {
        return this.f53857a;
    }

    public void c(boolean z) {
        this.f53857a = z;
    }
}
