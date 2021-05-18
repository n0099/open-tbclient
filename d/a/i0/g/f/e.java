package d.a.i0.g.f;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f46907a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f46907a == null) {
                f46907a = new d();
            }
            dVar = f46907a;
        }
        return dVar;
    }
}
