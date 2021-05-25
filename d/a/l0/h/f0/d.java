package d.a.l0.h.f0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f47373a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f47373a == null) {
                f47373a = new c();
            }
            cVar = f47373a;
        }
        return cVar;
    }
}
