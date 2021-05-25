package d.a.n0.u.b.j;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f61298a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f61298a == null) {
                f61298a = new d();
            }
            dVar = f61298a;
        }
        return dVar;
    }
}
