package d.a.n0.u.b.f;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f64982a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f64982a == null) {
                f64982a = new b();
            }
            bVar = f64982a;
        }
        return bVar;
    }
}
