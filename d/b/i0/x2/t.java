package d.b.i0.x2;
/* loaded from: classes5.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f62530a;

    public static synchronized s a() {
        s sVar;
        synchronized (t.class) {
            if (f62530a == null) {
                f62530a = new s();
            }
            sVar = f62530a;
        }
        return sVar;
    }
}
