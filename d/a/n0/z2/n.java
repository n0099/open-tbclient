package d.a.n0.z2;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f63803a;

    public static synchronized m a() {
        m mVar;
        synchronized (n.class) {
            if (f63803a == null) {
                f63803a = new m();
            }
            mVar = f63803a;
        }
        return mVar;
    }
}
