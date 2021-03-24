package d.c.b;

import d.c.a.b;
/* loaded from: classes5.dex */
public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    public static int f65108a;

    /* renamed from: b  reason: collision with root package name */
    public static d.c.a.b f65109b;

    static {
        a(2);
        b(new b.a());
    }

    public static void a(int i) {
        f65108a = i;
    }

    public static void b(d.c.a.b bVar) {
        f65109b = bVar;
    }

    public static void c(String str, String str2) {
        d(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        d.c.a.b bVar = f65109b;
        if (bVar == null || f65108a > 2) {
            return;
        }
        bVar.a(str, str2, th);
    }

    public static void e(String str, String str2) {
        f(str, str2, null);
    }

    public static void f(String str, String str2, Throwable th) {
        d.c.a.b bVar = f65109b;
        if (bVar == null || f65108a > 3) {
            return;
        }
        bVar.b(str, str2, th);
    }

    public static void g(String str, String str2) {
        h(str, str2, null);
    }

    public static void h(String str, String str2, Throwable th) {
        d.c.a.b bVar = f65109b;
        if (bVar == null || f65108a > 6) {
            return;
        }
        bVar.c(str, str2, th);
    }
}
