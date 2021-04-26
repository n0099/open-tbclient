package d.a.j0.s.b.o;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f60000a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f60000a == null) {
                f60000a = new a();
            }
            aVar = f60000a;
        }
        return aVar;
    }
}
