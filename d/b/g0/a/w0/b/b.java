package d.b.g0.a.w0.b;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46858a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46858a == null) {
                f46858a = new a();
            }
            aVar = f46858a;
        }
        return aVar;
    }
}
