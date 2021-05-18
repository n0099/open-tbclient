package d.a.k0.y2;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f63632a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f63632a == null) {
                f63632a = new e();
            }
            eVar = f63632a;
        }
        return eVar;
    }
}
