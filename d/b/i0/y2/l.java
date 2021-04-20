package d.b.i0.y2;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f64210a;

    public static synchronized k a() {
        k kVar;
        synchronized (l.class) {
            if (f64210a == null) {
                f64210a = new k();
            }
            kVar = f64210a;
        }
        return kVar;
    }
}
