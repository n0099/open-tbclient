package d.b.j0.s.b.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61787a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61787a == null) {
                f61787a = new a();
            }
            aVar = f61787a;
        }
        return aVar;
    }
}
