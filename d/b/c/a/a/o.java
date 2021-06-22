package d.b.c.a.a;
/* loaded from: classes6.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static n f69030a;

    /* renamed from: b  reason: collision with root package name */
    public static long f69031b;

    public static n a() {
        synchronized (o.class) {
            if (f69030a != null) {
                n nVar = f69030a;
                f69030a = nVar.f69028f;
                nVar.f69028f = null;
                f69031b -= 8192;
                return nVar;
            }
            return new n();
        }
    }

    public static void b(n nVar) {
        if (nVar.f69028f == null && nVar.f69029g == null) {
            if (nVar.f69026d) {
                return;
            }
            synchronized (o.class) {
                if (f69031b + 8192 > 65536) {
                    return;
                }
                f69031b += 8192;
                nVar.f69028f = f69030a;
                nVar.f69025c = 0;
                nVar.f69024b = 0;
                f69030a = nVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
