package d.b.i0.y2;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f64201a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f64201a == null) {
                f64201a = new a();
            }
            aVar = f64201a;
        }
        return aVar;
    }
}
