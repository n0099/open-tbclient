package d.b.j0.s.b.g.a;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61805a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61805a == null) {
                f61805a = new a();
            }
            aVar = f61805a;
        }
        return aVar;
    }
}
