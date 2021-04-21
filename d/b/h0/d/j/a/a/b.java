package d.b.h0.d.j.a.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f48244a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f48244a == null) {
                f48244a = new a();
            }
            aVar = f48244a;
        }
        return aVar;
    }
}
