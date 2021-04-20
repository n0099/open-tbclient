package d.b.d.m;

import com.baidu.mobads.container.util.SDKLogTypeConstants;
import d.b.i0.s2.f0.e;
import d.b.i0.s2.f0.h;
/* loaded from: classes.dex */
public class b {
    public static void a(d.b.d.m.g.a aVar, String str) {
        d.b.i0.s2.f0.c f2 = h.f(aVar);
        f2.c(str);
        f2.k(aVar.f43129h);
        e.b().d(f2);
    }

    public static void b(d.b.d.m.g.a aVar, int i) {
        d.b.i0.s2.f0.c f2 = h.f(aVar);
        f2.k(aVar.f43129h);
        f2.m(aVar.f43127f);
        f2.n(i);
        e.b().d(f2);
    }

    public static void c(d.b.d.m.g.a aVar) {
        e.b().d(h.q(aVar));
    }

    public static void d(d.b.d.m.g.a aVar) {
        e.b().d(h.p(aVar));
    }

    public static void e(d.b.d.m.g.a aVar) {
        d.b.i0.s2.f0.c f2 = h.f(aVar);
        f2.k(aVar.f43129h);
        e.b().d(f2);
    }

    public static void f(d.b.d.m.g.a aVar) {
        e.b().d(h.q(aVar));
    }

    public static void g(d.b.d.m.g.a aVar, int i) {
        d.b.i0.s2.f0.c n = h.n(aVar);
        n.j(SDKLogTypeConstants.CLOSE_GAME_TYPE);
        boolean z = i == 1000;
        n.c(z ? "APP" : "URL");
        if (!z) {
            n.m(i);
        }
        n.h("DEEPLINK");
        e.b().d(n);
    }
}
