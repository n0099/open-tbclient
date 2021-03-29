package d.b.i0.x2;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f62516a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f62516a == null) {
                f62516a = new a();
            }
            aVar = f62516a;
        }
        return aVar;
    }
}
