package d.b.h0.b;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.h0.b.f.f;
import d.b.h0.b.f.g;
import d.b.h0.b.f.h;
import d.b.h0.b.f.i;
import d.b.h0.b.f.j;
import d.b.h0.b.f.l;
import d.b.h0.b.f.m;
import d.b.h0.b.f.n;
import d.b.h0.b.f.o;
import d.b.h0.b.f.p;
import d.b.h0.b.f.q;
import d.b.h0.b.f.r;
import d.b.h0.b.f.s;
import d.b.h0.b.f.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static c f49691d;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, e> f49692a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<BdUniqueId, d.b.h0.b.f.a> f49693b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<BdUniqueId, e> f49694c = new HashMap<>();

    public c() {
        m();
        j(c());
    }

    public static c d() {
        if (f49691d == null) {
            synchronized (c.class) {
                if (f49691d == null) {
                    f49691d = new c();
                }
            }
        }
        return f49691d;
    }

    public static String e() {
        return "ubs_abtest_config";
    }

    public final void a() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921506, 1));
        d.b.h0.r.d0.b.i().u("static_opt_open", d.G() ? 1 : 0);
    }

    public synchronized e b(String str) {
        return this.f49692a.get(str);
    }

    public final HashMap<String, e> c() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            e();
            JSONArray jSONArray = new JSONArray(d.b.h0.r.d0.b.i().o(e(), "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
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
        d.b.h0.b.f.a aVar = this.f49693b.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.b();
    }

    public Map<BdUniqueId, e> g() {
        return this.f49694c;
    }

    public void h(JSONArray jSONArray) {
        try {
            String e2 = e();
            if (jSONArray == null) {
                this.f49692a.clear();
                d.b.h0.r.d0.b.i().B(e2);
                return;
            }
            HashMap<String, e> hashMap = new HashMap<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("sid");
                    hashMap.put(optString, new e(optString));
                }
            }
            j(hashMap);
            d.b.h0.r.d0.b.i().w(e2, jSONArray.toString());
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
        synchronized (this.f49692a) {
            this.f49692a.clear();
            if (hashMap != null) {
                this.f49692a.putAll(hashMap);
            }
            k();
        }
    }

    public final void k() {
        for (Map.Entry<BdUniqueId, d.b.h0.b.f.a> entry : this.f49693b.entrySet()) {
            d.b.h0.b.f.a value = entry.getValue();
            if (value != null) {
                o(value);
            }
        }
        l();
    }

    public final void l() {
        this.f49694c.clear();
        for (BdUniqueId bdUniqueId : this.f49693b.keySet()) {
            this.f49694c.put(bdUniqueId, f(bdUniqueId));
        }
    }

    public final void m() {
        n(new s());
        n(new h());
        n(new j());
        n(new d.b.h0.b.f.e());
        n(new p());
        n(new d.b.h0.b.f.b());
        n(new d.b.h0.b.f.c());
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
        n(new d.b.h0.b.f.d());
    }

    public void n(d.b.h0.b.f.a aVar) {
        if (aVar == null || aVar.c() == null) {
            return;
        }
        this.f49693b.put(aVar.c(), aVar);
    }

    public final void o(d.b.h0.b.f.a aVar) {
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
            eVar = this.f49692a.get(it.next());
            if (eVar != null) {
                break;
            }
        }
        aVar.f(eVar);
    }
}
