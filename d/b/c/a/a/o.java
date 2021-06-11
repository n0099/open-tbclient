package d.b.c.a.a;
/* loaded from: classes6.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static n f68926a;

    /* renamed from: b  reason: collision with root package name */
    public static long f68927b;

    public static n a() {
        synchronized (o.class) {
            if (f68926a != null) {
                n nVar = f68926a;
                f68926a = nVar.f68924f;
                nVar.f68924f = null;
                f68927b -= 8192;
                return nVar;
            }
            return new n();
        }
    }

    public static void b(n nVar) {
        if (nVar.f68924f == null && nVar.f68925g == null) {
            if (nVar.f68922d) {
                return;
            }
            synchronized (o.class) {
                if (f68927b + 8192 > 65536) {
                    return;
                }
                f68927b += 8192;
                nVar.f68924f = f68926a;
                nVar.f68921c = 0;
                nVar.f68920b = 0;
                f68926a = nVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
