package d.a.l0.h.g0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f51060a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f51060a == null) {
                f51060a = new c();
            }
            cVar = f51060a;
        }
        return cVar;
    }
}
