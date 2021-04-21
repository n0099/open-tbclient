package d.b.j0.s.b.q;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61842a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61842a == null) {
                f61842a = new a();
            }
            aVar = f61842a;
        }
        return aVar;
    }
}
