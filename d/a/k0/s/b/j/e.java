package d.a.k0.s.b.j;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f60729a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f60729a == null) {
                f60729a = new d();
            }
            dVar = f60729a;
        }
        return dVar;
    }
}
