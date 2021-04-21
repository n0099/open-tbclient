package d.b.z.f;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f65871a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f65871a == null) {
                f65871a = new a();
            }
            aVar = f65871a;
        }
        return aVar;
    }
}
