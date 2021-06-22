package d.a.o0.u.b.j;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f65136a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f65136a == null) {
                f65136a = new d();
            }
            dVar = f65136a;
        }
        return dVar;
    }
}
