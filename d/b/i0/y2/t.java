package d.b.i0.y2;
/* loaded from: classes4.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f64215a;

    public static synchronized s a() {
        s sVar;
        synchronized (t.class) {
            if (f64215a == null) {
                f64215a = new s();
            }
            sVar = f64215a;
        }
        return sVar;
    }
}
