package d.b.g0.d.j.a.a;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f47917a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f47917a == null) {
                f47917a = new d();
            }
            dVar = f47917a;
        }
        return dVar;
    }
}
