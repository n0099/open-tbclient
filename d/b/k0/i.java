package d.b.k0;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f63952a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f63952a == null) {
                f63952a = new h();
            }
            hVar = f63952a;
        }
        return hVar;
    }
}
