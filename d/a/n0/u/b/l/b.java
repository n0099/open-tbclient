package d.a.n0.u.b.l;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61300a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61300a == null) {
                f61300a = new a();
            }
            aVar = f61300a;
        }
        return aVar;
    }
}
