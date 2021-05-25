package d.a.n0.z2;
/* loaded from: classes5.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f63802a;

    public static synchronized k a() {
        k kVar;
        synchronized (l.class) {
            if (f63802a == null) {
                f63802a = new k();
            }
            kVar = f63802a;
        }
        return kVar;
    }
}
