package d.a.n0.u.b.m;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f61301a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f61301a == null) {
                f61301a = new a();
            }
            aVar = f61301a;
        }
        return aVar;
    }
}
