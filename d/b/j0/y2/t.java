package d.b.j0.y2;
/* loaded from: classes4.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f64636a;

    public static synchronized s a() {
        s sVar;
        synchronized (t.class) {
            if (f64636a == null) {
                f64636a = new s();
            }
            sVar = f64636a;
        }
        return sVar;
    }
}
