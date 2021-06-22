package d.a.m0.h.k0;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f51215a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f51215a == null) {
                f51215a = new h();
            }
            hVar = f51215a;
        }
        return hVar;
    }
}
