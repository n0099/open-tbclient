package d.b.g0.a.w0.b;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f46861a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f46861a == null) {
                f46861a = new e();
            }
            eVar = f46861a;
        }
        return eVar;
    }
}
