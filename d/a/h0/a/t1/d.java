package d.a.h0.a.t1;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f44354a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f44354a == null) {
                f44354a = new c();
            }
            cVar = f44354a;
        }
        return cVar;
    }
}
