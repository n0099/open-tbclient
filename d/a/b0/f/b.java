package d.a.b0.f;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f41948a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f41948a == null) {
                f41948a = new a();
            }
            aVar = f41948a;
        }
        return aVar;
    }
}
