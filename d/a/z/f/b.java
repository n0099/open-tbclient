package d.a.z.f;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f64912a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f64912a == null) {
                f64912a = new a();
            }
            aVar = f64912a;
        }
        return aVar;
    }
}
