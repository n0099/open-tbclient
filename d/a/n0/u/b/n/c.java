package d.a.n0.u.b.n;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f61302a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f61302a == null) {
                f61302a = new b();
            }
            bVar = f61302a;
        }
        return bVar;
    }
}
