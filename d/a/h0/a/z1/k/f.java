package d.a.h0.a.z1.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.h0.a.y0.e.b;
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
        d.a.h0.a.z1.g.g(this);
        d.a.h0.a.z1.g.f(this);
        d.a.h0.a.z1.g.e(this);
    }

    @Override // d.a.h0.a.z1.k.e
    public JSONObject f() {
        try {
            d.a.h0.a.r1.e F = d.a.h0.a.z0.f.V().F();
            String g2 = d.a.h0.a.b2.b.g(this.j, this.f45411a == SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME ? 1 : 0);
            if (F != null && F.L() != null) {
                b.a L = F.L();
                if (TextUtils.isEmpty(this.k)) {
                    this.k = F.W();
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
                this.q = d.a.h0.a.z1.g.a(this.q);
                if (TextUtils.isEmpty(this.f45416f) && !TextUtils.isEmpty(L.b0())) {
                    this.t = L.b0();
                }
                this.t = d.a.h0.a.z1.g.a(this.t);
                if (TextUtils.isEmpty(this.v)) {
                    this.v = L.U();
                }
            }
            this.m = SwanAppNetworkUtils.f().type;
            if (this.f45417g == null) {
                this.f45417g = new JSONObject();
            }
            this.f45417g.put("swan", g2);
            this.f45417g.put("appversion", this.k);
            this.f45417g.put("thirdversion", this.l);
            this.f45417g.put("net", this.m);
            this.f45417g.put("needdown", this.n);
            this.f45417g.put("preset", this.p);
            this.f45417g.put("isPreDownloading", this.o);
            this.f45417g.put("scheme", this.q);
            this.f45417g.put("page", this.t);
            this.f45417g.put("error_code", this.u);
            this.f45417g.put("launchid", this.v);
            if (!TextUtils.isEmpty(this.r)) {
                this.f45417g.put("canceltime", this.r);
            }
            if (!TextUtils.isEmpty(this.s)) {
                this.f45417g.put("successtime", this.s);
            }
            if (e.f45410i) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.f45417g + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e2) {
            if (e.f45410i) {
                e2.printStackTrace();
            }
        }
        return super.f();
    }

    public String g() {
        return this.v;
    }

    public void h(d.a.h0.a.y0.e.e eVar) {
        if (eVar == null) {
            if (e.f45410i) {
                Log.w("SwanAppUBCEvent", "launchinfo is null");
                return;
            }
            return;
        }
        this.f45415e = eVar.G();
        this.f45413c = eVar.S();
        this.n = eVar.n0().getString("aiapp_extra_need_download", "");
        this.p = eVar.n0().getString("aiapp_extra_preset_pkg", "");
        this.o = eVar.n0().getString("aiapp_extra_pkg_downloading", "0");
        this.q = eVar.V();
        this.t = eVar.b0();
        this.v = eVar.U();
    }

    public void i(d.a.h0.a.y0.e.e eVar) {
        h(eVar);
    }

    public void j(d.a.h0.a.y0.e.e eVar) {
        h(eVar);
    }

    public void k(String str) {
        this.v = str;
    }
}
