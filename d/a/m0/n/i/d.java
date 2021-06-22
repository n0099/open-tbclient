package d.a.m0.n.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import d.a.m0.n.i.g;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class d<T> implements g.a {

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.n.f.g f51810e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.n.i.m.g f51811f;

    /* renamed from: g  reason: collision with root package name */
    public String f51812g;

    public d(d.a.m0.n.f.g gVar, d.a.m0.n.i.m.g gVar2) {
        this.f51810e = gVar;
        this.f51811f = gVar2;
    }

    @Override // d.a.m0.n.i.g.a
    public void a(String str, String str2, JSONObject jSONObject) {
        d.a.m0.n.f.g gVar = this.f51810e;
        if (gVar != null) {
            gVar.H(str, str2, jSONObject);
        }
        this.f51812g = str;
    }

    @Override // d.a.m0.n.i.g.a
    public void b(String str, int i2) {
        d.a.m0.n.f.g gVar = this.f51810e;
        if (gVar != null) {
            gVar.G(str, i2);
        }
        if (i2 != 200) {
            d.a.m0.n.h.a aVar = new d.a.m0.n.h.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i2);
            aVar.f51787d = i2;
            this.f51810e.B(aVar);
            c(aVar, str, String.valueOf(i2), String.valueOf(this.f51811f.b()));
            return;
        }
        c a2 = c.a(str);
        if (a2 == null) {
            JSONObject m = d.a.m0.n.o.e.m(str);
            d.a.m0.n.h.a aVar2 = new d.a.m0.n.h.a(2103, "metadata : parse response error - ,errmsg:" + m.toString());
            this.f51810e.B(aVar2);
            c(aVar2, str, String.valueOf(i2), String.valueOf(this.f51811f.b()));
            return;
        }
        int d2 = a2.d();
        if (d2 != 0) {
            d.a.m0.n.h.a aVar3 = new d.a.m0.n.h.a(d2, PMSConstants.a.a(d2, "response errorCode with errmsg:" + a2.e()), a2.g());
            this.f51810e.B(aVar3);
            if (a2.d() != 1010) {
                d(aVar3, str, String.valueOf(i2), String.valueOf(this.f51811f.b()), a2);
                return;
            }
            return;
        }
        T n = n(a2.c());
        if (n == null) {
            d.a.m0.n.h.a aVar4 = new d.a.m0.n.h.a(2102, "response data empty");
            this.f51810e.B(aVar4);
            d(aVar4, str, String.valueOf(i2), String.valueOf(this.f51811f.b()), a2);
        } else if (!e(n)) {
            d.a.m0.n.h.a aVar5 = new d.a.m0.n.h.a(2103, str);
            this.f51810e.B(aVar5);
            d(aVar5, str, String.valueOf(i2), String.valueOf(this.f51811f.b()), a2);
        } else {
            m(n);
        }
    }

    public final void c(d.a.m0.n.h.a aVar, String str, String str2, String str3) {
        d(aVar, str, str2, str3, null);
    }

    public final void d(d.a.m0.n.h.a aVar, String str, String str2, String str3, @Nullable c cVar) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 0;
        if (aVar != null) {
            try {
                if (aVar.f51784a != 0) {
                    i2 = aVar.f51784a;
                    jSONObject.put("response", str);
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("statusCode", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("downloadType", str3);
                    }
                    if (!TextUtils.isEmpty(this.f51812g) && aVar.f51784a != 2000) {
                        jSONObject.put("request_url", this.f51812g);
                    }
                    jSONObject.put("hostName", d.a.m0.n.c.b().c());
                    jSONObject.put("network", d.a.m0.t.a.e());
                }
            } catch (JSONException e2) {
                if (d.a.m0.n.c.f51766a) {
                    e2.printStackTrace();
                }
            }
        }
        if (this.f51811f instanceof d.a.m0.n.i.m.c) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((d.a.m0.n.i.m.c) this.f51811f).g());
        }
        if (cVar != null && cVar.f() != 0) {
            jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, cVar.f());
        }
        d.a.m0.n.a b2 = d.a.m0.n.c.b();
        if (b2 != null && b2.t() != null) {
            jSONObject.put("launchid", b2.t());
        }
        d.a.m0.n.m.a.a(this.f51811f.a(), "cs_protocol", f(), i2, jSONObject);
    }

    public abstract boolean e(T t);

    public abstract String f();

    public void g(d.a.m0.n.h.b bVar, d.a.m0.n.o.f fVar) {
        if (bVar == null) {
            return;
        }
        fVar.a(bVar, PMSPkgStatus.WAIT);
    }

    public void h(d.a.m0.n.h.d dVar, d.a.m0.n.o.f fVar) {
        if (dVar == null) {
            return;
        }
        fVar.a(dVar, PMSPkgStatus.WAIT);
    }

    public void i(d.a.m0.n.h.f fVar, d.a.m0.n.o.f fVar2) {
        if (fVar == null) {
            return;
        }
        fVar2.a(fVar, PMSPkgStatus.WAIT);
    }

    public void j(List<d.a.m0.n.h.g> list, d.a.m0.n.o.f fVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (d.a.m0.n.h.g gVar : list) {
            fVar.a(gVar, PMSPkgStatus.WAIT);
        }
    }

    public void k(d.a.m0.n.h.h hVar, d.a.m0.n.o.f fVar) {
        if (hVar == null) {
            return;
        }
        fVar.a(hVar, PMSPkgStatus.WAIT);
    }

    public void l(PMSAppInfo pMSAppInfo) {
        d.a.m0.n.f.f p;
        if (pMSAppInfo == null || (p = this.f51810e.p()) == null) {
            return;
        }
        p.a(pMSAppInfo);
    }

    public abstract d.a.m0.n.h.a m(T t);

    public abstract T n(JSONObject jSONObject);

    @Override // d.a.m0.n.i.g.a
    public void onFail(Exception exc) {
        d.a.m0.n.h.a aVar = new d.a.m0.n.h.a(2101, Log.getStackTraceString(exc));
        this.f51810e.B(aVar);
        c(aVar, exc.getMessage(), null, String.valueOf(this.f51811f.b()));
    }

    @Override // d.a.m0.n.i.g.a
    public void onStart() {
        c(new d.a.m0.n.h.a(2000, "send request"), null, null, String.valueOf(this.f51811f.b()));
    }
}
