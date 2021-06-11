package d.a.n0.z2;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f67521a;

    public static synchronized m a() {
        m mVar;
        synchronized (n.class) {
            if (f67521a == null) {
                f67521a = new m();
            }
            mVar = f67521a;
        }
        return mVar;
    }
}
