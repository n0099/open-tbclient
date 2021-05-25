package d.a.l0.e.m.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46550a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46550a == null) {
                f46550a = new a();
            }
            aVar = f46550a;
        }
        return aVar;
    }
}
