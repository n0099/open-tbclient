package d.a.l0.e.i;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f50211a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f50211a == null) {
                f50211a = new e();
            }
            eVar = f50211a;
        }
        return eVar;
    }
}
