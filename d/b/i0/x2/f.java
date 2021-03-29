package d.b.i0.x2;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f62519a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f62519a == null) {
                f62519a = new e();
            }
            eVar = f62519a;
        }
        return eVar;
    }
}
