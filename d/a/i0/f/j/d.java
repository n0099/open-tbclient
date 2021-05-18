package d.a.i0.f.j;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f46692a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f46692a == null) {
                f46692a = new c();
            }
            cVar = f46692a;
        }
        return cVar;
    }
}
