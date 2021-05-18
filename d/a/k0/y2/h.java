package d.a.k0.y2;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f63633a;

    public static synchronized g a() {
        g gVar;
        synchronized (h.class) {
            if (f63633a == null) {
                f63633a = new g();
            }
            gVar = f63633a;
        }
        return gVar;
    }
}
