package d.a.l0.h.g0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f47386a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f47386a == null) {
                f47386a = new c();
            }
            cVar = f47386a;
        }
        return cVar;
    }
}
