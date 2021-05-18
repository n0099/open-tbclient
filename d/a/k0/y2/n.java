package d.a.k0.y2;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f63639a;

    public static synchronized m a() {
        m mVar;
        synchronized (n.class) {
            if (f63639a == null) {
                f63639a = new m();
            }
            mVar = f63639a;
        }
        return mVar;
    }
}
