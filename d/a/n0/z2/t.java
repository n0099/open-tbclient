package d.a.n0.z2;
/* loaded from: classes5.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f67525a;

    public static synchronized s a() {
        s sVar;
        synchronized (t.class) {
            if (f67525a == null) {
                f67525a = new s();
            }
            sVar = f67525a;
        }
        return sVar;
    }
}
