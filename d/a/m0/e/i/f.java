package d.a.m0.e.i;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f50319a;

    public static synchronized e a() {
        e eVar;
        synchronized (f.class) {
            if (f50319a == null) {
                f50319a = new e();
            }
            eVar = f50319a;
        }
        return eVar;
    }
}
