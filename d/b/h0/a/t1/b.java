package d.b.h0.a.t1;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46965a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46965a == null) {
                f46965a = new a();
            }
            aVar = f46965a;
        }
        return aVar;
    }
}
