package d.b.j0.y2;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f64625a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f64625a == null) {
                f64625a = new e();
            }
            eVar = f64625a;
        }
        return eVar;
    }
}
