package d.a.k0.y2;
/* loaded from: classes5.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f63643a;

    public static synchronized s a() {
        s sVar;
        synchronized (t.class) {
            if (f63643a == null) {
                f63643a = new s();
            }
            sVar = f63643a;
        }
        return sVar;
    }
}
