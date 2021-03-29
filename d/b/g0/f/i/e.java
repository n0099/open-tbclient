package d.b.g0.f.i;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f47851a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f47851a == null) {
                f47851a = new d();
            }
            dVar = f47851a;
        }
        return dVar;
    }
}
