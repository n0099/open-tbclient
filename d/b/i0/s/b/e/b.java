package d.b.i0.s.b.e;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60065a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60065a == null) {
                f60065a = new a();
            }
            aVar = f60065a;
        }
        return aVar;
    }
}
