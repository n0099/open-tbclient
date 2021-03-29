package d.b.i0.x2;
/* loaded from: classes5.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static volatile k f62525a;

    public static synchronized k a() {
        k kVar;
        synchronized (l.class) {
            if (f62525a == null) {
                f62525a = new k();
            }
            kVar = f62525a;
        }
        return kVar;
    }
}
