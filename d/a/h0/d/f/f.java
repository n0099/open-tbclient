package d.a.h0.d.f;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f45659a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f45659a == null) {
                f45659a = new e();
            }
            eVar = f45659a;
        }
        return eVar;
    }
}
