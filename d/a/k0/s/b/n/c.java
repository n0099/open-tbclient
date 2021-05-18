package d.a.k0.s.b.n;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f60733a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f60733a == null) {
                f60733a = new b();
            }
            bVar = f60733a;
        }
        return bVar;
    }
}
