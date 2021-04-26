package d.a.j0.s.b.r;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f60014a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f60014a == null) {
                f60014a = new c();
            }
            cVar = f60014a;
        }
        return cVar;
    }
}
