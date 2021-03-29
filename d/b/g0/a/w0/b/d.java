package d.b.g0.a.w0.b;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f46860a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f46860a == null) {
                f46860a = new c();
            }
            cVar = f46860a;
        }
        return cVar;
    }
}
