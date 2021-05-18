package d.a.k0.s.b.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60690a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60690a == null) {
                f60690a = new a();
            }
            aVar = f60690a;
        }
        return aVar;
    }
}
