package d.b.i0.x2;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f62520a;

    public static synchronized g a() {
        g gVar;
        synchronized (h.class) {
            if (f62520a == null) {
                f62520a = new g();
            }
            gVar = f62520a;
        }
        return gVar;
    }
}
