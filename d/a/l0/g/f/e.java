package d.a.l0.g.f;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f47083a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f47083a == null) {
                f47083a = new d();
            }
            dVar = f47083a;
        }
        return dVar;
    }
}
