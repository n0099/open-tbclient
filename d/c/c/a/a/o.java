package d.c.c.a.a;
/* loaded from: classes5.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static n f65162a;

    /* renamed from: b  reason: collision with root package name */
    public static long f65163b;

    public static n a() {
        synchronized (o.class) {
            if (f65162a != null) {
                n nVar = f65162a;
                f65162a = nVar.f65160f;
                nVar.f65160f = null;
                f65163b -= 8192;
                return nVar;
            }
            return new n();
        }
    }

    public static void b(n nVar) {
        if (nVar.f65160f == null && nVar.f65161g == null) {
            if (nVar.f65158d) {
                return;
            }
            synchronized (o.class) {
                if (f65163b + 8192 > 65536) {
                    return;
                }
                f65163b += 8192;
                nVar.f65160f = f65162a;
                nVar.f65157c = 0;
                nVar.f65156b = 0;
                f65162a = nVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
