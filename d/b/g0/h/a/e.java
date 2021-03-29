package d.b.g0.h.a;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f48720a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f48720a == null) {
                f48720a = new d();
            }
            dVar = f48720a;
        }
        return dVar;
    }
}
