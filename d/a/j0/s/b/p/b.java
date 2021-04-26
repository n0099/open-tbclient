package d.a.j0.s.b.p;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60001a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60001a == null) {
                f60001a = new a();
            }
            aVar = f60001a;
        }
        return aVar;
    }
}
