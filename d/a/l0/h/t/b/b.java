package d.a.l0.h.t.b;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47677a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47677a == null) {
                f47677a = new a();
            }
            aVar = f47677a;
        }
        return aVar;
    }
}
