package d.b.i0.s.b.d;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60062a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60062a == null) {
                f60062a = new a();
            }
            aVar = f60062a;
        }
        return aVar;
    }
}
