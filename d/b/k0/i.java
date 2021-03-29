package d.b.k0;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f63953a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f63953a == null) {
                f63953a = new h();
            }
            hVar = f63953a;
        }
        return hVar;
    }
}
