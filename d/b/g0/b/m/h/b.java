package d.b.g0.b.m.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47444a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47444a == null) {
                f47444a = new a();
            }
            aVar = f47444a;
        }
        return aVar;
    }
}
