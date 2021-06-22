package d.a.o0.z2;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f67639a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f67639a == null) {
                f67639a = new e();
            }
            eVar = f67639a;
        }
        return eVar;
    }
}
