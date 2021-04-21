package d.b.h0.h.a;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f49441a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f49441a == null) {
                f49441a = new d();
            }
            dVar = f49441a;
        }
        return dVar;
    }
}
