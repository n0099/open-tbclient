package d.b.i0.x2;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f62519a;

    public static synchronized g a() {
        g gVar;
        synchronized (h.class) {
            if (f62519a == null) {
                f62519a = new g();
            }
            gVar = f62519a;
        }
        return gVar;
    }
}
