package d.b.y.f;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f65607a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f65607a == null) {
                f65607a = new a();
            }
            aVar = f65607a;
        }
        return aVar;
    }
}
