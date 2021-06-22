package d.a.m0.j;

import android.content.Context;
import android.util.Log;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f51617b = k.f46983a;

    /* renamed from: c  reason: collision with root package name */
    public static final String f51618c = c.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f51619d;

    /* renamed from: a  reason: collision with root package name */
    public Map<d.a.m0.a.p.e.b, b> f51620a;

    public c() {
        a.a();
        this.f51620a = new HashMap();
    }

    public static c b() {
        if (f51619d == null) {
            synchronized (c.class) {
                if (f51619d == null) {
                    f51619d = new c();
                }
            }
        }
        return f51619d;
    }

    public static void d(d.a.m0.a.p.e.b bVar) {
        synchronized (c.class) {
            if (f51619d != null) {
                f51619d.c(bVar).i();
            }
        }
    }

    public static void e(d.a.m0.a.p.e.b bVar) {
        synchronized (c.class) {
            if (f51619d != null) {
                f51619d.f(bVar);
            } else if (f51617b) {
                Log.v(f51618c, "未初始化，无需执行release");
            }
        }
    }

    public static void h(d.a.m0.a.p.e.b bVar) {
        synchronized (c.class) {
            if (f51619d != null) {
                f51619d.c(bVar).l();
            }
        }
    }

    public boolean a(Context context, d.a.m0.a.h1.c.c cVar) {
        d.a.m0.a.e0.d.g("map", "map create start");
        if (q0.m(cVar.f44630g) != null && cVar.isValid()) {
            d.a.m0.a.p.e.d B = d.a.m0.a.g1.f.V().B(cVar.f44630g);
            if (!(B instanceof d.a.m0.a.p.e.b)) {
                d.a.m0.a.e0.d.b("map", "WebViewManager is null");
                return false;
            }
            b c2 = c((d.a.m0.a.p.e.b) B);
            if (c2.d(cVar.f44629f) != null) {
                d.a.m0.a.e0.d.b("map", "map with id " + cVar.f44629f + " exist");
                return false;
            }
            d.a.m0.j.n.c M = d.a.m0.j.n.c.M(context, cVar);
            if (M == null) {
                d.a.m0.a.e0.d.b("map", "map with id " + cVar.f44629f + " model is invalid");
                return false;
            }
            d.a.m0.a.c0.b.c w = M.w();
            if (!w.a()) {
                d.a.m0.a.e0.d.b("map", "map with id " + cVar.f44629f + " create fail: " + w.f44634b);
                return false;
            } else if (c2.g(M)) {
                d.a.m0.a.e0.d.g("map", "map with id " + cVar.f44629f + " init start");
                d.a.m0.j.k.f.f.a(context, M, cVar, c2);
                d.a.m0.a.e0.d.g("map", "map with id " + cVar.f44629f + " init end");
                d.a.m0.a.e0.d.g("map", "map create end");
                return true;
            } else {
                return false;
            }
        }
        d.a.m0.a.e0.d.b("map", "model data is invalid");
        return false;
    }

    public synchronized b c(d.a.m0.a.p.e.b bVar) {
        if (bVar == null) {
            return null;
        }
        b bVar2 = this.f51620a.get(bVar);
        if (bVar2 == null) {
            bVar2 = new b();
            this.f51620a.put(bVar, bVar2);
        }
        return bVar2;
    }

    public final synchronized void f(d.a.m0.a.p.e.b bVar) {
        if (bVar == null) {
            return;
        }
        b remove = this.f51620a.remove(bVar);
        if (remove != null) {
            remove.j();
        }
    }

    public boolean g(d.a.m0.a.h1.c.c cVar) {
        d.a.m0.a.e0.d.g("map", "map remove start");
        if (q0.m(cVar.f44630g) == null) {
            d.a.m0.a.e0.d.b("map", "webView is null or mapModel is null");
            return false;
        }
        d.a.m0.a.p.e.d B = d.a.m0.a.g1.f.V().B(cVar.f44630g);
        if (!(B instanceof d.a.m0.a.p.e.b)) {
            d.a.m0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        b c2 = c((d.a.m0.a.p.e.b) B);
        d.a.m0.j.n.c d2 = c2.d(cVar.f44629f);
        if (d2 == null) {
            d.a.m0.a.e0.d.b("map", "remove map with id " + cVar.f44629f + " not exist");
            return false;
        } else if (c2.k(cVar.f44629f)) {
            d.a.m0.a.e0.d.g("map", "map remove end");
            if (d.a.m0.a.c0.d.a.a(cVar) == null) {
                d.a.m0.a.c0.g.a.a("map", "remove with a null map component");
            }
            d.a.m0.a.c0.b.c C = d2.C();
            boolean a2 = C.a();
            if (!a2) {
                String str = f51618c;
                d.a.m0.a.e0.d.b(str, "map remove fail: " + C.f44634b);
            }
            return a2;
        } else {
            return false;
        }
    }

    public boolean i(Context context, d.a.m0.a.h1.c.c cVar) {
        d.a.m0.a.e0.d.g("map", "map update start");
        if (q0.m(cVar.f44630g) == null) {
            d.a.m0.a.e0.d.b("map", "webView is null or mapModel is null");
            return false;
        }
        d.a.m0.a.p.e.d B = d.a.m0.a.g1.f.V().B(cVar.f44630g);
        if (B != null && (B instanceof d.a.m0.a.p.e.b)) {
            b c2 = c((d.a.m0.a.p.e.b) B);
            d.a.m0.j.n.c d2 = c2.d(cVar.f44629f);
            if (d2 == null) {
                d.a.m0.a.e0.d.b("map", "remove map with id " + cVar.f44629f + " not exist");
                return false;
            }
            d2.H();
            d.a.m0.j.k.f.f.b(context, d2, cVar, c2, true);
            d.a.m0.a.e0.d.g("map", "map update end");
            if (d.a.m0.a.c0.d.a.a(cVar) == null) {
                d.a.m0.a.c0.g.a.a("map", "update with a null map component");
            }
            d.a.m0.a.c0.b.c G = d2.G(cVar);
            boolean a2 = G.a();
            if (!a2) {
                String str = f51618c;
                d.a.m0.a.e0.d.b(str, "map update fail: " + G.f44634b);
            }
            return a2;
        }
        d.a.m0.a.e0.d.b("map", "WebViewManager is null");
        return false;
    }
}
