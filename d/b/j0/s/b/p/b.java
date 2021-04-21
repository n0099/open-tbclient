package d.b.j0.s.b.p;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61841a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61841a == null) {
                f61841a = new a();
            }
            aVar = f61841a;
        }
        return aVar;
    }
}
