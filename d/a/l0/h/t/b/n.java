package d.a.l0.h.t.b;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f47680a;

    public static synchronized m a() {
        m mVar;
        synchronized (n.class) {
            if (f47680a == null) {
                f47680a = new m();
            }
            mVar = f47680a;
        }
        return mVar;
    }
}
