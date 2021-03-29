package d.b.i0.x2;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f62517a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f62517a == null) {
                f62517a = new c();
            }
            cVar = f62517a;
        }
        return cVar;
    }
}
