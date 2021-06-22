package d.a.m0.f.j.m;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f50658a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f50658a == null) {
                f50658a = new d();
            }
            dVar = f50658a;
        }
        return dVar;
    }
}
