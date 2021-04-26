package d.a.l0;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f63230a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f63230a == null) {
                f63230a = new h();
            }
            hVar = f63230a;
        }
        return hVar;
    }
}
