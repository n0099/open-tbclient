package d.a.j0.y2;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f62909a;

    public static synchronized g a() {
        g gVar;
        synchronized (h.class) {
            if (f62909a == null) {
                f62909a = new g();
            }
            gVar = f62909a;
        }
        return gVar;
    }
}
