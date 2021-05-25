package d.a.n0.u.b.c;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f61259a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f61259a == null) {
                f61259a = new b();
            }
            bVar = f61259a;
        }
        return bVar;
    }
}
