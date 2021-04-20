package d.b.i0.s.b.r;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f61432a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f61432a == null) {
                f61432a = new c();
            }
            cVar = f61432a;
        }
        return cVar;
    }
}
