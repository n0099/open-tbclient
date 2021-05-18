package d.a.i0.e.r;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46444a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46444a == null) {
                f46444a = new a();
            }
            aVar = f46444a;
        }
        return aVar;
    }
}
