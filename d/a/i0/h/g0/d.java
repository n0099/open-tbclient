package d.a.i0.h.g0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f47210a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f47210a == null) {
                f47210a = new c();
            }
            cVar = f47210a;
        }
        return cVar;
    }
}
