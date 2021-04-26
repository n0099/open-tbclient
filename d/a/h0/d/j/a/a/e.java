package d.a.h0.d.j.a.a;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f45696a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f45696a == null) {
                f45696a = new d();
            }
            dVar = f45696a;
        }
        return dVar;
    }
}
