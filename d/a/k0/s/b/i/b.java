package d.a.k0.s.b.i;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60711a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60711a == null) {
                f60711a = new a();
            }
            aVar = f60711a;
        }
        return aVar;
    }
}
