package d.a.l0.e.r;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f50294a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f50294a == null) {
                f50294a = new a();
            }
            aVar = f50294a;
        }
        return aVar;
    }
}
