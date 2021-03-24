package d.b.g0.a.w0.b;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f46859a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f46859a == null) {
                f46859a = new c();
            }
            cVar = f46859a;
        }
        return cVar;
    }
}
