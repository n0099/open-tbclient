package d.a.k0.s.b.d;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60687a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60687a == null) {
                f60687a = new a();
            }
            aVar = f60687a;
        }
        return aVar;
    }
}
