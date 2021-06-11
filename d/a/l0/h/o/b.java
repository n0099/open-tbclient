package d.a.l0.h.o;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f51181a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f51181a == null) {
                f51181a = new a();
            }
            aVar = f51181a;
        }
        return aVar;
    }
}
