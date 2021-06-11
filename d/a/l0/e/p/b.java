package d.a.l0.e.p;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50250a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50250a == null) {
                f50250a = new a();
            }
            aVar = f50250a;
        }
        return aVar;
    }
}
