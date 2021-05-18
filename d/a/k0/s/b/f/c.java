package d.a.k0.s.b.f;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f60700a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f60700a == null) {
                f60700a = new b();
            }
            bVar = f60700a;
        }
        return bVar;
    }
}
