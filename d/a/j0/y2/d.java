package d.a.j0.y2;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f62906a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f62906a == null) {
                f62906a = new c();
            }
            cVar = f62906a;
        }
        return cVar;
    }
}
