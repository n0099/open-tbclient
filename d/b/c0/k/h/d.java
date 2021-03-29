package d.b.c0.k.h;

import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.poly.util.HttpSigner;
import d.b.c0.n.e;
import d.b.c0.n.f;
import d.b.c0.n.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f42623a;

    /* renamed from: b  reason: collision with root package name */
    public static String f42624b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42625c;

    /* renamed from: d  reason: collision with root package name */
    public static String f42626d;

    /* renamed from: e  reason: collision with root package name */
    public static String f42627e;

    /* renamed from: f  reason: collision with root package name */
    public static List<d.b.c0.k.h.b> f42628f;

    /* renamed from: g  reason: collision with root package name */
    public static Object f42629g = new Object();

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            d.i();
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.b.c0.k.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.c0.k.a.c f42630a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.c0.k.a.b f42631b;

        public b(d.b.c0.k.a.c cVar, d.b.c0.k.a.b bVar) {
            this.f42630a = cVar;
            this.f42631b = bVar;
        }

        @Override // d.b.c0.k.a.a
        public void a(Object obj) {
        }

        @Override // d.b.c0.k.a.a
        public void b(Throwable th, String str) {
            d.f(this.f42630a.c(), this.f42631b.c());
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.b.c0.k.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONArray f42632a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42633b;

        public c(JSONArray jSONArray, JSONObject jSONObject) {
            this.f42632a = jSONArray;
            this.f42633b = jSONObject;
        }

        @Override // d.b.c0.k.a.a
        public void a(Object obj) {
        }

        @Override // d.b.c0.k.a.a
        public void b(Throwable th, String str) {
            this.f42632a.put(this.f42633b);
        }
    }

    public static void a() {
        f42623a = null;
        f42624b = null;
        f42625c = null;
        f42626d = null;
        f42627e = null;
    }

    public static void b(d.b.c0.k.h.b bVar) {
        if (f42628f == null) {
            f42628f = new ArrayList();
        }
        if (bVar != null) {
            synchronized (f42629g) {
                f42628f.add(bVar);
            }
        }
    }

    public static void e(int i, String str) {
        d.b.c0.k.h.b bVar;
        if (i == 0) {
            bVar = new d.b.c0.k.h.b("2");
        } else if (i != 2) {
            bVar = i != 3 ? null : new d.b.c0.k.h.b("3");
        } else {
            bVar = new d.b.c0.k.h.b("4");
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
        d.b.c0.n.c.b(jSONArray.toString(), new File(g.a().getFilesDir(), "poly_cashier_statistics.json"));
    }

    public static void h() {
        List<d.b.c0.k.h.b> list = f42628f;
        if (list != null) {
            list.clear();
        }
    }

    public static synchronized void i() {
        synchronized (d.class) {
            List<d.b.c0.k.h.b> list = f42628f;
            if (list != null && !list.isEmpty()) {
                d.b.c0.k.a.b m = m();
                synchronized (f42629g) {
                    JSONArray jSONArray = new JSONArray();
                    for (d.b.c0.k.h.b bVar : f42628f) {
                        JSONObject a2 = bVar.a();
                        if (a2 != null) {
                            jSONArray.put(a2);
                        }
                    }
                    m.e("data", jSONArray.toString());
                    m.e("s", HttpSigner.a(m, "key", d.b.c0.k.b.a.d()));
                    h();
                }
                d.b.c0.k.a.c k = k();
                if (f.a()) {
                    n();
                    new d.b.c0.k.h.c().a(k, m, new b(k, m));
                } else {
                    f(k.c(), m.c());
                }
            }
        }
    }

    public static void j() {
        d.b.c0.m.a.a(new a());
    }

    public static d.b.c0.k.a.c k() {
        d.b.c0.k.a.c cVar = new d.b.c0.k.a.c();
        if (!TextUtils.isEmpty(f42623a)) {
            cVar.e("Cookie", "BDUSS=" + f42623a);
        }
        return cVar;
    }

    public static JSONArray l() {
        File file = new File(g.a().getFilesDir(), "poly_cashier_statistics.json");
        if (file.exists()) {
            try {
                JSONArray jSONArray = new JSONArray(d.b.c0.n.c.d(file));
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

    public static d.b.c0.k.a.b m() {
        d.b.c0.k.a.b bVar = new d.b.c0.k.a.b();
        bVar.e("dm", "cashier");
        bVar.e(IXAdRequestInfo.OS, "android");
        bVar.e("v", "2.7.5");
        if (!TextUtils.isEmpty(f42627e)) {
            bVar.e("n", f42627e);
        }
        if (!TextUtils.isEmpty(f42624b)) {
            bVar.e("d", f42624b);
        }
        if (!TextUtils.isEmpty(f42625c)) {
            bVar.e("dt", f42625c);
        }
        if (!TextUtils.isEmpty(f42626d)) {
            bVar.e("dp", f42626d);
        }
        return bVar;
    }

    public static void n() {
        JSONArray l = l();
        if (l != null && l.length() != 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < l.length(); i++) {
                    JSONObject jSONObject = l.getJSONObject(i);
                    d.b.c0.k.a.c cVar = new d.b.c0.k.a.c();
                    cVar.a(e.d(jSONObject.optJSONObject("header")));
                    d.b.c0.k.a.b bVar = new d.b.c0.k.a.b();
                    bVar.a(e.d(jSONObject.optJSONObject("body")));
                    new d.b.c0.k.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                g(jSONArray);
            } catch (Exception unused) {
            }
        }
    }
}
