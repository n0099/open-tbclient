package d.a.k0.s.b.i;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f60720a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f60720a == null) {
                f60720a = new e();
            }
            eVar = f60720a;
        }
        return eVar;
    }
}
