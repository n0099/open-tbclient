package d.a.j0.s.b.i;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f59973a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f59973a == null) {
                f59973a = new b();
            }
            bVar = f59973a;
        }
        return bVar;
    }
}
