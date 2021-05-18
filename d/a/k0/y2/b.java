package d.a.k0.y2;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f63629a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f63629a == null) {
                f63629a = new a();
            }
            aVar = f63629a;
        }
        return aVar;
    }
}
