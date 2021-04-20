package d.b.g0.b.m.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47836a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47836a == null) {
                f47836a = new a();
            }
            aVar = f47836a;
        }
        return aVar;
    }
}
