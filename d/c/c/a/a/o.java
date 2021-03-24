package d.c.c.a.a;
/* loaded from: classes4.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static n f65161a;

    /* renamed from: b  reason: collision with root package name */
    public static long f65162b;

    public static n a() {
        synchronized (o.class) {
            if (f65161a != null) {
                n nVar = f65161a;
                f65161a = nVar.f65159f;
                nVar.f65159f = null;
                f65162b -= 8192;
                return nVar;
            }
            return new n();
        }
    }

    public static void b(n nVar) {
        if (nVar.f65159f == null && nVar.f65160g == null) {
            if (nVar.f65157d) {
                return;
            }
            synchronized (o.class) {
                if (f65162b + 8192 > 65536) {
                    return;
                }
                f65162b += 8192;
                nVar.f65159f = f65161a;
                nVar.f65156c = 0;
                nVar.f65155b = 0;
                f65161a = nVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
