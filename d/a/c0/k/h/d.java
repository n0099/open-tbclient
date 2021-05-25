package d.a.c0.k.h;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.poly.util.HttpSigner;
import d.a.c0.n.e;
import d.a.c0.n.f;
import d.a.c0.n.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f39439a;

    /* renamed from: b  reason: collision with root package name */
    public static String f39440b;

    /* renamed from: c  reason: collision with root package name */
    public static String f39441c;

    /* renamed from: d  reason: collision with root package name */
    public static String f39442d;

    /* renamed from: e  reason: collision with root package name */
    public static String f39443e;

    /* renamed from: f  reason: collision with root package name */
    public static List<d.a.c0.k.h.b> f39444f;

    /* renamed from: g  reason: collision with root package name */
    public static Object f39445g = new Object();

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            d.i();
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.a.c0.k.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c0.k.a.c f39446a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.c0.k.a.b f39447b;

        public b(d.a.c0.k.a.c cVar, d.a.c0.k.a.b bVar) {
            this.f39446a = cVar;
            this.f39447b = bVar;
        }

        @Override // d.a.c0.k.a.a
        public void a(Object obj) {
        }

        @Override // d.a.c0.k.a.a
        public void b(Throwable th, String str) {
            d.f(this.f39446a.c(), this.f39447b.c());
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.a.c0.k.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONArray f39448a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f39449b;

        public c(JSONArray jSONArray, JSONObject jSONObject) {
            this.f39448a = jSONArray;
            this.f39449b = jSONObject;
        }

        @Override // d.a.c0.k.a.a
        public void a(Object obj) {
        }

        @Override // d.a.c0.k.a.a
        public void b(Throwable th, String str) {
            this.f39448a.put(this.f39449b);
        }
    }

    public static void a() {
        f39439a = null;
        f39440b = null;
        f39441c = null;
        f39442d = null;
        f39443e = null;
    }

    public static void b(d.a.c0.k.h.b bVar) {
        if (f39444f == null) {
            f39444f = new ArrayList();
        }
        if (bVar != null) {
            synchronized (f39445g) {
                f39444f.add(bVar);
            }
        }
    }

    public static void e(int i2, String str) {
        d.a.c0.k.h.b bVar;
        if (i2 == 0) {
            bVar = new d.a.c0.k.h.b("2");
        } else if (i2 != 2) {
            bVar = i2 != 3 ? null : new d.a.c0.k.h.b("3");
        } else {
            bVar = new d.a.c0.k.h.b("4");
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
        d.a.c0.n.c.b(jSONArray.toString(), new File(g.a().getFilesDir(), "poly_cashier_statistics.json"));
    }

    public static void h() {
        List<d.a.c0.k.h.b> list = f39444f;
        if (list != null) {
            list.clear();
        }
    }

    public static synchronized void i() {
        synchronized (d.class) {
            List<d.a.c0.k.h.b> list = f39444f;
            if (list != null && !list.isEmpty()) {
                d.a.c0.k.a.b m = m();
                synchronized (f39445g) {
                    JSONArray jSONArray = new JSONArray();
                    for (d.a.c0.k.h.b bVar : f39444f) {
                        JSONObject a2 = bVar.a();
                        if (a2 != null) {
                            jSONArray.put(a2);
                        }
                    }
                    m.e("data", jSONArray.toString());
                    m.e("s", HttpSigner.a(m, "key", d.a.c0.k.b.a.d()));
                    h();
                }
                d.a.c0.k.a.c k = k();
                if (f.a()) {
                    n();
                    new d.a.c0.k.h.c().a(k, m, new b(k, m));
                } else {
                    f(k.c(), m.c());
                }
            }
        }
    }

    public static void j() {
        d.a.c0.m.a.a(new a());
    }

    public static d.a.c0.k.a.c k() {
        d.a.c0.k.a.c cVar = new d.a.c0.k.a.c();
        if (!TextUtils.isEmpty(f39439a)) {
            cVar.e("Cookie", "BDUSS=" + f39439a);
        }
        return cVar;
    }

    public static JSONArray l() {
        File file = new File(g.a().getFilesDir(), "poly_cashier_statistics.json");
        if (file.exists()) {
            try {
                JSONArray jSONArray = new JSONArray(d.a.c0.n.c.d(file));
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

    public static d.a.c0.k.a.b m() {
        d.a.c0.k.a.b bVar = new d.a.c0.k.a.b();
        bVar.e("dm", "cashier");
        bVar.e(IAdRequestParam.OS, "android");
        bVar.e("v", "2.7.7");
        if (!TextUtils.isEmpty(f39443e)) {
            bVar.e("n", f39443e);
        }
        if (!TextUtils.isEmpty(f39440b)) {
            bVar.e("d", f39440b);
        }
        if (!TextUtils.isEmpty(f39441c)) {
            bVar.e("dt", f39441c);
        }
        if (!TextUtils.isEmpty(f39442d)) {
            bVar.e("dp", f39442d);
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
                    d.a.c0.k.a.c cVar = new d.a.c0.k.a.c();
                    cVar.a(e.d(jSONObject.optJSONObject("header")));
                    d.a.c0.k.a.b bVar = new d.a.c0.k.a.b();
                    bVar.a(e.d(jSONObject.optJSONObject("body")));
                    new d.a.c0.k.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                g(jSONArray);
            } catch (Exception unused) {
            }
        }
    }
}
