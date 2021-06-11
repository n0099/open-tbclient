package d.a.l0.f.j.m;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f50550a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f50550a == null) {
                f50550a = new d();
            }
            dVar = f50550a;
        }
        return dVar;
    }
}
