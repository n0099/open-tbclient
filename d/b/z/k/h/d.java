package d.b.z.k.h;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.poly.util.HttpSigner;
import d.b.z.n.e;
import d.b.z.n.f;
import d.b.z.n.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f65691a;

    /* renamed from: b  reason: collision with root package name */
    public static String f65692b;

    /* renamed from: c  reason: collision with root package name */
    public static String f65693c;

    /* renamed from: d  reason: collision with root package name */
    public static String f65694d;

    /* renamed from: e  reason: collision with root package name */
    public static String f65695e;

    /* renamed from: f  reason: collision with root package name */
    public static List<d.b.z.k.h.b> f65696f;

    /* renamed from: g  reason: collision with root package name */
    public static Object f65697g = new Object();

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            d.i();
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.b.z.k.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.z.k.a.c f65698a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.z.k.a.b f65699b;

        public b(d.b.z.k.a.c cVar, d.b.z.k.a.b bVar) {
            this.f65698a = cVar;
            this.f65699b = bVar;
        }

        @Override // d.b.z.k.a.a
        public void a(Object obj) {
        }

        @Override // d.b.z.k.a.a
        public void b(Throwable th, String str) {
            d.f(this.f65698a.c(), this.f65699b.c());
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.b.z.k.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JSONArray f65700a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f65701b;

        public c(JSONArray jSONArray, JSONObject jSONObject) {
            this.f65700a = jSONArray;
            this.f65701b = jSONObject;
        }

        @Override // d.b.z.k.a.a
        public void a(Object obj) {
        }

        @Override // d.b.z.k.a.a
        public void b(Throwable th, String str) {
            this.f65700a.put(this.f65701b);
        }
    }

    public static void a() {
        f65691a = null;
        f65692b = null;
        f65693c = null;
        f65694d = null;
        f65695e = null;
    }

    public static void b(d.b.z.k.h.b bVar) {
        if (f65696f == null) {
            f65696f = new ArrayList();
        }
        if (bVar != null) {
            synchronized (f65697g) {
                f65696f.add(bVar);
            }
        }
    }

    public static void e(int i, String str) {
        d.b.z.k.h.b bVar;
        if (i == 0) {
            bVar = new d.b.z.k.h.b("2");
        } else if (i != 2) {
            bVar = i != 3 ? null : new d.b.z.k.h.b("3");
        } else {
            bVar = new d.b.z.k.h.b("4");
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
        d.b.z.n.c.b(jSONArray.toString(), new File(g.a().getFilesDir(), "poly_cashier_statistics.json"));
    }

    public static void h() {
        List<d.b.z.k.h.b> list = f65696f;
        if (list != null) {
            list.clear();
        }
    }

    public static synchronized void i() {
        synchronized (d.class) {
            List<d.b.z.k.h.b> list = f65696f;
            if (list != null && !list.isEmpty()) {
                d.b.z.k.a.b m = m();
                synchronized (f65697g) {
                    JSONArray jSONArray = new JSONArray();
                    for (d.b.z.k.h.b bVar : f65696f) {
                        JSONObject a2 = bVar.a();
                        if (a2 != null) {
                            jSONArray.put(a2);
                        }
                    }
                    m.e("data", jSONArray.toString());
                    m.e("s", HttpSigner.a(m, "key", d.b.z.k.b.a.d()));
                    h();
                }
                d.b.z.k.a.c k = k();
                if (f.a()) {
                    n();
                    new d.b.z.k.h.c().a(k, m, new b(k, m));
                } else {
                    f(k.c(), m.c());
                }
            }
        }
    }

    public static void j() {
        d.b.z.m.a.a(new a());
    }

    public static d.b.z.k.a.c k() {
        d.b.z.k.a.c cVar = new d.b.z.k.a.c();
        if (!TextUtils.isEmpty(f65691a)) {
            cVar.e("Cookie", "BDUSS=" + f65691a);
        }
        return cVar;
    }

    public static JSONArray l() {
        File file = new File(g.a().getFilesDir(), "poly_cashier_statistics.json");
        if (file.exists()) {
            try {
                JSONArray jSONArray = new JSONArray(d.b.z.n.c.d(file));
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

    public static d.b.z.k.a.b m() {
        d.b.z.k.a.b bVar = new d.b.z.k.a.b();
        bVar.e("dm", "cashier");
        bVar.e(IAdRequestParam.OS, "android");
        bVar.e("v", "2.7.5");
        if (!TextUtils.isEmpty(f65695e)) {
            bVar.e("n", f65695e);
        }
        if (!TextUtils.isEmpty(f65692b)) {
            bVar.e("d", f65692b);
        }
        if (!TextUtils.isEmpty(f65693c)) {
            bVar.e("dt", f65693c);
        }
        if (!TextUtils.isEmpty(f65694d)) {
            bVar.e("dp", f65694d);
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
                    d.b.z.k.a.c cVar = new d.b.z.k.a.c();
                    cVar.a(e.d(jSONObject.optJSONObject("header")));
                    d.b.z.k.a.b bVar = new d.b.z.k.a.b();
                    bVar.a(e.d(jSONObject.optJSONObject("body")));
                    new d.b.z.k.h.c().a(cVar, bVar, new c(jSONArray, jSONObject));
                }
                g(jSONArray);
            } catch (Exception unused) {
            }
        }
    }
}
