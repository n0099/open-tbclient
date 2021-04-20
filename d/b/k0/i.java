package d.b.k0;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f64653a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f64653a == null) {
                f64653a = new h();
            }
            hVar = f64653a;
        }
        return hVar;
    }
}
