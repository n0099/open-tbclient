package d.b.i0.s.b.g.a;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60083a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60083a == null) {
                f60083a = new a();
            }
            aVar = f60083a;
        }
        return aVar;
    }
}
