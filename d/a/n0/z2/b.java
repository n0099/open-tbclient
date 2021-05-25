package d.a.n0.z2;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f63793a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f63793a == null) {
                f63793a = new a();
            }
            aVar = f63793a;
        }
        return aVar;
    }
}
