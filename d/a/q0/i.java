package d.a.q0;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f68099a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f68099a == null) {
                f68099a = new h();
            }
            hVar = f68099a;
        }
        return hVar;
    }
}
