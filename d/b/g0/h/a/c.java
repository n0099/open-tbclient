package d.b.g0.h.a;

import android.content.Context;
import android.util.Log;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.z0.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48715b = k.f45050a;

    /* renamed from: c  reason: collision with root package name */
    public static final String f48716c = c.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f48717d;

    /* renamed from: a  reason: collision with root package name */
    public Map<d.b.g0.a.p.d.b, b> f48718a;

    public c() {
        a.a();
        this.f48718a = new HashMap();
    }

    public static c b() {
        if (f48717d == null) {
            synchronized (c.class) {
                if (f48717d == null) {
                    f48717d = new c();
                }
            }
        }
        return f48717d;
    }

    public static void d(d.b.g0.a.p.d.b bVar) {
        synchronized (c.class) {
            if (f48717d != null) {
                f48717d.c(bVar).i();
            }
        }
    }

    public static void e(d.b.g0.a.p.d.b bVar) {
        synchronized (c.class) {
            if (f48717d != null) {
                f48717d.f(bVar);
            } else if (f48715b) {
                Log.v(f48716c, "未初始化，无需执行release");
            }
        }
    }

    public static void h(d.b.g0.a.p.d.b bVar) {
        synchronized (c.class) {
            if (f48717d != null) {
                f48717d.c(bVar).l();
            }
        }
    }

    public boolean a(Context context, d.b.g0.a.a1.c.c cVar) {
        d.b.g0.a.c0.c.g("map", "map create start");
        if (k0.m(cVar.f43113g) != null && cVar.isValid()) {
            d.b.g0.a.p.d.d j = f.V().j(cVar.f43113g);
            if (!(j instanceof d.b.g0.a.p.d.b)) {
                d.b.g0.a.c0.c.b("map", "WebViewManager is null");
                return false;
            }
            b c2 = c((d.b.g0.a.p.d.b) j);
            if (c2.d(cVar.f43112f) != null) {
                d.b.g0.a.c0.c.b("map", "map with id " + cVar.f43112f + " exist");
                return false;
            }
            d.b.g0.h.a.i.c M = d.b.g0.h.a.i.c.M(context, cVar);
            if (M == null) {
                d.b.g0.a.c0.c.b("map", "map with id " + cVar.f43112f + " model is invalid");
                return false;
            }
            d.b.g0.a.a0.b.c w = M.w();
            if (!w.a()) {
                d.b.g0.a.c0.c.b("map", "map with id " + cVar.f43112f + " create fail: " + w.f43116b);
                return false;
            } else if (c2.g(M)) {
                d.b.g0.a.c0.c.g("map", "map with id " + cVar.f43112f + " init start");
                d.b.g0.h.a.f.f.e.a(context, M, cVar, c2);
                d.b.g0.a.c0.c.g("map", "map with id " + cVar.f43112f + " init end");
                d.b.g0.a.c0.c.g("map", "map create end");
                return true;
            } else {
                return false;
            }
        }
        d.b.g0.a.c0.c.b("map", "model data is invalid");
        return false;
    }

    public synchronized b c(d.b.g0.a.p.d.b bVar) {
        if (bVar == null) {
            return null;
        }
        b bVar2 = this.f48718a.get(bVar);
        if (bVar2 == null) {
            bVar2 = new b();
            this.f48718a.put(bVar, bVar2);
        }
        return bVar2;
    }

    public final synchronized void f(d.b.g0.a.p.d.b bVar) {
        if (bVar == null) {
            return;
        }
        b remove = this.f48718a.remove(bVar);
        if (remove != null) {
            remove.j();
        }
    }

    public boolean g(d.b.g0.a.a1.c.c cVar) {
        d.b.g0.a.c0.c.g("map", "map remove start");
        if (k0.m(cVar.f43113g) == null) {
            d.b.g0.a.c0.c.b("map", "webView is null or mapModel is null");
            return false;
        }
        d.b.g0.a.p.d.d j = f.V().j(cVar.f43113g);
        if (!(j instanceof d.b.g0.a.p.d.b)) {
            d.b.g0.a.c0.c.b("map", "WebViewManager is null");
            return false;
        }
        b c2 = c((d.b.g0.a.p.d.b) j);
        d.b.g0.h.a.i.c d2 = c2.d(cVar.f43112f);
        if (d2 == null) {
            d.b.g0.a.c0.c.b("map", "remove map with id " + cVar.f43112f + " not exist");
            return false;
        } else if (c2.k(cVar.f43112f)) {
            d.b.g0.a.c0.c.g("map", "map remove end");
            if (d.b.g0.a.a0.d.a.a(cVar) == null) {
                d.b.g0.a.a0.g.a.a("map", "remove with a null map component");
            }
            d.b.g0.a.a0.b.c C = d2.C();
            boolean a2 = C.a();
            if (!a2) {
                String str = f48716c;
                d.b.g0.a.c0.c.b(str, "map remove fail: " + C.f43116b);
            }
            return a2;
        } else {
            return false;
        }
    }

    public boolean i(Context context, d.b.g0.a.a1.c.c cVar) {
        d.b.g0.a.c0.c.g("map", "map update start");
        if (k0.m(cVar.f43113g) == null) {
            d.b.g0.a.c0.c.b("map", "webView is null or mapModel is null");
            return false;
        }
        d.b.g0.a.p.d.d j = f.V().j(cVar.f43113g);
        if (j != null && (j instanceof d.b.g0.a.p.d.b)) {
            b c2 = c((d.b.g0.a.p.d.b) j);
            d.b.g0.h.a.i.c d2 = c2.d(cVar.f43112f);
            if (d2 == null) {
                d.b.g0.a.c0.c.b("map", "remove map with id " + cVar.f43112f + " not exist");
                return false;
            }
            d2.H();
            d.b.g0.h.a.f.f.e.b(context, d2, cVar, c2, true);
            d.b.g0.a.c0.c.g("map", "map update end");
            if (d.b.g0.a.a0.d.a.a(cVar) == null) {
                d.b.g0.a.a0.g.a.a("map", "update with a null map component");
            }
            d.b.g0.a.a0.b.c G = d2.G(cVar);
            boolean a2 = G.a();
            if (!a2) {
                String str = f48716c;
                d.b.g0.a.c0.c.b(str, "map update fail: " + G.f43116b);
            }
            return a2;
        }
        d.b.g0.a.c0.c.b("map", "WebViewManager is null");
        return false;
    }
}
