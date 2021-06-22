package d.a.m0.h.g0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f51168a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f51168a == null) {
                f51168a = new c();
            }
            cVar = f51168a;
        }
        return cVar;
    }
}
