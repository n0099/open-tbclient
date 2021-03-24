package d.b.g0.l;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import d.b.g0.l.l.k.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static synchronized void a(d.b.g0.l.l.k.c cVar, d.b.g0.l.h.g gVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (cVar == null) {
                gVar.C(new d.b.g0.l.k.a(2100, "request对象为空"));
            } else if (TextUtils.isEmpty(cVar.g())) {
                gVar.C(new d.b.g0.l.k.a(2100, "bundleId为空"));
            } else {
                HashMap<String, String> e2 = d.b.g0.l.l.b.e(cVar);
                if (gVar.B() != null) {
                    e2.putAll(gVar.B());
                }
                gVar.D();
                f.b().B().b(d.b.g0.l.l.e.d(), e2, gVar.t(), new d.b.g0.l.l.i.b(gVar, cVar));
            }
        }
    }

    public static synchronized void b(d.b.g0.l.l.k.b bVar, d.b.g0.l.h.g gVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (bVar == null) {
                gVar.C(new d.b.g0.l.k.a(2100, "request对象为空"));
                return;
            }
            if (bVar.f() != null && !bVar.f().isEmpty()) {
                HashMap<String, String> b2 = d.b.g0.l.l.b.b(bVar);
                if (gVar.B() != null) {
                    b2.putAll(gVar.B());
                }
                JSONObject a2 = d.b.g0.l.l.b.a(bVar);
                if (a2 == null) {
                    gVar.C(new d.b.g0.l.k.a(2100, "构造请求body失败"));
                    return;
                }
                if (gVar.y() != null) {
                    try {
                        for (Map.Entry<String, String> entry : gVar.y().entrySet()) {
                            a2.put(entry.getKey(), entry.getValue());
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                gVar.D();
                f.b().B().a(d.b.g0.l.l.e.c(), b2, gVar.t(), a2, new d.b.g0.l.l.i.a(gVar, bVar));
                return;
            }
            gVar.C(new d.b.g0.l.k.a(2100, "pkg List为空"));
        }
    }

    public static synchronized void c(d.b.g0.l.l.k.d dVar, d.b.g0.l.h.g gVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (dVar == null) {
                gVar.C(new d.b.g0.l.k.a(2100, "request对象为空"));
                return;
            }
            HashMap<String, String> f2 = d.b.g0.l.l.b.f(dVar);
            if (gVar.B() != null) {
                f2.putAll(gVar.B());
            }
            gVar.D();
            f.b().B().b(d.b.g0.l.l.e.e(), f2, gVar.t(), new d.b.g0.l.l.i.c(gVar, dVar));
        }
    }

    public static synchronized void d(d.b.g0.l.l.k.f fVar, d.b.g0.l.h.g gVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (fVar == null) {
                gVar.C(new d.b.g0.l.k.a(2100, "request对象为空"));
            } else if (TextUtils.isEmpty(fVar.f())) {
                gVar.C(new d.b.g0.l.k.a(2100, "bundleId为空"));
            } else if (TextUtils.isEmpty(fVar.k())) {
                gVar.C(new d.b.g0.l.k.a(2100, "分包名为空"));
            } else {
                HashMap<String, String> g2 = d.b.g0.l.l.b.g(fVar);
                if (gVar.B() != null) {
                    g2.putAll(gVar.B());
                }
                gVar.D();
                f.b().B().b(d.b.g0.l.l.e.d(), g2, gVar.t(), new d.b.g0.l.l.i.d(gVar, fVar));
            }
        }
    }

    public static JSONObject e(@Nullable d.b.g0.l.m.c<JSONArray> cVar, @Nullable d.b.g0.l.m.c<JSONObject> cVar2) {
        return d.b.g0.l.m.f.a(cVar, cVar2);
    }

    public static synchronized boolean f(String str) {
        boolean c2;
        synchronized (c.class) {
            c2 = d.b.g0.l.l.h.f.d.b().c(str);
        }
        return c2;
    }

    public static synchronized boolean g(String str) {
        boolean d2;
        synchronized (c.class) {
            d2 = d.b.g0.l.l.h.f.d.b().d(str);
        }
        return d2;
    }

    public static synchronized void h(h hVar, d.b.g0.l.h.g gVar) {
        synchronized (c.class) {
            i(hVar, gVar, null);
        }
    }

    public static synchronized void i(h hVar, d.b.g0.l.h.g gVar, d.b.g0.l.h.g gVar2) {
        synchronized (c.class) {
            j(hVar, gVar, gVar2, null);
        }
    }

    public static synchronized void j(h hVar, d.b.g0.l.h.g gVar, d.b.g0.l.h.g gVar2, @Nullable d.b.g0.l.n.a.a aVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (hVar == null) {
                gVar.C(new d.b.g0.l.k.a(2100, "request对象为空"));
                return;
            }
            d.b.g0.l.m.c<JSONArray> p = aVar == null ? null : aVar.p();
            d.b.g0.l.h.g m = aVar == null ? null : aVar.m();
            HashMap hashMap = new HashMap();
            if (gVar.B() != null) {
                hashMap.putAll(gVar.B());
            }
            gVar.D();
            f.b().B().a(d.b.g0.l.l.e.f(), hashMap, gVar.t(), e(p, null), new d.b.g0.l.l.i.e(gVar, hVar, gVar2, m));
        }
    }

    public static synchronized void k(d.b.g0.l.n.a.a aVar) {
        synchronized (c.class) {
            if (aVar == null) {
                return;
            }
            d.b.g0.l.h.g m = aVar.m();
            if (m == null) {
                return;
            }
            d.b.g0.l.l.k.g request = aVar.getRequest();
            if (request == null) {
                m.C(new d.b.g0.l.k.a(2100, "request对象为空"));
                return;
            }
            Map<String, String> B = m.B();
            if (m.B() != null) {
                B = new HashMap(B);
            }
            m.D();
            f.b().B().a(d.b.g0.l.l.e.f(), B, m.t(), e(aVar.p(), null), new d.b.g0.l.l.i.e(m, request, null, m));
        }
    }
}
