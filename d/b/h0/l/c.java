package d.b.h0.l;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import d.b.h0.l.l.k.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static synchronized void a(d.b.h0.l.l.k.c cVar, d.b.h0.l.h.g gVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (cVar == null) {
                gVar.B(new d.b.h0.l.k.a(2100, "request对象为空"));
            } else if (TextUtils.isEmpty(cVar.g())) {
                gVar.B(new d.b.h0.l.k.a(2100, "bundleId为空"));
            } else {
                HashMap<String, String> e2 = d.b.h0.l.l.b.e(cVar);
                if (gVar.A() != null) {
                    e2.putAll(gVar.A());
                }
                gVar.C();
                f.b().B().b(d.b.h0.l.l.e.d(), e2, gVar.s(), new d.b.h0.l.l.i.b(gVar, cVar));
            }
        }
    }

    public static synchronized void b(d.b.h0.l.l.k.b bVar, d.b.h0.l.h.g gVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (bVar == null) {
                gVar.B(new d.b.h0.l.k.a(2100, "request对象为空"));
                return;
            }
            if (bVar.f() != null && !bVar.f().isEmpty()) {
                HashMap<String, String> b2 = d.b.h0.l.l.b.b(bVar);
                if (gVar.A() != null) {
                    b2.putAll(gVar.A());
                }
                JSONObject a2 = d.b.h0.l.l.b.a(bVar);
                if (a2 == null) {
                    gVar.B(new d.b.h0.l.k.a(2100, "构造请求body失败"));
                    return;
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
                f.b().B().a(d.b.h0.l.l.e.c(), b2, gVar.s(), a2, new d.b.h0.l.l.i.a(gVar, bVar));
                return;
            }
            gVar.B(new d.b.h0.l.k.a(2100, "pkg List为空"));
        }
    }

    public static synchronized void c(d.b.h0.l.l.k.d dVar, d.b.h0.l.h.g gVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (dVar == null) {
                gVar.B(new d.b.h0.l.k.a(2100, "request对象为空"));
                return;
            }
            HashMap<String, String> f2 = d.b.h0.l.l.b.f(dVar);
            if (gVar.A() != null) {
                f2.putAll(gVar.A());
            }
            gVar.C();
            f.b().B().b(d.b.h0.l.l.e.e(), f2, gVar.s(), new d.b.h0.l.l.i.c(gVar, dVar));
        }
    }

    public static synchronized void d(d.b.h0.l.l.k.f fVar, d.b.h0.l.h.g gVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (fVar == null) {
                gVar.B(new d.b.h0.l.k.a(2100, "request对象为空"));
            } else if (TextUtils.isEmpty(fVar.f())) {
                gVar.B(new d.b.h0.l.k.a(2100, "bundleId为空"));
            } else if (TextUtils.isEmpty(fVar.k())) {
                gVar.B(new d.b.h0.l.k.a(2100, "分包名为空"));
            } else {
                HashMap<String, String> g2 = d.b.h0.l.l.b.g(fVar);
                if (gVar.A() != null) {
                    g2.putAll(gVar.A());
                }
                gVar.C();
                f.b().B().b(d.b.h0.l.l.e.d(), g2, gVar.s(), new d.b.h0.l.l.i.d(gVar, fVar));
            }
        }
    }

    public static JSONObject e(@Nullable d.b.h0.l.m.c<JSONArray> cVar, @Nullable d.b.h0.l.m.c<JSONObject> cVar2) {
        return d.b.h0.l.m.f.a(cVar, cVar2);
    }

    public static synchronized boolean f(String str) {
        boolean c2;
        synchronized (c.class) {
            c2 = d.b.h0.l.l.h.f.d.b().c(str);
        }
        return c2;
    }

    public static synchronized boolean g(String str) {
        boolean d2;
        synchronized (c.class) {
            d2 = d.b.h0.l.l.h.f.d.b().d(str);
        }
        return d2;
    }

    public static synchronized void h(h hVar, d.b.h0.l.h.g gVar) {
        synchronized (c.class) {
            i(hVar, gVar, null);
        }
    }

    public static synchronized void i(h hVar, d.b.h0.l.h.g gVar, d.b.h0.l.h.g gVar2) {
        synchronized (c.class) {
            j(hVar, gVar, gVar2, null);
        }
    }

    public static synchronized void j(h hVar, d.b.h0.l.h.g gVar, d.b.h0.l.h.g gVar2, @Nullable d.b.h0.l.n.a.a aVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (hVar == null) {
                gVar.B(new d.b.h0.l.k.a(2100, "request对象为空"));
                return;
            }
            d.b.h0.l.m.c<JSONArray> o = aVar == null ? null : aVar.o();
            d.b.h0.l.h.g m = aVar == null ? null : aVar.m();
            HashMap hashMap = new HashMap();
            if (gVar.A() != null) {
                hashMap.putAll(gVar.A());
            }
            gVar.C();
            f.b().B().a(d.b.h0.l.l.e.f(), hashMap, gVar.s(), e(o, null), new d.b.h0.l.l.i.e(gVar, hVar, gVar2, m));
        }
    }

    public static synchronized void k(d.b.h0.l.n.a.a aVar) {
        synchronized (c.class) {
            if (aVar == null) {
                return;
            }
            d.b.h0.l.h.g m = aVar.m();
            if (m == null) {
                return;
            }
            d.b.h0.l.l.k.g request = aVar.getRequest();
            if (request == null) {
                m.B(new d.b.h0.l.k.a(2100, "request对象为空"));
                return;
            }
            Map<String, String> A = m.A();
            if (m.A() != null) {
                A = new HashMap(A);
            }
            m.C();
            f.b().B().a(d.b.h0.l.l.e.f(), A, m.s(), e(aVar.o(), null), new d.b.h0.l.l.i.e(m, request, null, m));
        }
    }
}
