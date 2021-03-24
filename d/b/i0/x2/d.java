package d.b.i0.x2;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f62516a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f62516a == null) {
                f62516a = new c();
            }
            cVar = f62516a;
        }
        return cVar;
    }
}
