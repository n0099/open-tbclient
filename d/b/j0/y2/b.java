package d.b.j0.y2;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f64622a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f64622a == null) {
                f64622a = new a();
            }
            aVar = f64622a;
        }
        return aVar;
    }
}
