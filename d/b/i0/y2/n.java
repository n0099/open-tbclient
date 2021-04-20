package d.b.i0.y2;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f64211a;

    public static synchronized m a() {
        m mVar;
        synchronized (n.class) {
            if (f64211a == null) {
                f64211a = new m();
            }
            mVar = f64211a;
        }
        return mVar;
    }
}
