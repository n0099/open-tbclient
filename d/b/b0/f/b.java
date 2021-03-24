package d.b.b0.f;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f42480a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f42480a == null) {
                f42480a = new a();
            }
            aVar = f42480a;
        }
        return aVar;
    }
}
