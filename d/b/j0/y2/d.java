package d.b.j0.y2;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f64623a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f64623a == null) {
                f64623a = new c();
            }
            cVar = f64623a;
        }
        return cVar;
    }
}
