package d.a.i0.b;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.i0.b.f.f;
import d.a.i0.b.f.g;
import d.a.i0.b.f.h;
import d.a.i0.b.f.i;
import d.a.i0.b.f.j;
import d.a.i0.b.f.l;
import d.a.i0.b.f.m;
import d.a.i0.b.f.n;
import d.a.i0.b.f.o;
import d.a.i0.b.f.p;
import d.a.i0.b.f.q;
import d.a.i0.b.f.r;
import d.a.i0.b.f.s;
import d.a.i0.b.f.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static c f47974d;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, e> f47975a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<BdUniqueId, d.a.i0.b.f.a> f47976b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<BdUniqueId, e> f47977c = new HashMap<>();

    public c() {
        m();
        j(c());
    }

    public static c d() {
        if (f47974d == null) {
            synchronized (c.class) {
                if (f47974d == null) {
                    f47974d = new c();
                }
            }
        }
        return f47974d;
    }

    public static String e() {
        return "ubs_abtest_config";
    }

    public final void a() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921506, 1));
        d.a.i0.r.d0.b.j().v("static_opt_open", d.I() ? 1 : 0);
    }

    public synchronized e b(String str) {
        return this.f47975a.get(str);
    }

    public final HashMap<String, e> c() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            e();
            JSONArray jSONArray = new JSONArray(d.a.i0.r.d0.b.j().p(e(), "[]"));
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
        d.a.i0.b.f.a aVar = this.f47976b.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.b();
    }

    public Map<BdUniqueId, e> g() {
        return this.f47977c;
    }

    public void h(JSONArray jSONArray) {
        try {
            String e2 = e();
            if (jSONArray == null) {
                this.f47975a.clear();
                d.a.i0.r.d0.b.j().C(e2);
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
            d.a.i0.r.d0.b.j().x(e2, jSONArray.toString());
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
        synchronized (this.f47975a) {
            this.f47975a.clear();
            if (hashMap != null) {
                this.f47975a.putAll(hashMap);
            }
            k();
        }
    }

    public final void k() {
        for (Map.Entry<BdUniqueId, d.a.i0.b.f.a> entry : this.f47976b.entrySet()) {
            d.a.i0.b.f.a value = entry.getValue();
            if (value != null) {
                o(value);
            }
        }
        l();
    }

    public final void l() {
        this.f47977c.clear();
        for (BdUniqueId bdUniqueId : this.f47976b.keySet()) {
            this.f47977c.put(bdUniqueId, f(bdUniqueId));
        }
    }

    public final void m() {
        n(new s());
        n(new h());
        n(new j());
        n(new d.a.i0.b.f.e());
        n(new p());
        n(new d.a.i0.b.f.b());
        n(new d.a.i0.b.f.c());
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
        n(new d.a.i0.b.f.d());
    }

    public void n(d.a.i0.b.f.a aVar) {
        if (aVar == null || aVar.c() == null) {
            return;
        }
        this.f47976b.put(aVar.c(), aVar);
    }

    public final void o(d.a.i0.b.f.a aVar) {
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
            eVar = this.f47975a.get(it.next());
            if (eVar != null) {
                break;
            }
        }
        aVar.f(eVar);
    }
}
