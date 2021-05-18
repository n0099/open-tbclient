package d.a.i0.h.o;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47331a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47331a == null) {
                f47331a = new a();
            }
            aVar = f47331a;
        }
        return aVar;
    }
}
