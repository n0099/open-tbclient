package d.b.g0.a.w0.b;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f46860a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f46860a == null) {
                f46860a = new e();
            }
            eVar = f46860a;
        }
        return eVar;
    }
}
