package d.b.g0.a.t1;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f46245a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f46245a == null) {
                f46245a = new c();
            }
            cVar = f46245a;
        }
        return cVar;
    }
}
