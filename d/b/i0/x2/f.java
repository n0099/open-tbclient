package d.b.i0.x2;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f62518a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f62518a == null) {
                f62518a = new e();
            }
            eVar = f62518a;
        }
        return eVar;
    }
}
