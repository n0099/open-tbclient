package d.b.g0.f.i;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f48243a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f48243a == null) {
                f48243a = new d();
            }
            dVar = f48243a;
        }
        return dVar;
    }
}
