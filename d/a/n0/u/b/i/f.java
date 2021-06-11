package d.a.n0.u.b.i;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f65002a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f65002a == null) {
                f65002a = new e();
            }
            eVar = f65002a;
        }
        return eVar;
    }
}
