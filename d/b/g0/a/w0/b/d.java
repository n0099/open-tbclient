package d.b.g0.a.w0.b;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f47252a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f47252a == null) {
                f47252a = new c();
            }
            cVar = f47252a;
        }
        return cVar;
    }
}
