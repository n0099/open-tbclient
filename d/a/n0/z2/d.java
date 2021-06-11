package d.a.n0.z2;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f67512a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f67512a == null) {
                f67512a = new c();
            }
            cVar = f67512a;
        }
        return cVar;
    }
}
