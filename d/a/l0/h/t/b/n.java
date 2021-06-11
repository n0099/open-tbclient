package d.a.l0.h.t.b;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f51354a;

    public static synchronized m a() {
        m mVar;
        synchronized (n.class) {
            if (f51354a == null) {
                f51354a = new m();
            }
            mVar = f51354a;
        }
        return mVar;
    }
}
