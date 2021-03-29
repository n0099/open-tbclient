package d.b.b0.f;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f42481a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f42481a == null) {
                f42481a = new a();
            }
            aVar = f42481a;
        }
        return aVar;
    }
}
