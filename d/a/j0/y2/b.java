package d.a.j0.y2;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f62905a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f62905a == null) {
                f62905a = new a();
            }
            aVar = f62905a;
        }
        return aVar;
    }
}
