package d.a.l0.e.i;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f46537a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f46537a == null) {
                f46537a = new e();
            }
            eVar = f46537a;
        }
        return eVar;
    }
}
