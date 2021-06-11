package d.a.l0.g.f;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f50757a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f50757a == null) {
                f50757a = new d();
            }
            dVar = f50757a;
        }
        return dVar;
    }
}
