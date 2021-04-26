package d.a.j0.s.b.m;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f59998a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f59998a == null) {
                f59998a = new d();
            }
            dVar = f59998a;
        }
        return dVar;
    }
}
