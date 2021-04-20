package d.b.i0.s.b.m;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f61417a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f61417a == null) {
                f61417a = new d();
            }
            dVar = f61417a;
        }
        return dVar;
    }
}
