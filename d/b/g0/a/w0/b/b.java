package d.b.g0.a.w0.b;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f46859a;

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            if (f46859a == null) {
                f46859a = new a();
            }
            aVar = f46859a;
        }
        return aVar;
    }
}
