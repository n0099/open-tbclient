package d.b.j0.y2;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f64632a;

    public static synchronized m a() {
        m mVar;
        synchronized (n.class) {
            if (f64632a == null) {
                f64632a = new m();
            }
            mVar = f64632a;
        }
        return mVar;
    }
}
