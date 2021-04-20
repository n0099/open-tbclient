package d.b.i0.y2;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f64205a;

    public static synchronized g a() {
        g gVar;
        synchronized (h.class) {
            if (f64205a == null) {
                f64205a = new g();
            }
            gVar = f64205a;
        }
        return gVar;
    }
}
