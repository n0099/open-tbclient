package d.a.l0.n.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import d.a.l0.n.i.g;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class d<T> implements g.a {

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.n.f.g f51702e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.n.i.m.g f51703f;

    /* renamed from: g  reason: collision with root package name */
    public String f51704g;

    public d(d.a.l0.n.f.g gVar, d.a.l0.n.i.m.g gVar2) {
        this.f51702e = gVar;
        this.f51703f = gVar2;
    }

    @Override // d.a.l0.n.i.g.a
    public void a(String str, String str2, JSONObject jSONObject) {
        d.a.l0.n.f.g gVar = this.f51702e;
        if (gVar != null) {
            gVar.H(str, str2, jSONObject);
        }
        this.f51704g = str;
    }

    @Override // d.a.l0.n.i.g.a
    public void b(String str, int i2) {
        d.a.l0.n.f.g gVar = this.f51702e;
        if (gVar != null) {
            gVar.G(str, i2);
        }
        if (i2 != 200) {
            d.a.l0.n.h.a aVar = new d.a.l0.n.h.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i2);
            aVar.f51679d = i2;
            this.f51702e.B(aVar);
            c(aVar, str, String.valueOf(i2), String.valueOf(this.f51703f.b()));
            return;
        }
        c a2 = c.a(str);
        if (a2 == null) {
            JSONObject m = d.a.l0.n.o.e.m(str);
            d.a.l0.n.h.a aVar2 = new d.a.l0.n.h.a(2103, "metadata : parse response error - ,errmsg:" + m.toString());
            this.f51702e.B(aVar2);
            c(aVar2, str, String.valueOf(i2), String.valueOf(this.f51703f.b()));
            return;
        }
        int d2 = a2.d();
        if (d2 != 0) {
            d.a.l0.n.h.a aVar3 = new d.a.l0.n.h.a(d2, PMSConstants.a.a(d2, "response errorCode with errmsg:" + a2.e()), a2.g());
            this.f51702e.B(aVar3);
            if (a2.d() != 1010) {
                d(aVar3, str, String.valueOf(i2), String.valueOf(this.f51703f.b()), a2);
                return;
            }
            return;
        }
        T n = n(a2.c());
        if (n == null) {
            d.a.l0.n.h.a aVar4 = new d.a.l0.n.h.a(2102, "response data empty");
            this.f51702e.B(aVar4);
            d(aVar4, str, String.valueOf(i2), String.valueOf(this.f51703f.b()), a2);
        } else if (!e(n)) {
            d.a.l0.n.h.a aVar5 = new d.a.l0.n.h.a(2103, str);
            this.f51702e.B(aVar5);
            d(aVar5, str, String.valueOf(i2), String.valueOf(this.f51703f.b()), a2);
        } else {
            m(n);
        }
    }

    public final void c(d.a.l0.n.h.a aVar, String str, String str2, String str3) {
        d(aVar, str, str2, str3, null);
    }

    public final void d(d.a.l0.n.h.a aVar, String str, String str2, String str3, @Nullable c cVar) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 0;
        if (aVar != null) {
            try {
                if (aVar.f51676a != 0) {
                    i2 = aVar.f51676a;
                    jSONObject.put("response", str);
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("statusCode", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("downloadType", str3);
                    }
                    if (!TextUtils.isEmpty(this.f51704g) && aVar.f51676a != 2000) {
                        jSONObject.put("request_url", this.f51704g);
                    }
                    jSONObject.put("hostName", d.a.l0.n.c.b().c());
                    jSONObject.put("network", d.a.l0.t.a.e());
                }
            } catch (JSONException e2) {
                if (d.a.l0.n.c.f51658a) {
                    e2.printStackTrace();
                }
            }
        }
        if (this.f51703f instanceof d.a.l0.n.i.m.c) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((d.a.l0.n.i.m.c) this.f51703f).g());
        }
        if (cVar != null && cVar.f() != 0) {
            jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, cVar.f());
        }
        d.a.l0.n.a b2 = d.a.l0.n.c.b();
        if (b2 != null && b2.t() != null) {
            jSONObject.put("launchid", b2.t());
        }
        d.a.l0.n.m.a.a(this.f51703f.a(), "cs_protocol", f(), i2, jSONObject);
    }

    public abstract boolean e(T t);

    public abstract String f();

    public void g(d.a.l0.n.h.b bVar, d.a.l0.n.o.f fVar) {
        if (bVar == null) {
            return;
        }
        fVar.a(bVar, PMSPkgStatus.WAIT);
    }

    public void h(d.a.l0.n.h.d dVar, d.a.l0.n.o.f fVar) {
        if (dVar == null) {
            return;
        }
        fVar.a(dVar, PMSPkgStatus.WAIT);
    }

    public void i(d.a.l0.n.h.f fVar, d.a.l0.n.o.f fVar2) {
        if (fVar == null) {
            return;
        }
        fVar2.a(fVar, PMSPkgStatus.WAIT);
    }

    public void j(List<d.a.l0.n.h.g> list, d.a.l0.n.o.f fVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (d.a.l0.n.h.g gVar : list) {
            fVar.a(gVar, PMSPkgStatus.WAIT);
        }
    }

    public void k(d.a.l0.n.h.h hVar, d.a.l0.n.o.f fVar) {
        if (hVar == null) {
            return;
        }
        fVar.a(hVar, PMSPkgStatus.WAIT);
    }

    public void l(PMSAppInfo pMSAppInfo) {
        d.a.l0.n.f.f p;
        if (pMSAppInfo == null || (p = this.f51702e.p()) == null) {
            return;
        }
        p.a(pMSAppInfo);
    }

    public abstract d.a.l0.n.h.a m(T t);

    public abstract T n(JSONObject jSONObject);

    @Override // d.a.l0.n.i.g.a
    public void onFail(Exception exc) {
        d.a.l0.n.h.a aVar = new d.a.l0.n.h.a(2101, Log.getStackTraceString(exc));
        this.f51702e.B(aVar);
        c(aVar, exc.getMessage(), null, String.valueOf(this.f51703f.b()));
    }

    @Override // d.a.l0.n.i.g.a
    public void onStart() {
        c(new d.a.l0.n.h.a(2000, "send request"), null, null, String.valueOf(this.f51703f.b()));
    }
}
