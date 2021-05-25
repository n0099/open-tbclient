package d.b.c.a.a;
/* loaded from: classes6.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static n f65195a;

    /* renamed from: b  reason: collision with root package name */
    public static long f65196b;

    public static n a() {
        synchronized (o.class) {
            if (f65195a != null) {
                n nVar = f65195a;
                f65195a = nVar.f65193f;
                nVar.f65193f = null;
                f65196b -= 8192;
                return nVar;
            }
            return new n();
        }
    }

    public static void b(n nVar) {
        if (nVar.f65193f == null && nVar.f65194g == null) {
            if (nVar.f65191d) {
                return;
            }
            synchronized (o.class) {
                if (f65196b + 8192 > 65536) {
                    return;
                }
                f65196b += 8192;
                nVar.f65193f = f65195a;
                nVar.f65190c = 0;
                nVar.f65189b = 0;
                f65195a = nVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
