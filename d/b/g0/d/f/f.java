package d.b.g0.d.f;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f47488a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f47488a == null) {
                f47488a = new e();
            }
            eVar = f47488a;
        }
        return eVar;
    }
}
