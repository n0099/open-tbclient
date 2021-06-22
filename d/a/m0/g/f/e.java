package d.a.m0.g.f;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f50865a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f50865a == null) {
                f50865a = new d();
            }
            dVar = f50865a;
        }
        return dVar;
    }
}
