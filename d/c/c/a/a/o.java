package d.c.c.a.a;
/* loaded from: classes5.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static n f66007a;

    /* renamed from: b  reason: collision with root package name */
    public static long f66008b;

    public static n a() {
        synchronized (o.class) {
            if (f66007a != null) {
                n nVar = f66007a;
                f66007a = nVar.f66005f;
                nVar.f66005f = null;
                f66008b -= 8192;
                return nVar;
            }
            return new n();
        }
    }

    public static void b(n nVar) {
        if (nVar.f66005f == null && nVar.f66006g == null) {
            if (nVar.f66003d) {
                return;
            }
            synchronized (o.class) {
                if (f66008b + 8192 > 65536) {
                    return;
                }
                f66008b += 8192;
                nVar.f66005f = f66007a;
                nVar.f66002c = 0;
                nVar.f66001b = 0;
                f66007a = nVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
