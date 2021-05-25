package d.a.m0.b;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.m0.b.f.f;
import d.a.m0.b.f.g;
import d.a.m0.b.f.h;
import d.a.m0.b.f.i;
import d.a.m0.b.f.j;
import d.a.m0.b.f.k;
import d.a.m0.b.f.m;
import d.a.m0.b.f.n;
import d.a.m0.b.f.o;
import d.a.m0.b.f.p;
import d.a.m0.b.f.q;
import d.a.m0.b.f.r;
import d.a.m0.b.f.s;
import d.a.m0.b.f.t;
import d.a.m0.b.f.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static c f48824d;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, e> f48825a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<BdUniqueId, d.a.m0.b.f.a> f48826b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<BdUniqueId, e> f48827c = new HashMap<>();

    public c() {
        m();
        j(c());
    }

    public static c d() {
        if (f48824d == null) {
            synchronized (c.class) {
                if (f48824d == null) {
                    f48824d = new c();
                }
            }
        }
        return f48824d;
    }

    public static String e() {
        return "ubs_abtest_config";
    }

    public final void a() {
        d.a.m0.r.d0.b.j().v("static_opt_open", d.J() ? 1 : 0);
    }

    public synchronized e b(String str) {
        return this.f48825a.get(str);
    }

    public final HashMap<String, e> c() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            e();
            JSONArray jSONArray = new JSONArray(d.a.m0.r.d0.b.j().p(e(), "[]"));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("sid");
                    hashMap.put(optString, new e(optString));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return hashMap;
    }

    public e f(BdUniqueId bdUniqueId) {
        d.a.m0.b.f.a aVar = this.f48826b.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.b();
    }

    public Map<BdUniqueId, e> g() {
        return this.f48827c;
    }

    public void h(JSONArray jSONArray) {
        try {
            String e2 = e();
            if (jSONArray == null) {
                this.f48825a.clear();
                d.a.m0.r.d0.b.j().C(e2);
                return;
            }
            HashMap<String, e> hashMap = new HashMap<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("sid");
                    hashMap.put(optString, new e(optString));
                }
            }
            j(hashMap);
            d.a.m0.r.d0.b.j().x(e2, jSONArray.toString());
            a();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                h(null);
            } else {
                h(new JSONArray(str));
            }
        } catch (Exception unused) {
        }
    }

    public final void j(HashMap<String, e> hashMap) {
        synchronized (this.f48825a) {
            this.f48825a.clear();
            if (hashMap != null) {
                this.f48825a.putAll(hashMap);
            }
            k();
        }
    }

    public final void k() {
        for (Map.Entry<BdUniqueId, d.a.m0.b.f.a> entry : this.f48826b.entrySet()) {
            d.a.m0.b.f.a value = entry.getValue();
            if (value != null) {
                o(value);
            }
        }
        l();
    }

    public final void l() {
        this.f48827c.clear();
        for (BdUniqueId bdUniqueId : this.f48826b.keySet()) {
            this.f48827c.put(bdUniqueId, f(bdUniqueId));
        }
    }

    public final void m() {
        n(new t());
        n(new i());
        n(new k());
        n(new f());
        n(new q());
        n(new d.a.m0.b.f.b());
        n(new d.a.m0.b.f.c());
        n(new s());
        n(new h());
        n(new g());
        n(new m());
        n(new u());
        n(new n());
        n(new r());
        n(new o());
        n(new j());
        n(new p());
        n(new d.a.m0.b.f.e());
        n(new d.a.m0.b.f.d());
    }

    public void n(d.a.m0.b.f.a aVar) {
        if (aVar == null || aVar.c() == null) {
            return;
        }
        this.f48826b.put(aVar.c(), aVar);
    }

    public final void o(d.a.m0.b.f.a aVar) {
        if (aVar == null) {
            return;
        }
        ArrayList<String> a2 = aVar.a();
        e eVar = null;
        if (ListUtils.isEmpty(a2)) {
            aVar.f(null);
            return;
        }
        Iterator<String> it = a2.iterator();
        while (it.hasNext()) {
            eVar = this.f48825a.get(it.next());
            if (eVar != null) {
                break;
            }
        }
        aVar.f(eVar);
    }
}
