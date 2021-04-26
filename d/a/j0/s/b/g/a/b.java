package d.a.j0.s.b.g.a;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f59963a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f59963a == null) {
                f59963a = new a();
            }
            aVar = f59963a;
        }
        return aVar;
    }
}
