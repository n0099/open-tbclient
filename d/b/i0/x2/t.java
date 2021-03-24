package d.b.i0.x2;
/* loaded from: classes5.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f62529a;

    public static synchronized s a() {
        s sVar;
        synchronized (t.class) {
            if (f62529a == null) {
                f62529a = new s();
            }
            sVar = f62529a;
        }
        return sVar;
    }
}
