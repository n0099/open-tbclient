package d.b.g0.a.h1;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f44613a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f44613a == null) {
                f44613a = new a();
            }
            aVar = f44613a;
        }
        return aVar;
    }
}
