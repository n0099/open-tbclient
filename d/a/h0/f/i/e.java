package d.a.h0.f.i;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f46033a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f46033a == null) {
                f46033a = new d();
            }
            dVar = f46033a;
        }
        return dVar;
    }
}
