package d.a.l0.h.m0;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f51137a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f51137a == null) {
                f51137a = new a();
            }
            aVar = f51137a;
        }
        return aVar;
    }
}
