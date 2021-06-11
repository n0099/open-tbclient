package d.a.d.m;

import com.baidu.mobads.container.util.SDKLogTypeConstants;
import d.a.n0.t2.i0.e;
import d.a.n0.t2.i0.g;
/* loaded from: classes.dex */
public class b {
    public static void a(d.a.d.m.g.a aVar, String str) {
        d.a.n0.t2.i0.c f2 = g.f(aVar);
        f2.c(str);
        f2.j(aVar.f43267h);
        e.b().d(f2);
    }

    public static void b(d.a.d.m.g.a aVar, int i2) {
        d.a.n0.t2.i0.c f2 = g.f(aVar);
        f2.j(aVar.f43267h);
        f2.l(aVar.f43265f);
        f2.m(i2);
        e.b().d(f2);
    }

    public static void c(d.a.d.m.g.a aVar) {
        e.b().d(g.q(aVar));
    }

    public static void d(d.a.d.m.g.a aVar) {
        e.b().d(g.p(aVar));
    }

    public static void e(d.a.d.m.g.a aVar) {
        d.a.n0.t2.i0.c f2 = g.f(aVar);
        f2.j(aVar.f43267h);
        e.b().d(f2);
    }

    public static void f(d.a.d.m.g.a aVar) {
        e.b().d(g.q(aVar));
    }

    public static void g(d.a.d.m.g.a aVar, int i2) {
        d.a.n0.t2.i0.c n = g.n(aVar);
        n.i(SDKLogTypeConstants.CLOSE_GAME_TYPE);
        boolean z = i2 == 1000;
        n.c(z ? "APP" : "URL");
        if (!z) {
            n.l(i2);
        }
        n.h("DEEPLINK");
        e.b().d(n);
    }
}
