package d.a.l0.h.o;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47507a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47507a == null) {
                f47507a = new a();
            }
            aVar = f47507a;
        }
        return aVar;
    }
}
