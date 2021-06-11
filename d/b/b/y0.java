package d.b.b;

import d.b.a.b;
/* loaded from: classes6.dex */
public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    public static int f68870a;

    /* renamed from: b  reason: collision with root package name */
    public static d.b.a.b f68871b;

    static {
        a(2);
        b(new b.a());
    }

    public static void a(int i2) {
        f68870a = i2;
    }

    public static void b(d.b.a.b bVar) {
        f68871b = bVar;
    }

    public static void c(String str, String str2) {
        d(str, str2, null);
    }

    public static void d(String str, String str2, Throwable th) {
        d.b.a.b bVar = f68871b;
        if (bVar == null || f68870a > 2) {
            return;
        }
        bVar.a(str, str2, th);
    }

    public static void e(String str, String str2) {
        f(str, str2, null);
    }

    public static void f(String str, String str2, Throwable th) {
        d.b.a.b bVar = f68871b;
        if (bVar == null || f68870a > 3) {
            return;
        }
        bVar.b(str, str2, th);
    }

    public static void g(String str, String str2) {
        h(str, str2, null);
    }

    public static void h(String str, String str2, Throwable th) {
        d.b.a.b bVar = f68871b;
        if (bVar == null || f68870a > 6) {
            return;
        }
        bVar.c(str, str2, th);
    }
}
