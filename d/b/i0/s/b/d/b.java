package d.b.i0.s.b.d;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60061a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60061a == null) {
                f60061a = new a();
            }
            aVar = f60061a;
        }
        return aVar;
    }
}
