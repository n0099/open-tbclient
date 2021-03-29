package d.b.i0.s.b.f;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60078a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60078a == null) {
                f60078a = new a();
            }
            aVar = f60078a;
        }
        return aVar;
    }
}
