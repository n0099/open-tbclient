package d.b.h0.d.f;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f48210a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f48210a == null) {
                f48210a = new e();
            }
            eVar = f48210a;
        }
        return eVar;
    }
}
