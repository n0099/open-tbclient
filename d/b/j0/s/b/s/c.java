package d.b.j0.s.b.s;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f61854a;

    public static synchronized b a() {
        b bVar;
        synchronized (c.class) {
            if (f61854a == null) {
                f61854a = new b();
            }
            bVar = f61854a;
        }
        return bVar;
    }
}
