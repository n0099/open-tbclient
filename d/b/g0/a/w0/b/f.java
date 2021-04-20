package d.b.g0.a.w0.b;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f47253a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f47253a == null) {
                f47253a = new e();
            }
            eVar = f47253a;
        }
        return eVar;
    }
}
