package d.b.g0.h.a;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f49112a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f49112a == null) {
                f49112a = new d();
            }
            dVar = f49112a;
        }
        return dVar;
    }
}
