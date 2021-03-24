package d.b.g0.h.a;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f48719a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f48719a == null) {
                f48719a = new d();
            }
            dVar = f48719a;
        }
        return dVar;
    }
}
