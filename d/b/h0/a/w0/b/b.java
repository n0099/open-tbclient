package d.b.h0.a.w0.b;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f47580a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f47580a == null) {
                f47580a = new a();
            }
            aVar = f47580a;
        }
        return aVar;
    }
}
