package d.c.b;

import d.c.a.b;
/* loaded from: classes5.dex */
public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    public static int f65109a;

    /* renamed from: b  reason: collision with root package name */
    public static d.c.a.b f65110b;

    static {
        a(2);
        b(new b.a());
    }

    public static void a(int i) {
        f65109a = i;
    }

    public static void b(d.c.a.b bVar) {
        f65110b = bVar;
    }

    public static void c(String str, String str2) {
        d(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        d.c.a.b bVar = f65110b;
        if (bVar == null || f65109a > 2) {
            return;
        }
        bVar.a(str, str2, th);
    }

    public static void e(String str, String str2) {
        f(str, str2, null);
    }

    public static void f(String str, String str2, Throwable th) {
        d.c.a.b bVar = f65110b;
        if (bVar == null || f65109a > 3) {
            return;
        }
        bVar.b(str, str2, th);
    }

    public static void g(String str, String str2) {
        h(str, str2, null);
    }

    public static void h(String str, String str2, Throwable th) {
        d.c.a.b bVar = f65110b;
        if (bVar == null || f65109a > 6) {
            return;
        }
        bVar.c(str, str2, th);
    }
}
