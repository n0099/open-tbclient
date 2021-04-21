package d.b.h0.a.w0.b;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f47581a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f47581a == null) {
                f47581a = new c();
            }
            cVar = f47581a;
        }
        return cVar;
    }
}
