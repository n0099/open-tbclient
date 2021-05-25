package d.a.n0.z2;
/* loaded from: classes5.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f63807a;

    public static synchronized s a() {
        s sVar;
        synchronized (t.class) {
            if (f63807a == null) {
                f63807a = new s();
            }
            sVar = f63807a;
        }
        return sVar;
    }
}
