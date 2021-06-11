package d.a.n0.z2;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f67515a;

    public static synchronized g a() {
        g gVar;
        synchronized (h.class) {
            if (f67515a == null) {
                f67515a = new g();
            }
            gVar = f67515a;
        }
        return gVar;
    }
}
