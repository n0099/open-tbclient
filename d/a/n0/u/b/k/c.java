package d.a.n0.u.b.k;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f61299a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f61299a == null) {
                f61299a = new b();
            }
            bVar = f61299a;
        }
        return bVar;
    }
}
