package d.a.j0.b;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.j0.b.f.f;
import d.a.j0.b.f.g;
import d.a.j0.b.f.h;
import d.a.j0.b.f.i;
import d.a.j0.b.f.j;
import d.a.j0.b.f.l;
import d.a.j0.b.f.m;
import d.a.j0.b.f.n;
import d.a.j0.b.f.o;
import d.a.j0.b.f.p;
import d.a.j0.b.f.q;
import d.a.j0.b.f.r;
import d.a.j0.b.f.s;
import d.a.j0.b.f.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static c f48802d;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, e> f48803a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<BdUniqueId, d.a.j0.b.f.a> f48804b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<BdUniqueId, e> f48805c = new HashMap<>();

    public c() {
        m();
        j(c());
    }

    public static c d() {
        if (f48802d == null) {
            synchronized (c.class) {
                if (f48802d == null) {
                    f48802d = new c();
                }
            }
        }
        return f48802d;
    }

    public static String e() {
        return "ubs_abtest_config";
    }

    public final void a() {
        d.a.j0.r.d0.b.j().v("static_opt_open", d.I() ? 1 : 0);
    }

    public synchronized e b(String str) {
        return this.f48803a.get(str);
    }

    public final HashMap<String, e> c() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            e();
            JSONArray jSONArray = new JSONArray(d.a.j0.r.d0.b.j().p(e(), "[]"));
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
        d.a.j0.b.f.a aVar = this.f48804b.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.b();
    }

    public Map<BdUniqueId, e> g() {
        return this.f48805c;
    }

    public void h(JSONArray jSONArray) {
        try {
            String e2 = e();
            if (jSONArray == null) {
                this.f48803a.clear();
                d.a.j0.r.d0.b.j().C(e2);
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
            d.a.j0.r.d0.b.j().x(e2, jSONArray.toString());
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
        synchronized (this.f48803a) {
            this.f48803a.clear();
            if (hashMap != null) {
                this.f48803a.putAll(hashMap);
            }
            k();
        }
    }

    public final void k() {
        for (Map.Entry<BdUniqueId, d.a.j0.b.f.a> entry : this.f48804b.entrySet()) {
            d.a.j0.b.f.a value = entry.getValue();
            if (value != null) {
                o(value);
            }
        }
        l();
    }

    public final void l() {
        this.f48805c.clear();
        for (BdUniqueId bdUniqueId : this.f48804b.keySet()) {
            this.f48805c.put(bdUniqueId, f(bdUniqueId));
        }
    }

    public final void m() {
        n(new s());
        n(new h());
        n(new j());
        n(new d.a.j0.b.f.e());
        n(new p());
        n(new d.a.j0.b.f.b());
        n(new d.a.j0.b.f.c());
        n(new r());
        n(new g());
        n(new f());
        n(new l());
        n(new t());
        n(new m());
        n(new q());
        n(new n());
        n(new i());
        n(new o());
        n(new d.a.j0.b.f.d());
    }

    public void n(d.a.j0.b.f.a aVar) {
        if (aVar == null || aVar.c() == null) {
            return;
        }
        this.f48804b.put(aVar.c(), aVar);
    }

    public final void o(d.a.j0.b.f.a aVar) {
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
            eVar = this.f48803a.get(it.next());
            if (eVar != null) {
                break;
            }
        }
        aVar.f(eVar);
    }
}
