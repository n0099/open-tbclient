package d.a.n0.u.b.f;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f61273a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f61273a == null) {
                f61273a = new b();
            }
            bVar = f61273a;
        }
        return bVar;
    }
}
