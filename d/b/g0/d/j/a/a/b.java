package d.b.g0.d.j.a.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47523a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47523a == null) {
                f47523a = new a();
            }
            aVar = f47523a;
        }
        return aVar;
    }
}
