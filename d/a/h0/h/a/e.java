package d.a.h0.h.a;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f46941a;

    public static synchronized d a() {
        d dVar;
        synchronized (e.class) {
            if (f46941a == null) {
                f46941a = new d();
            }
            dVar = f46941a;
        }
        return dVar;
    }
}
