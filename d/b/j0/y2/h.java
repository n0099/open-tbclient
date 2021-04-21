package d.b.j0.y2;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f64626a;

    public static synchronized g a() {
        g gVar;
        synchronized (h.class) {
            if (f64626a == null) {
                f64626a = new g();
            }
            gVar = f64626a;
        }
        return gVar;
    }
}
