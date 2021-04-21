package d.b.h0.f.i;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f48572a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f48572a == null) {
                f48572a = new d();
            }
            dVar = f48572a;
        }
        return dVar;
    }
}
