package d.a.h0.a.w0.b;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f45006a;

    public static synchronized c a() {
        c cVar;
        synchronized (d.class) {
            if (f45006a == null) {
                f45006a = new c();
            }
            cVar = f45006a;
        }
        return cVar;
    }
}
