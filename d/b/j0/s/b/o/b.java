package d.b.j0.s.b.o;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61840a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61840a == null) {
                f61840a = new a();
            }
            aVar = f61840a;
        }
        return aVar;
    }
}
