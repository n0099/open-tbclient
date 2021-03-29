package d.b.g0.a.t1;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46244a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46244a == null) {
                f46244a = new a();
            }
            aVar = f46244a;
        }
        return aVar;
    }
}
