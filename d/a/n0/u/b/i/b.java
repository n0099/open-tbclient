package d.a.n0.u.b.i;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f64993a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f64993a == null) {
                f64993a = new a();
            }
            aVar = f64993a;
        }
        return aVar;
    }
}
