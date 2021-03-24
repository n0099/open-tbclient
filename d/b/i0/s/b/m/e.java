package d.b.i0.s.b.m;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f60115a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f60115a == null) {
                f60115a = new d();
            }
            dVar = f60115a;
        }
        return dVar;
    }
}
