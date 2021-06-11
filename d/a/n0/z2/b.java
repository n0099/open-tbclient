package d.a.n0.z2;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f67511a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f67511a == null) {
                f67511a = new a();
            }
            aVar = f67511a;
        }
        return aVar;
    }
}
