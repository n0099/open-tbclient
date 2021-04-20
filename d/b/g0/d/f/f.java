package d.b.g0.d.f;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f47881a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f47881a == null) {
                f47881a = new e();
            }
            eVar = f47881a;
        }
        return eVar;
    }
}
