package d.a.p0;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f63967a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f63967a == null) {
                f63967a = new h();
            }
            hVar = f63967a;
        }
        return hVar;
    }
}
