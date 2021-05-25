package d.a.l0.f.j.m;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f46876a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f46876a == null) {
                f46876a = new d();
            }
            dVar = f46876a;
        }
        return dVar;
    }
}
