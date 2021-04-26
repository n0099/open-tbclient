package d.a.j0.y2;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f62915a;

    public static synchronized m a() {
        m mVar;
        synchronized (n.class) {
            if (f62915a == null) {
                f62915a = new m();
            }
            mVar = f62915a;
        }
        return mVar;
    }
}
