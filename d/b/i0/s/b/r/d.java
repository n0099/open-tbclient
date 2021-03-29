package d.b.i0.s.b.r;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f60131a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f60131a == null) {
                f60131a = new c();
            }
            cVar = f60131a;
        }
        return cVar;
    }
}
