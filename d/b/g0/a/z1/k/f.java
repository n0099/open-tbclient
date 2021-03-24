package d.b.g0.a.z1.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.b.g0.a.y0.e.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends e {
    public SwanCoreVersion j;
    public String k = "";
    public String l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    public String q = "";
    public String r = "";
    public String s = "";
    public String t = "";
    public String u = "";
    public String v;

    public f() {
        d.b.g0.a.z1.g.g(this);
        d.b.g0.a.z1.g.f(this);
        d.b.g0.a.z1.g.e(this);
    }

    @Override // d.b.g0.a.z1.k.e
    public JSONObject f() {
        try {
            d.b.g0.a.r1.e t = d.b.g0.a.z0.f.V().t();
            String g2 = d.b.g0.a.b2.b.g(this.j, this.f47250a == SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME ? 1 : 0);
            if (t != null && t.L() != null) {
                b.a L = t.L();
                if (TextUtils.isEmpty(this.k)) {
                    this.k = t.W();
                }
                if (TextUtils.isEmpty(this.l)) {
                    this.l = L.o1();
                }
                if (L.O() != null) {
                    this.n = L.O().getString("aiapp_extra_need_download", "");
                    this.p = L.n0().getString("aiapp_extra_preset_pkg", "0");
                    this.o = L.n0().getString("aiapp_extra_pkg_downloading", "0");
                }
                if (TextUtils.isEmpty(this.q)) {
                    this.q = L.V();
                }
                this.q = d.b.g0.a.z1.g.a(this.q);
                if (TextUtils.isEmpty(this.f47255f) && !TextUtils.isEmpty(L.b0())) {
                    this.t = L.b0();
                }
                this.t = d.b.g0.a.z1.g.a(this.t);
                if (TextUtils.isEmpty(this.v)) {
                    this.v = L.U();
                }
            }
            this.m = SwanAppNetworkUtils.f().type;
            if (this.f47256g == null) {
                this.f47256g = new JSONObject();
            }
            this.f47256g.put("swan", g2);
            this.f47256g.put("appversion", this.k);
            this.f47256g.put("thirdversion", this.l);
            this.f47256g.put("net", this.m);
            this.f47256g.put("needdown", this.n);
            this.f47256g.put("preset", this.p);
            this.f47256g.put("isPreDownloading", this.o);
            this.f47256g.put("scheme", this.q);
            this.f47256g.put("page", this.t);
            this.f47256g.put("error_code", this.u);
            this.f47256g.put("launchid", this.v);
            if (!TextUtils.isEmpty(this.r)) {
                this.f47256g.put("canceltime", this.r);
            }
            if (!TextUtils.isEmpty(this.s)) {
                this.f47256g.put("successtime", this.s);
            }
            if (e.i) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.f47256g + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e2) {
            if (e.i) {
                e2.printStackTrace();
            }
        }
        return super.f();
    }

    public String g() {
        return this.v;
    }

    public void h(d.b.g0.a.y0.e.e eVar) {
        if (eVar == null) {
            if (e.i) {
                Log.w("SwanAppUBCEvent", "launchinfo is null");
                return;
            }
            return;
        }
        this.f47254e = eVar.G();
        this.f47252c = eVar.S();
        this.n = eVar.n0().getString("aiapp_extra_need_download", "");
        this.p = eVar.n0().getString("aiapp_extra_preset_pkg", "");
        this.o = eVar.n0().getString("aiapp_extra_pkg_downloading", "0");
        this.q = eVar.V();
        this.t = eVar.b0();
        this.v = eVar.U();
    }

    public void i(d.b.g0.a.y0.e.e eVar) {
        h(eVar);
    }

    public void j(d.b.g0.a.y0.e.e eVar) {
        h(eVar);
    }

    public void k(String str) {
        this.v = str;
    }
}
