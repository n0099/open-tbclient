package d.a.n0.z2;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f67514a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f67514a == null) {
                f67514a = new e();
            }
            eVar = f67514a;
        }
        return eVar;
    }
}
