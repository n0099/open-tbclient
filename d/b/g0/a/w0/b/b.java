package d.b.g0.a.w0.b;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47251a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47251a == null) {
                f47251a = new a();
            }
            aVar = f47251a;
        }
        return aVar;
    }
}
