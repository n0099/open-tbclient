package d.a.i0.e.i;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f46361a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f46361a == null) {
                f46361a = new e();
            }
            eVar = f46361a;
        }
        return eVar;
    }
}
