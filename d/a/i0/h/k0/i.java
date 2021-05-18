package d.a.i0.h.k0;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f47257a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f47257a == null) {
                f47257a = new h();
            }
            hVar = f47257a;
        }
        return hVar;
    }
}
