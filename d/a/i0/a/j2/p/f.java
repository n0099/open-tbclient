package d.a.i0.a.j2.p;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.j2.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends e {
    public SwanCoreVersion k;
    public String l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    public String q = "";
    public String r = "";
    public String s = "";
    public String t = "";
    public String u;

    public f() {
        j.h(this);
        j.g(this);
        j.e(this);
        j.f(this);
    }

    @Override // d.a.i0.a.j2.p.e
    public JSONObject f() {
        try {
            d.a.i0.a.a2.e F = d.a.i0.a.g1.f.V().F();
            String i2 = d.a.i0.a.m2.b.i(this.k, TextUtils.equals(this.f43011a, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME) ? 1 : 0);
            if (F != null && F.N() != null) {
                b.a N = F.N();
                if (TextUtils.isEmpty(this.l)) {
                    this.l = F.Z();
                }
                if (TextUtils.isEmpty(this.m)) {
                    this.m = N.v1();
                }
                Bundle P = N.P();
                if (P != null) {
                    this.o = P.getString("aiapp_extra_need_download", "");
                }
                if (TextUtils.isEmpty(this.p)) {
                    this.p = N.W();
                }
                this.p = j.a(this.p);
                if (TextUtils.isEmpty(this.f43017g) && !TextUtils.isEmpty(N.e0())) {
                    this.s = N.e0();
                }
                String a2 = j.a(this.s);
                this.s = a2;
                if (a2 == null) {
                    this.s = "";
                }
                if (TextUtils.isEmpty(this.u)) {
                    this.u = N.V();
                }
            }
            this.n = SwanAppNetworkUtils.f().type;
            if (this.f43018h == null) {
                this.f43018h = new JSONObject();
            }
            this.f43018h.put("swan", i2);
            this.f43018h.put("appversion", this.l);
            this.f43018h.put("thirdversion", this.m);
            this.f43018h.put("net", this.n);
            this.f43018h.put("needdown", this.o);
            this.f43018h.put("scheme", this.p);
            this.f43018h.put("page", this.s);
            this.f43018h.put("launchid", this.u);
            if (!TextUtils.isEmpty(this.t)) {
                this.f43018h.put("error_code", this.t);
            }
            if (!TextUtils.isEmpty(this.q)) {
                this.f43018h.put("canceltime", this.q);
            }
            if (!TextUtils.isEmpty(this.r)) {
                this.f43018h.put("successtime", this.r);
            }
            if (e.j) {
                Log.d("SwanAppUBCEvent", "SwanAppUBCEvent: mExt=" + this.f43018h + "\t " + Thread.currentThread().getId());
            }
        } catch (JSONException e2) {
            if (e.j) {
                e2.printStackTrace();
            }
        }
        return super.f();
    }

    public String g() {
        return this.u;
    }

    public void h(d.a.i0.a.f1.e.e eVar) {
        if (eVar == null) {
            if (e.j) {
                Log.w("SwanAppUBCEvent", "launchinfo is null");
                return;
            }
            return;
        }
        this.f43016f = eVar.H();
        this.f43013c = eVar.T();
        this.o = eVar.r0().getString("aiapp_extra_need_download", "");
        this.p = eVar.W();
        this.s = eVar.e0();
        this.u = eVar.V();
    }

    public void i(d.a.i0.a.f1.e.e eVar) {
        h(eVar);
    }

    public void j(d.a.i0.a.f1.e.e eVar) {
        h(eVar);
    }

    public void k(String str) {
        this.u = str;
    }
}
