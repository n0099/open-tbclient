package d.a.a0.k.h;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.poly.util.HttpSigner;
import d.a.a0.n.e;
import d.a.a0.n.f;
import d.a.a0.n.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f39174a;

    /* renamed from: b  reason: collision with root package name */
    public static String f39175b;

    /* renamed from: c  reason: collision with root package name */
    public static String f39176c;

    /* renamed from: d  reason: collision with root package name */
    public static String f39177d;

    /* renamed from: e  reason: collision with root package name */
    public static String f39178e;

    /* renamed from: f  reason: collision with root package name */
    public static List<d.a.a0.k.h.b> f39179f;

    /* renamed from: g  reason: collision with root package name */
    public static Object f39180g = new Object();

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            d.i();
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.a.a0.k.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.a0.k.a.c f39181a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.a0.k.a.b f39182b;

        public b(d.a.a0.k.a.c cVar, d.a.a0.k.a.b bVar) {
            this.f39181a = cVar;
            this.f39182b = bVar;
        }

        @Override // d.a.a0.k.a.a
        public void a(Object obj) {
        }

        @Override // d.a.a0.k.a.a
        public void b(Throwable th, String str) {
            d.f(this.f39181a.c(), this.f39182b.c());
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.a.a0.k.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONArray f39183a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f39184b;

        public c(JSONArray jSONArray, JSONObject jSONObject) {
            this.f39183a = jSONArray;
            this.f39184b = jSONObject;
        }

        @Override // d.a.a0.k.a.a
        public void a(Object obj) {
        }

        @Override // d.a.a0.k.a.a
        public void b(Throwable th, String str) {
            this.f39183a.put(this.f39184b);
        }
    }

    public static void a() {
        f39174a = null;
        f39175b = null;
        f39176c = null;
        f39177d = null;
        f39178e = null;
    }

    public static void b(d.a.a0.k.h.b bVar) {
        if (f39179f == null) {
            f39179f = new ArrayList();
        }
        if (bVar != null) {
            synchronized (f39180g) {
                f39179f.add(bVar);
            }
        }
    }

    public static void e(int i2, String str) {
        d.a.a0.k.h.b bVar;
        if (i2 == 0) {
            bVar = new d.a.a0.k.h.b("2");
        } else if (i2 != 2) {
            bVar = i2 != 3 ? null : new d.a.a0.k.h.b("3");
        } else {
            bVar = new d.a.a0.k.h.b("4");
        }
        if (bVar != null) {
            bVar.c(str);
            b(bVar);
        }
    }

    public static void f(Map map, Map map2) {
        try {
            JSONArray l = l();
            if (l != null) {
                if (l.length() >= 20) {
                    l.remove(0);
                }
            } else {
                l = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject c2 = e.c(map);
            JSONObject c3 = e.c(map2);
            jSONObject.put("header", c2);
            jSONObject.put("body", c3);
            l.put(jSONObject);
            g(l);
        } catch (Exception unused) {
        }
    }

    public static void g(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        d.a.a0.n.c.b(jSONArray.toString(), new File(g.a().getFilesDir(), "poly_cashier_statistics.json"));
    }

    public static void h() {
        List<d.a.a0.k.h.b> list = f39179f;
        if (list != null) {
            list.clear();
        }
    }

    public static synchronized void i() {
        synchronized (d.class) {
            List<d.a.a0.k.h.b> list = f39179f;
            if (list != null && !list.isEmpty()) {
                d.a.a0.k.a.b m = m();
                synchronized (f39180g) {
                    JSONArray jSONArray = new JSONArray();
                    for (d.a.a0.k.h.b bVar : f39179f) {
                        JSONObject a2 = bVar.a();
                        if (a2 != null) {
                            jSONArray.put(a2);
                        }
                    }
                    m.e("data", jSONArray.toString());
                    m.e("s", HttpSigner.a(m, "key", d.a.a0.k.b.a.d()));
                    h();
                }
                d.a.a0.k.a.c k = k();
                if (f.a()) {
                    n();
                    new d.a.a0.k.h.c().a(k, m, new b(k, m));
                } else {
                    f(k.c(), m.c());
                }
            }
        }
    }

    public static void j() {
        d.a.a0.m.a.a(new a());
    }

    public static d.a.a0.k.a.c k() {
        d.a.a0.k.a.c cVar = new d.a.a0.k.a.c();
        if (!TextUtils.isEmpty(f39174a)) {
            cVar.e("Cookie", "BDUSS=" + f39174a);
        }
        return cVar;
    }

    public static JSONArray l() {
        File file = new File(g.a().getFilesDir(), "poly_cashier_statistics.json");
        if (file.exists()) {
            try {
                JSONArray jSONArray = new JSONArray(d.a.a0.n.c.d(file));
                try {
                    file.delete();
                } catch (Exception unused) {
                }
                return jSONArray;
            } catch (Exception unused2) {
                return null;
            }
        }
        return null;
    }

    public static d.a.a0.k.a.b m() {
        d.a.a0.k.a.b bVar = new d.a.a0.k.a.b();
        bVar.e("dm", "cashier");
        bVar.e(IAdRequestParam.OS, "android");
        bVar.e("v", "2.7.5");
        if (!TextUtils.isEmpty(f39178e)) {
            bVar.e("n", f39178e);
        }
        if (!TextUtils.isEmpty(f39175b)) {
            bVar.e("d", f39175b);
        }
        if (!TextUtils.isEmpty(f39176c)) {
            bVar.e("dt", f39176c);
        }
        if (!TextUtils.isEmpty(f39177d)) {
            bVar.e("dp", f39177d);
        }
        return bVar;
    }

    public static void n() {
        JSONArray l = l();
        if (l != null && l.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < l.length(); i2++) {
                    JSONObject jSONObject = l.getJSONObject(i2);
                    d.a.a0.k.a.c cVar = new d.a.a0.k.a.c();
                    cVar.a(e.d(jSONObject.optJSONObject("header")));
                    d.a.a0.k.a.b bVar = new d.a.a0.k.a.b();
                    bVar.a(e.d(jSONObject.optJSONObject("body")));
                    new d.a.a0.k.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                g(jSONArray);
            } catch (Exception unused) {
            }
        }
    }
}
