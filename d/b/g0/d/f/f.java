package d.b.g0.d.f;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f47489a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f47489a == null) {
                f47489a = new e();
            }
            eVar = f47489a;
        }
        return eVar;
    }
}
