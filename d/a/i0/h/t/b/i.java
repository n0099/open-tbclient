package d.a.i0.h.t.b;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f47502a;

    public static synchronized h a() {
        h hVar;
        synchronized (i.class) {
            if (f47502a == null) {
                f47502a = new h();
            }
            hVar = f47502a;
        }
        return hVar;
    }
}
