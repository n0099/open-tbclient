package d.b.i0.s.b.m;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f60116a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f60116a == null) {
                f60116a = new d();
            }
            dVar = f60116a;
        }
        return dVar;
    }
}
