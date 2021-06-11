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
    public static final boolean f51509b = k.f46875a;

    /* renamed from: c  reason: collision with root package name */
    public static final String f51510c = c.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f51511d;

    /* renamed from: a  reason: collision with root package name */
    public Map<d.a.l0.a.p.e.b, b> f51512a;

    public c() {
        a.a();
        this.f51512a = new HashMap();
    }

    public static c b() {
        if (f51511d == null) {
            synchronized (c.class) {
                if (f51511d == null) {
                    f51511d = new c();
                }
            }
        }
        return f51511d;
    }

    public static void d(d.a.l0.a.p.e.b bVar) {
        synchronized (c.class) {
            if (f51511d != null) {
                f51511d.c(bVar).i();
            }
        }
    }

    public static void e(d.a.l0.a.p.e.b bVar) {
        synchronized (c.class) {
            if (f51511d != null) {
                f51511d.f(bVar);
            } else if (f51509b) {
                Log.v(f51510c, "未初始化，无需执行release");
            }
        }
    }

    public static void h(d.a.l0.a.p.e.b bVar) {
        synchronized (c.class) {
            if (f51511d != null) {
                f51511d.c(bVar).l();
            }
        }
    }

    public boolean a(Context context, d.a.l0.a.h1.c.c cVar) {
        d.a.l0.a.e0.d.g("map", "map create start");
        if (q0.m(cVar.f44522g) != null && cVar.isValid()) {
            d.a.l0.a.p.e.d B = d.a.l0.a.g1.f.V().B(cVar.f44522g);
            if (!(B instanceof d.a.l0.a.p.e.b)) {
                d.a.l0.a.e0.d.b("map", "WebViewManager is null");
                return false;
            }
            b c2 = c((d.a.l0.a.p.e.b) B);
            if (c2.d(cVar.f44521f) != null) {
                d.a.l0.a.e0.d.b("map", "map with id " + cVar.f44521f + " exist");
                return false;
            }
            d.a.l0.j.n.c M = d.a.l0.j.n.c.M(context, cVar);
            if (M == null) {
                d.a.l0.a.e0.d.b("map", "map with id " + cVar.f44521f + " model is invalid");
                return false;
            }
            d.a.l0.a.c0.b.c w = M.w();
            if (!w.a()) {
                d.a.l0.a.e0.d.b("map", "map with id " + cVar.f44521f + " create fail: " + w.f44526b);
                return false;
            } else if (c2.g(M)) {
                d.a.l0.a.e0.d.g("map", "map with id " + cVar.f44521f + " init start");
                d.a.l0.j.k.f.f.a(context, M, cVar, c2);
                d.a.l0.a.e0.d.g("map", "map with id " + cVar.f44521f + " init end");
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
        b bVar2 = this.f51512a.get(bVar);
        if (bVar2 == null) {
            bVar2 = new b();
            this.f51512a.put(bVar, bVar2);
        }
        return bVar2;
    }

    public final synchronized void f(d.a.l0.a.p.e.b bVar) {
        if (bVar == null) {
            return;
        }
        b remove = this.f51512a.remove(bVar);
        if (remove != null) {
            remove.j();
        }
    }

    public boolean g(d.a.l0.a.h1.c.c cVar) {
        d.a.l0.a.e0.d.g("map", "map remove start");
        if (q0.m(cVar.f44522g) == null) {
            d.a.l0.a.e0.d.b("map", "webView is null or mapModel is null");
            return false;
        }
        d.a.l0.a.p.e.d B = d.a.l0.a.g1.f.V().B(cVar.f44522g);
        if (!(B instanceof d.a.l0.a.p.e.b)) {
            d.a.l0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        b c2 = c((d.a.l0.a.p.e.b) B);
        d.a.l0.j.n.c d2 = c2.d(cVar.f44521f);
        if (d2 == null) {
            d.a.l0.a.e0.d.b("map", "remove map with id " + cVar.f44521f + " not exist");
            return false;
        } else if (c2.k(cVar.f44521f)) {
            d.a.l0.a.e0.d.g("map", "map remove end");
            if (d.a.l0.a.c0.d.a.a(cVar) == null) {
                d.a.l0.a.c0.g.a.a("map", "remove with a null map component");
            }
            d.a.l0.a.c0.b.c C = d2.C();
            boolean a2 = C.a();
            if (!a2) {
                String str = f51510c;
                d.a.l0.a.e0.d.b(str, "map remove fail: " + C.f44526b);
            }
            return a2;
        } else {
            return false;
        }
    }

    public boolean i(Context context, d.a.l0.a.h1.c.c cVar) {
        d.a.l0.a.e0.d.g("map", "map update start");
        if (q0.m(cVar.f44522g) == null) {
            d.a.l0.a.e0.d.b("map", "webView is null or mapModel is null");
            return false;
        }
        d.a.l0.a.p.e.d B = d.a.l0.a.g1.f.V().B(cVar.f44522g);
        if (B != null && (B instanceof d.a.l0.a.p.e.b)) {
            b c2 = c((d.a.l0.a.p.e.b) B);
            d.a.l0.j.n.c d2 = c2.d(cVar.f44521f);
            if (d2 == null) {
                d.a.l0.a.e0.d.b("map", "remove map with id " + cVar.f44521f + " not exist");
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
                String str = f51510c;
                d.a.l0.a.e0.d.b(str, "map update fail: " + G.f44526b);
            }
            return a2;
        }
        d.a.l0.a.e0.d.b("map", "WebViewManager is null");
        return false;
    }
}
