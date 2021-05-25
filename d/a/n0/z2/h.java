package d.a.n0.z2;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f63797a;

    public static synchronized g a() {
        g gVar;
        synchronized (h.class) {
            if (f63797a == null) {
                f63797a = new g();
            }
            gVar = f63797a;
        }
        return gVar;
    }
}
