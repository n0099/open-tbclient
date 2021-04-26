package d.a.j0.y2;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f62908a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f62908a == null) {
                f62908a = new e();
            }
            eVar = f62908a;
        }
        return eVar;
    }
}
