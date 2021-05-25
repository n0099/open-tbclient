package d.a.b0.f;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f38295a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f38295a == null) {
                f38295a = new a();
            }
            aVar = f38295a;
        }
        return aVar;
    }
}
