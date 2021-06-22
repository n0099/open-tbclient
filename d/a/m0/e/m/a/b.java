package d.a.m0.e.m.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50332a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50332a == null) {
                f50332a = new a();
            }
            aVar = f50332a;
        }
        return aVar;
    }
}
