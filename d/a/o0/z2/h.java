package d.a.o0.z2;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f67640a;

    public static synchronized g a() {
        g gVar;
        synchronized (h.class) {
            if (f67640a == null) {
                f67640a = new g();
            }
            gVar = f67640a;
        }
        return gVar;
    }
}
