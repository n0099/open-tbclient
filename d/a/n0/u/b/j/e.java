package d.a.n0.u.b.j;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f65011a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f65011a == null) {
                f65011a = new d();
            }
            dVar = f65011a;
        }
        return dVar;
    }
}
