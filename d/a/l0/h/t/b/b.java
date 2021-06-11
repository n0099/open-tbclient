package d.a.l0.h.t.b;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f51351a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f51351a == null) {
                f51351a = new a();
            }
            aVar = f51351a;
        }
        return aVar;
    }
}
