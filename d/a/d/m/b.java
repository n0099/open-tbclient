package d.a.d.m;

import com.baidu.mobads.container.util.SDKLogTypeConstants;
import d.a.j0.s2.h0.e;
import d.a.j0.s2.h0.h;
/* loaded from: classes.dex */
public class b {
    public static void a(d.a.d.m.g.a aVar, String str) {
        d.a.j0.s2.h0.c f2 = h.f(aVar);
        f2.c(str);
        f2.k(aVar.f40525h);
        e.b().d(f2);
    }

    public static void b(d.a.d.m.g.a aVar, int i2) {
        d.a.j0.s2.h0.c f2 = h.f(aVar);
        f2.k(aVar.f40525h);
        f2.m(aVar.f40523f);
        f2.n(i2);
        e.b().d(f2);
    }

    public static void c(d.a.d.m.g.a aVar) {
        e.b().d(h.q(aVar));
    }

    public static void d(d.a.d.m.g.a aVar) {
        e.b().d(h.p(aVar));
    }

    public static void e(d.a.d.m.g.a aVar) {
        d.a.j0.s2.h0.c f2 = h.f(aVar);
        f2.k(aVar.f40525h);
        e.b().d(f2);
    }

    public static void f(d.a.d.m.g.a aVar) {
        e.b().d(h.q(aVar));
    }

    public static void g(d.a.d.m.g.a aVar, int i2) {
        d.a.j0.s2.h0.c n = h.n(aVar);
        n.j(SDKLogTypeConstants.CLOSE_GAME_TYPE);
        boolean z = i2 == 1000;
        n.c(z ? "APP" : "URL");
        if (!z) {
            n.m(i2);
        }
        n.h("DEEPLINK");
        e.b().d(n);
    }
}
