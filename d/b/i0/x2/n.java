package d.b.i0.x2;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f62526a;

    public static synchronized m a() {
        m mVar;
        synchronized (n.class) {
            if (f62526a == null) {
                f62526a = new m();
            }
            mVar = f62526a;
        }
        return mVar;
    }
}
