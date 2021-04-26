package d.a.h0.l;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import d.a.h0.l.l.k.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static synchronized void a(d.a.h0.l.l.k.c cVar, d.a.h0.l.h.g gVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (cVar == null) {
                gVar.B(new d.a.h0.l.k.a(2100, "request对象为空"));
            } else if (TextUtils.isEmpty(cVar.g())) {
                gVar.B(new d.a.h0.l.k.a(2100, "bundleId为空"));
            } else {
                HashMap<String, String> e2 = d.a.h0.l.l.b.e(cVar);
                if (gVar.A() != null) {
                    e2.putAll(gVar.A());
                }
                gVar.C();
                f.b().C().b(d.a.h0.l.l.e.d(), e2, gVar.s(), new d.a.h0.l.l.i.b(gVar, cVar));
            }
        }
    }

    public static synchronized void b(d.a.h0.l.l.k.b bVar, d.a.h0.l.h.g gVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (bVar == null) {
                gVar.B(new d.a.h0.l.k.a(2100, "request对象为空"));
                return;
            }
            if (bVar.f() != null && !bVar.f().isEmpty()) {
                HashMap<String, String> b2 = d.a.h0.l.l.b.b(bVar);
                if (gVar.A() != null) {
                    b2.putAll(gVar.A());
                }
                JSONObject a2 = d.a.h0.l.l.b.a(bVar);
                if (a2 == null) {
                    gVar.B(new d.a.h0.l.k.a(2100, "构造请求body失败"));
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
                f.b().C().a(d.a.h0.l.l.e.c(), b2, gVar.s(), a2, new d.a.h0.l.l.i.a(gVar, bVar));
                return;
            }
            gVar.B(new d.a.h0.l.k.a(2100, "pkg List为空"));
        }
    }

    public static synchronized void c(d.a.h0.l.l.k.d dVar, d.a.h0.l.h.g gVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (dVar == null) {
                gVar.B(new d.a.h0.l.k.a(2100, "request对象为空"));
                return;
            }
            HashMap<String, String> f2 = d.a.h0.l.l.b.f(dVar);
            if (gVar.A() != null) {
                f2.putAll(gVar.A());
            }
            gVar.C();
            f.b().C().b(d.a.h0.l.l.e.e(), f2, gVar.s(), new d.a.h0.l.l.i.c(gVar, dVar));
        }
    }

    public static synchronized void d(d.a.h0.l.l.k.f fVar, d.a.h0.l.h.g gVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (fVar == null) {
                gVar.B(new d.a.h0.l.k.a(2100, "request对象为空"));
            } else if (TextUtils.isEmpty(fVar.f())) {
                gVar.B(new d.a.h0.l.k.a(2100, "bundleId为空"));
            } else if (TextUtils.isEmpty(fVar.k())) {
                gVar.B(new d.a.h0.l.k.a(2100, "分包名为空"));
            } else {
                HashMap<String, String> g2 = d.a.h0.l.l.b.g(fVar);
                if (gVar.A() != null) {
                    g2.putAll(gVar.A());
                }
                gVar.C();
                f.b().C().b(d.a.h0.l.l.e.d(), g2, gVar.s(), new d.a.h0.l.l.i.d(gVar, fVar));
            }
        }
    }

    public static JSONObject e(@Nullable d.a.h0.l.m.c<JSONArray> cVar, @Nullable d.a.h0.l.m.c<JSONObject> cVar2) {
        return d.a.h0.l.m.f.a(cVar, cVar2);
    }

    public static synchronized boolean f(String str) {
        boolean c2;
        synchronized (c.class) {
            c2 = d.a.h0.l.l.h.f.d.b().c(str);
        }
        return c2;
    }

    public static synchronized boolean g(String str) {
        boolean d2;
        synchronized (c.class) {
            d2 = d.a.h0.l.l.h.f.d.b().d(str);
        }
        return d2;
    }

    public static synchronized void h(h hVar, d.a.h0.l.h.g gVar) {
        synchronized (c.class) {
            i(hVar, gVar, null);
        }
    }

    public static synchronized void i(h hVar, d.a.h0.l.h.g gVar, d.a.h0.l.h.g gVar2) {
        synchronized (c.class) {
            j(hVar, gVar, gVar2, null);
        }
    }

    public static synchronized void j(h hVar, d.a.h0.l.h.g gVar, d.a.h0.l.h.g gVar2, @Nullable d.a.h0.l.n.a.a aVar) {
        synchronized (c.class) {
            if (gVar == null) {
                return;
            }
            if (hVar == null) {
                gVar.B(new d.a.h0.l.k.a(2100, "request对象为空"));
                return;
            }
            d.a.h0.l.m.c<JSONArray> h2 = aVar == null ? null : aVar.h();
            d.a.h0.l.h.g o = aVar == null ? null : aVar.o();
            HashMap hashMap = new HashMap();
            if (gVar.A() != null) {
                hashMap.putAll(gVar.A());
            }
            gVar.C();
            f.b().C().a(d.a.h0.l.l.e.f(), hashMap, gVar.s(), e(h2, null), new d.a.h0.l.l.i.e(gVar, hVar, gVar2, o));
        }
    }

    public static synchronized void k(d.a.h0.l.n.a.a aVar) {
        synchronized (c.class) {
            if (aVar == null) {
                return;
            }
            d.a.h0.l.h.g o = aVar.o();
            if (o == null) {
                return;
            }
            d.a.h0.l.l.k.g request = aVar.getRequest();
            if (request == null) {
                o.B(new d.a.h0.l.k.a(2100, "request对象为空"));
                return;
            }
            Map<String, String> A = o.A();
            if (o.A() != null) {
                A = new HashMap(A);
            }
            o.C();
            f.b().C().a(d.a.h0.l.l.e.f(), A, o.s(), e(aVar.h(), null), new d.a.h0.l.l.i.e(o, request, null, o));
        }
    }
}
