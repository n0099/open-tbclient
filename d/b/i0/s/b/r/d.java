package d.b.i0.s.b.r;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f60130a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f60130a == null) {
                f60130a = new c();
            }
            cVar = f60130a;
        }
        return cVar;
    }
}
