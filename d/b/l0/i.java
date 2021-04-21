package d.b.l0;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f64934a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f64934a == null) {
                f64934a = new h();
            }
            hVar = f64934a;
        }
        return hVar;
    }
}
