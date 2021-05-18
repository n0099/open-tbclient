package d.a.k0.s.b.k;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f60730a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f60730a == null) {
                f60730a = new b();
            }
            bVar = f60730a;
        }
        return bVar;
    }
}
