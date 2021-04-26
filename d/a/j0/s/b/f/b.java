package d.a.j0.s.b.f;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f59958a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f59958a == null) {
                f59958a = new a();
            }
            aVar = f59958a;
        }
        return aVar;
    }
}
