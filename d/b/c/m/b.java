package d.b.c.m;

import d.b.i0.r2.b0.e;
import d.b.i0.r2.b0.h;
/* loaded from: classes.dex */
public class b {
    public static void a(d.b.c.m.g.a aVar, String str) {
        d.b.i0.r2.b0.c f2 = h.f(aVar);
        f2.c(str);
        f2.k(aVar.f42538h);
        e.b().d(f2);
    }

    public static void b(d.b.c.m.g.a aVar, int i) {
        d.b.i0.r2.b0.c f2 = h.f(aVar);
        f2.k(aVar.f42538h);
        f2.l(aVar.f42536f);
        f2.m(i);
        e.b().d(f2);
    }

    public static void c(d.b.c.m.g.a aVar) {
        e.b().d(h.q(aVar));
    }

    public static void d(d.b.c.m.g.a aVar) {
        e.b().d(h.p(aVar));
    }

    public static void e(d.b.c.m.g.a aVar) {
        d.b.i0.r2.b0.c f2 = h.f(aVar);
        f2.k(aVar.f42538h);
        e.b().d(f2);
    }

    public static void f(d.b.c.m.g.a aVar) {
        e.b().d(h.q(aVar));
    }

    public static void g(d.b.c.m.g.a aVar, int i) {
        d.b.i0.r2.b0.c n = h.n(aVar);
        n.j(706);
        boolean z = i == 1000;
        n.c(z ? "APP" : "URL");
        if (!z) {
            n.l(i);
        }
        n.h("DEEPLINK");
        e.b().d(n);
    }
}
