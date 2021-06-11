package d.a.p0;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f67685a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f67685a == null) {
                f67685a = new h();
            }
            hVar = f67685a;
        }
        return hVar;
    }
}
