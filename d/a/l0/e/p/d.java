package d.a.l0.e.p;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f46577a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f46577a == null) {
                f46577a = new c();
            }
            cVar = f46577a;
        }
        return cVar;
    }
}
