package d.a.h0.h.a;

import android.content.Context;
import android.util.Log;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.z0.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46937b = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public static final String f46938c = c.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f46939d;

    /* renamed from: a  reason: collision with root package name */
    public Map<d.a.h0.a.p.d.b, b> f46940a;

    public c() {
        a.a();
        this.f46940a = new HashMap();
    }

    public static c b() {
        if (f46939d == null) {
            synchronized (c.class) {
                if (f46939d == null) {
                    f46939d = new c();
                }
            }
        }
        return f46939d;
    }

    public static void d(d.a.h0.a.p.d.b bVar) {
        synchronized (c.class) {
            if (f46939d != null) {
                f46939d.c(bVar).i();
            }
        }
    }

    public static void e(d.a.h0.a.p.d.b bVar) {
        synchronized (c.class) {
            if (f46939d != null) {
                f46939d.f(bVar);
            } else if (f46937b) {
                Log.v(f46938c, "未初始化，无需执行release");
            }
        }
    }

    public static void h(d.a.h0.a.p.d.b bVar) {
        synchronized (c.class) {
            if (f46939d != null) {
                f46939d.c(bVar).l();
            }
        }
    }

    public boolean a(Context context, d.a.h0.a.a1.c.c cVar) {
        d.a.h0.a.c0.c.g("map", "map create start");
        if (k0.m(cVar.f41093g) != null && cVar.isValid()) {
            d.a.h0.a.p.d.d B = f.V().B(cVar.f41093g);
            if (!(B instanceof d.a.h0.a.p.d.b)) {
                d.a.h0.a.c0.c.b("map", "WebViewManager is null");
                return false;
            }
            b c2 = c((d.a.h0.a.p.d.b) B);
            if (c2.d(cVar.f41092f) != null) {
                d.a.h0.a.c0.c.b("map", "map with id " + cVar.f41092f + " exist");
                return false;
            }
            d.a.h0.h.a.i.c M = d.a.h0.h.a.i.c.M(context, cVar);
            if (M == null) {
                d.a.h0.a.c0.c.b("map", "map with id " + cVar.f41092f + " model is invalid");
                return false;
            }
            d.a.h0.a.a0.b.c w = M.w();
            if (!w.a()) {
                d.a.h0.a.c0.c.b("map", "map with id " + cVar.f41092f + " create fail: " + w.f41097b);
                return false;
            } else if (c2.g(M)) {
                d.a.h0.a.c0.c.g("map", "map with id " + cVar.f41092f + " init start");
                d.a.h0.h.a.f.f.e.a(context, M, cVar, c2);
                d.a.h0.a.c0.c.g("map", "map with id " + cVar.f41092f + " init end");
                d.a.h0.a.c0.c.g("map", "map create end");
                return true;
            } else {
                return false;
            }
        }
        d.a.h0.a.c0.c.b("map", "model data is invalid");
        return false;
    }

    public synchronized b c(d.a.h0.a.p.d.b bVar) {
        if (bVar == null) {
            return null;
        }
        b bVar2 = this.f46940a.get(bVar);
        if (bVar2 == null) {
            bVar2 = new b();
            this.f46940a.put(bVar, bVar2);
        }
        return bVar2;
    }

    public final synchronized void f(d.a.h0.a.p.d.b bVar) {
        if (bVar == null) {
            return;
        }
        b remove = this.f46940a.remove(bVar);
        if (remove != null) {
            remove.j();
        }
    }

    public boolean g(d.a.h0.a.a1.c.c cVar) {
        d.a.h0.a.c0.c.g("map", "map remove start");
        if (k0.m(cVar.f41093g) == null) {
            d.a.h0.a.c0.c.b("map", "webView is null or mapModel is null");
            return false;
        }
        d.a.h0.a.p.d.d B = f.V().B(cVar.f41093g);
        if (!(B instanceof d.a.h0.a.p.d.b)) {
            d.a.h0.a.c0.c.b("map", "WebViewManager is null");
            return false;
        }
        b c2 = c((d.a.h0.a.p.d.b) B);
        d.a.h0.h.a.i.c d2 = c2.d(cVar.f41092f);
        if (d2 == null) {
            d.a.h0.a.c0.c.b("map", "remove map with id " + cVar.f41092f + " not exist");
            return false;
        } else if (c2.k(cVar.f41092f)) {
            d.a.h0.a.c0.c.g("map", "map remove end");
            if (d.a.h0.a.a0.d.a.a(cVar) == null) {
                d.a.h0.a.a0.g.a.a("map", "remove with a null map component");
            }
            d.a.h0.a.a0.b.c C = d2.C();
            boolean a2 = C.a();
            if (!a2) {
                String str = f46938c;
                d.a.h0.a.c0.c.b(str, "map remove fail: " + C.f41097b);
            }
            return a2;
        } else {
            return false;
        }
    }

    public boolean i(Context context, d.a.h0.a.a1.c.c cVar) {
        d.a.h0.a.c0.c.g("map", "map update start");
        if (k0.m(cVar.f41093g) == null) {
            d.a.h0.a.c0.c.b("map", "webView is null or mapModel is null");
            return false;
        }
        d.a.h0.a.p.d.d B = f.V().B(cVar.f41093g);
        if (B != null && (B instanceof d.a.h0.a.p.d.b)) {
            b c2 = c((d.a.h0.a.p.d.b) B);
            d.a.h0.h.a.i.c d2 = c2.d(cVar.f41092f);
            if (d2 == null) {
                d.a.h0.a.c0.c.b("map", "remove map with id " + cVar.f41092f + " not exist");
                return false;
            }
            d2.H();
            d.a.h0.h.a.f.f.e.b(context, d2, cVar, c2, true);
            d.a.h0.a.c0.c.g("map", "map update end");
            if (d.a.h0.a.a0.d.a.a(cVar) == null) {
                d.a.h0.a.a0.g.a.a("map", "update with a null map component");
            }
            d.a.h0.a.a0.b.c G = d2.G(cVar);
            boolean a2 = G.a();
            if (!a2) {
                String str = f46938c;
                d.a.h0.a.c0.c.b(str, "map update fail: " + G.f41097b);
            }
            return a2;
        }
        d.a.h0.a.c0.c.b("map", "WebViewManager is null");
        return false;
    }
}
