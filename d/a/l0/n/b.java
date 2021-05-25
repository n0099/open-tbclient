package d.a.l0.n;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.pms.PMSConstants;
import d.a.l0.n.i.f;
import d.a.l0.n.i.m.g;
import d.a.l0.n.i.m.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static boolean a(g gVar, d.a.l0.n.f.g gVar2) {
        if (gVar2 == null) {
            return true;
        }
        if (gVar == null) {
            gVar2.B(new d.a.l0.n.h.a(2100, "request对象为空"));
            return true;
        }
        return false;
    }

    public static synchronized void b(d.a.l0.n.i.m.c cVar, d.a.l0.n.f.g gVar) {
        synchronized (b.class) {
            if (a(cVar, gVar)) {
                return;
            }
            if (TextUtils.isEmpty(cVar.g())) {
                gVar.B(new d.a.l0.n.h.a(2100, "bundleId为空"));
                return;
            }
            HashMap<String, String> e2 = d.a.l0.n.i.b.e(cVar);
            if (gVar.A() != null) {
                e2.putAll(gVar.A());
            }
            gVar.C();
            c.b().H().c(f.d(), e2, gVar.s(), new d.a.l0.n.i.k.b(cVar.g(), gVar, cVar));
        }
    }

    public static synchronized void c(d.a.l0.n.i.m.c cVar, d.a.l0.n.f.g gVar) {
        synchronized (b.class) {
            if (a(cVar, gVar)) {
                return;
            }
            String g2 = cVar.g();
            if (TextUtils.isEmpty(g2)) {
                gVar.B(new d.a.l0.n.h.a(2100, "bundleId为空"));
                return;
            }
            HashMap<String, String> e2 = d.a.l0.n.i.b.e(cVar);
            Map<String, String> A = gVar.A();
            if (A != null) {
                e2.putAll(A);
            }
            gVar.C();
            c.b().n().c(f.d(), e2, gVar.s(), new d.a.l0.n.i.k.b(g2, gVar, cVar));
        }
    }

    public static synchronized void d(d.a.l0.n.i.m.b bVar, d.a.l0.n.f.g gVar) {
        synchronized (b.class) {
            if (a(bVar, gVar)) {
                return;
            }
            if (bVar.f() != null && !bVar.f().isEmpty()) {
                HashMap<String, String> b2 = d.a.l0.n.i.b.b(bVar);
                if (gVar.A() != null && b2 != null) {
                    b2.putAll(gVar.A());
                }
                JSONObject a2 = d.a.l0.n.i.b.a(bVar);
                if (a2 == null) {
                    gVar.B(new d.a.l0.n.h.a(2100, "构造请求body失败"));
                    return;
                }
                if (PMSConstants.a(c.b())) {
                    d.a.l0.n.j.j.b.c().d();
                }
                if (gVar.x() != null) {
                    try {
                        for (Map.Entry<String, String> entry : gVar.x().entrySet()) {
                            a2.put(entry.getKey(), entry.getValue());
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                gVar.C();
                c.b().H().a(f.c(), b2, gVar.s(), a2, new d.a.l0.n.i.k.a(gVar, bVar));
                return;
            }
            gVar.B(new d.a.l0.n.h.a(2100, "pkg List为空"));
        }
    }

    public static synchronized void e(d.a.l0.n.i.m.d dVar, d.a.l0.n.f.g gVar) {
        synchronized (b.class) {
            if (a(dVar, gVar)) {
                return;
            }
            HashMap<String, String> f2 = d.a.l0.n.i.b.f(dVar);
            if (gVar.A() != null) {
                f2.putAll(gVar.A());
            }
            gVar.C();
            c.b().H().c(f.e(), f2, gVar.s(), new d.a.l0.n.i.k.c(gVar, dVar));
        }
    }

    public static synchronized void f(d.a.l0.n.i.m.f fVar, d.a.l0.n.f.g gVar) {
        synchronized (b.class) {
            if (a(fVar, gVar)) {
                return;
            }
            if (TextUtils.isEmpty(fVar.f())) {
                gVar.B(new d.a.l0.n.h.a(2100, "bundleId为空"));
            } else if (TextUtils.isEmpty(fVar.k())) {
                gVar.B(new d.a.l0.n.h.a(2100, "分包名为空"));
            } else {
                HashMap<String, String> g2 = d.a.l0.n.i.b.g(fVar);
                if (gVar.A() != null) {
                    g2.putAll(gVar.A());
                }
                gVar.C();
                c.b().H().c(f.d(), g2, gVar.s(), new d.a.l0.n.i.k.d(fVar.f(), gVar, fVar));
            }
        }
    }

    public static JSONObject g(@Nullable d.a.l0.n.j.c<JSONArray> cVar, @Nullable d.a.l0.n.j.c<JSONObject> cVar2) {
        return d.a.l0.n.j.f.a(cVar, cVar2);
    }

    public static synchronized boolean h(String str) {
        boolean c2;
        synchronized (b.class) {
            c2 = d.a.l0.n.i.i.g.d.b().c(str);
        }
        return c2;
    }

    public static synchronized boolean i(String str) {
        boolean d2;
        synchronized (b.class) {
            d2 = d.a.l0.n.i.i.g.d.b().d(str);
        }
        return d2;
    }

    public static synchronized void j(h hVar, d.a.l0.n.f.g gVar) {
        synchronized (b.class) {
            k(hVar, gVar, null);
        }
    }

    public static synchronized void k(h hVar, d.a.l0.n.f.g gVar, d.a.l0.n.f.g gVar2) {
        synchronized (b.class) {
            l(hVar, gVar, gVar2, null);
        }
    }

    public static synchronized void l(h hVar, d.a.l0.n.f.g gVar, d.a.l0.n.f.g gVar2, @Nullable d.a.l0.n.k.a.a aVar) {
        synchronized (b.class) {
            if (a(hVar, gVar)) {
                return;
            }
            if (PMSConstants.a(c.b())) {
                d.a.l0.n.j.j.b.c().d();
            }
            d.a.l0.n.j.c<JSONArray> g2 = aVar == null ? null : aVar.g();
            d.a.l0.n.f.g o = aVar == null ? null : aVar.o();
            HashMap hashMap = new HashMap();
            if (gVar.A() != null) {
                hashMap.putAll(gVar.A());
            }
            gVar.C();
            c.b().H().a(f.f(), hashMap, gVar.s(), g(g2, null), new d.a.l0.n.i.k.e(gVar, hVar, gVar2, o));
        }
    }

    public static synchronized void m(d.a.l0.n.k.a.a aVar) {
        synchronized (b.class) {
            if (aVar == null) {
                return;
            }
            d.a.l0.n.f.g o = aVar.o();
            if (o == null) {
                return;
            }
            g request = aVar.getRequest();
            if (request == null) {
                o.B(new d.a.l0.n.h.a(2100, "request对象为空"));
                return;
            }
            Map<String, String> A = o.A();
            if (o.A() != null) {
                A = new HashMap(A);
            }
            o.C();
            c.b().H().a(f.f(), A, o.s(), g(aVar.g(), null), new d.a.l0.n.i.k.e(o, request, null, o));
        }
    }
}
