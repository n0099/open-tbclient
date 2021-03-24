package d.b.g0.a.t1;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f46244a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f46244a == null) {
                f46244a = new c();
            }
            cVar = f46244a;
        }
        return cVar;
    }
}
