package d.c.c.a.a;
/* loaded from: classes5.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static n f66102a;

    /* renamed from: b  reason: collision with root package name */
    public static long f66103b;

    public static n a() {
        synchronized (o.class) {
            if (f66102a != null) {
                n nVar = f66102a;
                f66102a = nVar.f66100f;
                nVar.f66100f = null;
                f66103b -= 8192;
                return nVar;
            }
            return new n();
        }
    }

    public static void b(n nVar) {
        if (nVar.f66100f == null && nVar.f66101g == null) {
            if (nVar.f66098d) {
                return;
            }
            synchronized (o.class) {
                if (f66103b + 8192 > 65536) {
                    return;
                }
                f66103b += 8192;
                nVar.f66100f = f66102a;
                nVar.f66097c = 0;
                nVar.f66096b = 0;
                f66102a = nVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
