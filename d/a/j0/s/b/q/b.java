package d.a.j0.s.b.q;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60002a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60002a == null) {
                f60002a = new a();
            }
            aVar = f60002a;
        }
        return aVar;
    }
}
