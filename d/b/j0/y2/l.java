package d.b.j0.y2;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f64631a;

    public static synchronized k a() {
        k kVar;
        synchronized (l.class) {
            if (f64631a == null) {
                f64631a = new k();
            }
            kVar = f64631a;
        }
        return kVar;
    }
}
