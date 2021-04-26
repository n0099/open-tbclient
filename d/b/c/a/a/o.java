package d.b.c.a.a;
/* loaded from: classes5.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static n f64466a;

    /* renamed from: b  reason: collision with root package name */
    public static long f64467b;

    public static n a() {
        synchronized (o.class) {
            if (f64466a != null) {
                n nVar = f64466a;
                f64466a = nVar.f64464f;
                nVar.f64464f = null;
                f64467b -= 8192;
                return nVar;
            }
            return new n();
        }
    }

    public static void b(n nVar) {
        if (nVar.f64464f == null && nVar.f64465g == null) {
            if (nVar.f64462d) {
                return;
            }
            synchronized (o.class) {
                if (f64467b + 8192 > 65536) {
                    return;
                }
                f64467b += 8192;
                nVar.f64464f = f64466a;
                nVar.f64461c = 0;
                nVar.f64460b = 0;
                f64466a = nVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
