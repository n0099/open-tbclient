package d.a.l0.h.t.b;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f47678a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f47678a == null) {
                f47678a = new h();
            }
            hVar = f47678a;
        }
        return hVar;
    }
}
