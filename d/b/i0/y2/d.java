package d.b.i0.y2;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f64202a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f64202a == null) {
                f64202a = new c();
            }
            cVar = f64202a;
        }
        return cVar;
    }
}
