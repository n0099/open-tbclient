package d.a.n0.z2;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f63796a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f63796a == null) {
                f63796a = new e();
            }
            eVar = f63796a;
        }
        return eVar;
    }
}
