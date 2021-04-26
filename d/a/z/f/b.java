package d.a.z.f;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f64226a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f64226a == null) {
                f64226a = new a();
            }
            aVar = f64226a;
        }
        return aVar;
    }
}
