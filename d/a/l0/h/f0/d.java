package d.a.l0.h.f0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f51047a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f51047a == null) {
                f51047a = new c();
            }
            cVar = f51047a;
        }
        return cVar;
    }
}
