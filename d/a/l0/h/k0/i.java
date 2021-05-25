package d.a.l0.h.k0;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f47433a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f47433a == null) {
                f47433a = new h();
            }
            hVar = f47433a;
        }
        return hVar;
    }
}
