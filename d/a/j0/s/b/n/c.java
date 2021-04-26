package d.a.j0.s.b.n;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f59999a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f59999a == null) {
                f59999a = new b();
            }
            bVar = f59999a;
        }
        return bVar;
    }
}
