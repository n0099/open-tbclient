package d.b.h0.d.j.a.a;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f48246a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f48246a == null) {
                f48246a = new d();
            }
            dVar = f48246a;
        }
        return dVar;
    }
}
