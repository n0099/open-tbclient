package d.b.i0.s.b.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60064a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60064a == null) {
                f60064a = new a();
            }
            aVar = f60064a;
        }
        return aVar;
    }
}
