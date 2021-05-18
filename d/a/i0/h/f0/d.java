package d.a.i0.h.f0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f47197a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f47197a == null) {
                f47197a = new c();
            }
            cVar = f47197a;
        }
        return cVar;
    }
}
