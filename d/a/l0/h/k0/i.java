package d.a.l0.h.k0;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f51107a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f51107a == null) {
                f51107a = new h();
            }
            hVar = f51107a;
        }
        return hVar;
    }
}
