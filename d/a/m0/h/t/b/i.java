package d.a.m0.h.t.b;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f51460a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f51460a == null) {
                f51460a = new h();
            }
            hVar = f51460a;
        }
        return hVar;
    }
}
