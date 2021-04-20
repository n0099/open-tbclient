package d.b.i0.y2;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f64204a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f64204a == null) {
                f64204a = new e();
            }
            eVar = f64204a;
        }
        return eVar;
    }
}
