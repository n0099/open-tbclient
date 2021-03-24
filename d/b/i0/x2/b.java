package d.b.i0.x2;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f62515a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f62515a == null) {
                f62515a = new a();
            }
            aVar = f62515a;
        }
        return aVar;
    }
}
