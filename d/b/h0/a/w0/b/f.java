package d.b.h0.a.w0.b;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f47582a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f47582a == null) {
                f47582a = new e();
            }
            eVar = f47582a;
        }
        return eVar;
    }
}
