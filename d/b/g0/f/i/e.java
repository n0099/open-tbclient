package d.b.g0.f.i;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f47850a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f47850a == null) {
                f47850a = new d();
            }
            dVar = f47850a;
        }
        return dVar;
    }
}
