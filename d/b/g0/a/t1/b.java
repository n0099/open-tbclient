package d.b.g0.a.t1;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46243a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46243a == null) {
                f46243a = new a();
            }
            aVar = f46243a;
        }
        return aVar;
    }
}
