package d.a.b0.f;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f42051a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f42051a == null) {
                f42051a = new a();
            }
            aVar = f42051a;
        }
        return aVar;
    }
}
