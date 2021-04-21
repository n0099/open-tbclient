package d.b.j0.s.b.m;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f61838a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f61838a == null) {
                f61838a = new d();
            }
            dVar = f61838a;
        }
        return dVar;
    }
}
