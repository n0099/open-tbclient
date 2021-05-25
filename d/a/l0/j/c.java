package d.a.l0.j;

import android.content.Context;
import android.util.Log;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47835b = k.f43199a;

    /* renamed from: c  reason: collision with root package name */
    public static final String f47836c = c.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f47837d;

    /* renamed from: a  reason: collision with root package name */
    public Map<d.a.l0.a.p.e.b, b> f47838a;

    public c() {
        a.a();
        this.f47838a = new HashMap();
    }

    public static c b() {
        if (f47837d == null) {
            synchronized (c.class) {
                if (f47837d == null) {
                    f47837d = new c();
                }
            }
        }
        return f47837d;
    }

    public static void d(d.a.l0.a.p.e.b bVar) {
        synchronized (c.class) {
            if (f47837d != null) {
                f47837d.c(bVar).i();
            }
        }
    }

    public static void e(d.a.l0.a.p.e.b bVar) {
        synchronized (c.class) {
            if (f47837d != null) {
                f47837d.f(bVar);
            } else if (f47835b) {
                Log.v(f47836c, "未初始化，无需执行release");
            }
        }
    }

    public static void h(d.a.l0.a.p.e.b bVar) {
        synchronized (c.class) {
            if (f47837d != null) {
                f47837d.c(bVar).l();
            }
        }
    }

    public boolean a(Context context, d.a.l0.a.h1.c.c cVar) {
        d.a.l0.a.e0.d.g("map", "map create start");
        if (q0.m(cVar.f40846g) != null && cVar.isValid()) {
            d.a.l0.a.p.e.d B = d.a.l0.a.g1.f.V().B(cVar.f40846g);
            if (!(B instanceof d.a.l0.a.p.e.b)) {
                d.a.l0.a.e0.d.b("map", "WebViewManager is null");
                return false;
            }
            b c2 = c((d.a.l0.a.p.e.b) B);
            if (c2.d(cVar.f40845f) != null) {
                d.a.l0.a.e0.d.b("map", "map with id " + cVar.f40845f + " exist");
                return false;
            }
            d.a.l0.j.n.c M = d.a.l0.j.n.c.M(context, cVar);
            if (M == null) {
                d.a.l0.a.e0.d.b("map", "map with id " + cVar.f40845f + " model is invalid");
                return false;
            }
            d.a.l0.a.c0.b.c w = M.w();
            if (!w.a()) {
                d.a.l0.a.e0.d.b("map", "map with id " + cVar.f40845f + " create fail: " + w.f40850b);
                return false;
            } else if (c2.g(M)) {
                d.a.l0.a.e0.d.g("map", "map with id " + cVar.f40845f + " init start");
                d.a.l0.j.k.f.f.a(context, M, cVar, c2);
                d.a.l0.a.e0.d.g("map", "map with id " + cVar.f40845f + " init end");
                d.a.l0.a.e0.d.g("map", "map create end");
                return true;
            } else {
                return false;
            }
        }
        d.a.l0.a.e0.d.b("map", "model data is invalid");
        return false;
    }

    public synchronized b c(d.a.l0.a.p.e.b bVar) {
        if (bVar == null) {
            return null;
        }
        b bVar2 = this.f47838a.get(bVar);
        if (bVar2 == null) {
            bVar2 = new b();
            this.f47838a.put(bVar, bVar2);
        }
        return bVar2;
    }

    public final synchronized void f(d.a.l0.a.p.e.b bVar) {
        if (bVar == null) {
            return;
        }
        b remove = this.f47838a.remove(bVar);
        if (remove != null) {
            remove.j();
        }
    }

    public boolean g(d.a.l0.a.h1.c.c cVar) {
        d.a.l0.a.e0.d.g("map", "map remove start");
        if (q0.m(cVar.f40846g) == null) {
            d.a.l0.a.e0.d.b("map", "webView is null or mapModel is null");
            return false;
        }
        d.a.l0.a.p.e.d B = d.a.l0.a.g1.f.V().B(cVar.f40846g);
        if (!(B instanceof d.a.l0.a.p.e.b)) {
            d.a.l0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        b c2 = c((d.a.l0.a.p.e.b) B);
        d.a.l0.j.n.c d2 = c2.d(cVar.f40845f);
        if (d2 == null) {
            d.a.l0.a.e0.d.b("map", "remove map with id " + cVar.f40845f + " not exist");
            return false;
        } else if (c2.k(cVar.f40845f)) {
            d.a.l0.a.e0.d.g("map", "map remove end");
            if (d.a.l0.a.c0.d.a.a(cVar) == null) {
                d.a.l0.a.c0.g.a.a("map", "remove with a null map component");
            }
            d.a.l0.a.c0.b.c C = d2.C();
            boolean a2 = C.a();
            if (!a2) {
                String str = f47836c;
                d.a.l0.a.e0.d.b(str, "map remove fail: " + C.f40850b);
            }
            return a2;
        } else {
            return false;
        }
    }

    public boolean i(Context context, d.a.l0.a.h1.c.c cVar) {
        d.a.l0.a.e0.d.g("map", "map update start");
        if (q0.m(cVar.f40846g) == null) {
            d.a.l0.a.e0.d.b("map", "webView is null or mapModel is null");
            return false;
        }
        d.a.l0.a.p.e.d B = d.a.l0.a.g1.f.V().B(cVar.f40846g);
        if (B != null && (B instanceof d.a.l0.a.p.e.b)) {
            b c2 = c((d.a.l0.a.p.e.b) B);
            d.a.l0.j.n.c d2 = c2.d(cVar.f40845f);
            if (d2 == null) {
                d.a.l0.a.e0.d.b("map", "remove map with id " + cVar.f40845f + " not exist");
                return false;
            }
            d2.H();
            d.a.l0.j.k.f.f.b(context, d2, cVar, c2, true);
            d.a.l0.a.e0.d.g("map", "map update end");
            if (d.a.l0.a.c0.d.a.a(cVar) == null) {
                d.a.l0.a.c0.g.a.a("map", "update with a null map component");
            }
            d.a.l0.a.c0.b.c G = d2.G(cVar);
            boolean a2 = G.a();
            if (!a2) {
                String str = f47836c;
                d.a.l0.a.e0.d.b(str, "map update fail: " + G.f40850b);
            }
            return a2;
        }
        d.a.l0.a.e0.d.b("map", "WebViewManager is null");
        return false;
    }
}
