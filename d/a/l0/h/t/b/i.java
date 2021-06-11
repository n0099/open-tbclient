package d.a.l0.h.t.b;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f51352a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f51352a == null) {
                f51352a = new h();
            }
            hVar = f51352a;
        }
        return hVar;
    }
}
