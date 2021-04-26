package d.a.h0.a.w0.b;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f45007a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f45007a == null) {
                f45007a = new e();
            }
            eVar = f45007a;
        }
        return eVar;
    }
}
