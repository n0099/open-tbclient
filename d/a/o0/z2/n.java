package d.a.o0.z2;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f67646a;

    public static synchronized m a() {
        m mVar;
        synchronized (n.class) {
            if (f67646a == null) {
                f67646a = new m();
            }
            mVar = f67646a;
        }
        return mVar;
    }
}
