package d.b.c.a.a;
/* loaded from: classes5.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static n f65152a;

    /* renamed from: b  reason: collision with root package name */
    public static long f65153b;

    public static n a() {
        synchronized (o.class) {
            if (f65152a != null) {
                n nVar = f65152a;
                f65152a = nVar.f65150f;
                nVar.f65150f = null;
                f65153b -= 8192;
                return nVar;
            }
            return new n();
        }
    }

    public static void b(n nVar) {
        if (nVar.f65150f == null && nVar.f65151g == null) {
            if (nVar.f65148d) {
                return;
            }
            synchronized (o.class) {
                if (f65153b + 8192 > 65536) {
                    return;
                }
                f65153b += 8192;
                nVar.f65150f = f65152a;
                nVar.f65147c = 0;
                nVar.f65146b = 0;
                f65152a = nVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
