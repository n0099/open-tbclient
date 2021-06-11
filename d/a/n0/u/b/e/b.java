package d.a.n0.u.b.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f64972a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f64972a == null) {
                f64972a = new a();
            }
            aVar = f64972a;
        }
        return aVar;
    }
}
