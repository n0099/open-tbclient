package d.a.n0.z2;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f63794a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f63794a == null) {
                f63794a = new c();
            }
            cVar = f63794a;
        }
        return cVar;
    }
}
