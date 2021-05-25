package d.a.n0.u.b.i;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f61289a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f61289a == null) {
                f61289a = new c();
            }
            cVar = f61289a;
        }
        return cVar;
    }
}
