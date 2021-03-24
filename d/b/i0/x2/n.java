package d.b.i0.x2;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f62525a;

    public static synchronized m a() {
        m mVar;
        synchronized (n.class) {
            if (f62525a == null) {
                f62525a = new m();
            }
            mVar = f62525a;
        }
        return mVar;
    }
}
