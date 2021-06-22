package d.a.o0.u.b.i;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f65127a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f65127a == null) {
                f65127a = new e();
            }
            eVar = f65127a;
        }
        return eVar;
    }
}
