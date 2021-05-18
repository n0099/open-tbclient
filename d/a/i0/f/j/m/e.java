package d.a.i0.f.j.m;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f46700a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f46700a == null) {
                f46700a = new d();
            }
            dVar = f46700a;
        }
        return dVar;
    }
}
