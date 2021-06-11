package d.a.n0.u.b.d;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f64969a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f64969a == null) {
                f64969a = new a();
            }
            aVar = f64969a;
        }
        return aVar;
    }
}
