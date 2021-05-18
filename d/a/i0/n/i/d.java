package d.a.i0.n.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import d.a.i0.n.i.g;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class d<T> implements g.a {

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.n.f.g f47852e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.n.i.m.g f47853f;

    /* renamed from: g  reason: collision with root package name */
    public String f47854g;

    public d(d.a.i0.n.f.g gVar, d.a.i0.n.i.m.g gVar2) {
        this.f47852e = gVar;
        this.f47853f = gVar2;
    }

    @Override // d.a.i0.n.i.g.a
    public void a(String str, String str2, JSONObject jSONObject) {
        d.a.i0.n.f.g gVar = this.f47852e;
        if (gVar != null) {
            gVar.H(str, str2, jSONObject);
        }
        this.f47854g = str;
    }

    @Override // d.a.i0.n.i.g.a
    public void b(String str, int i2) {
        d.a.i0.n.f.g gVar = this.f47852e;
        if (gVar != null) {
            gVar.G(str, i2);
        }
        if (i2 != 200) {
            d.a.i0.n.h.a aVar = new d.a.i0.n.h.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i2);
            aVar.f47829d = i2;
            this.f47852e.B(aVar);
            c(aVar, str, String.valueOf(i2), String.valueOf(this.f47853f.b()));
            return;
        }
        c a2 = c.a(str);
        if (a2 == null) {
            JSONObject m = d.a.i0.n.o.e.m(str);
            d.a.i0.n.h.a aVar2 = new d.a.i0.n.h.a(2103, "metadata : parse response error - ,errmsg:" + m.toString());
            this.f47852e.B(aVar2);
            c(aVar2, str, String.valueOf(i2), String.valueOf(this.f47853f.b()));
            return;
        }
        int d2 = a2.d();
        if (d2 != 0) {
            d.a.i0.n.h.a aVar3 = new d.a.i0.n.h.a(d2, PMSConstants.a.a(d2, "response errorCode with errmsg:" + a2.e()), a2.g());
            this.f47852e.B(aVar3);
            if (a2.d() != 1010) {
                d(aVar3, str, String.valueOf(i2), String.valueOf(this.f47853f.b()), a2);
                return;
            }
            return;
        }
        T n = n(a2.c());
        if (n == null) {
            d.a.i0.n.h.a aVar4 = new d.a.i0.n.h.a(2102, "response data empty");
            this.f47852e.B(aVar4);
            d(aVar4, str, String.valueOf(i2), String.valueOf(this.f47853f.b()), a2);
        } else if (!e(n)) {
            d.a.i0.n.h.a aVar5 = new d.a.i0.n.h.a(2103, str);
            this.f47852e.B(aVar5);
            d(aVar5, str, String.valueOf(i2), String.valueOf(this.f47853f.b()), a2);
        } else {
            m(n);
        }
    }

    public final void c(d.a.i0.n.h.a aVar, String str, String str2, String str3) {
        d(aVar, str, str2, str3, null);
    }

    public final void d(d.a.i0.n.h.a aVar, String str, String str2, String str3, @Nullable c cVar) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 0;
        if (aVar != null) {
            try {
                if (aVar.f47826a != 0) {
                    i2 = aVar.f47826a;
                    jSONObject.put("response", str);
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("statusCode", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("downloadType", str3);
                    }
                    if (!TextUtils.isEmpty(this.f47854g) && aVar.f47826a != 2000) {
                        jSONObject.put("request_url", this.f47854g);
                    }
                    jSONObject.put("hostName", d.a.i0.n.c.b().c());
                    jSONObject.put("network", d.a.i0.t.a.e());
                }
            } catch (JSONException e2) {
                if (d.a.i0.n.c.f47808a) {
                    e2.printStackTrace();
                }
            }
        }
        if (this.f47853f instanceof d.a.i0.n.i.m.c) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((d.a.i0.n.i.m.c) this.f47853f).g());
        }
        if (cVar != null && cVar.f() != 0) {
            jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, cVar.f());
        }
        d.a.i0.n.a b2 = d.a.i0.n.c.b();
        if (b2 != null && b2.t() != null) {
            jSONObject.put("launchid", b2.t());
        }
        d.a.i0.n.m.a.a(this.f47853f.a(), "cs_protocol", f(), i2, jSONObject);
    }

    public abstract boolean e(T t);

    public abstract String f();

    public void g(d.a.i0.n.h.b bVar, d.a.i0.n.o.f fVar) {
        if (bVar == null) {
            return;
        }
        fVar.a(bVar, PMSPkgStatus.WAIT);
    }

    public void h(d.a.i0.n.h.d dVar, d.a.i0.n.o.f fVar) {
        if (dVar == null) {
            return;
        }
        fVar.a(dVar, PMSPkgStatus.WAIT);
    }

    public void i(d.a.i0.n.h.f fVar, d.a.i0.n.o.f fVar2) {
        if (fVar == null) {
            return;
        }
        fVar2.a(fVar, PMSPkgStatus.WAIT);
    }

    public void j(List<d.a.i0.n.h.g> list, d.a.i0.n.o.f fVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (d.a.i0.n.h.g gVar : list) {
            fVar.a(gVar, PMSPkgStatus.WAIT);
        }
    }

    public void k(d.a.i0.n.h.h hVar, d.a.i0.n.o.f fVar) {
        if (hVar == null) {
            return;
        }
        fVar.a(hVar, PMSPkgStatus.WAIT);
    }

    public void l(PMSAppInfo pMSAppInfo) {
        d.a.i0.n.f.f p;
        if (pMSAppInfo == null || (p = this.f47852e.p()) == null) {
            return;
        }
        p.a(pMSAppInfo);
    }

    public abstract d.a.i0.n.h.a m(T t);

    public abstract T n(JSONObject jSONObject);

    @Override // d.a.i0.n.i.g.a
    public void onFail(Exception exc) {
        d.a.i0.n.h.a aVar = new d.a.i0.n.h.a(2101, Log.getStackTraceString(exc));
        this.f47852e.B(aVar);
        c(aVar, exc.getMessage(), null, String.valueOf(this.f47853f.b()));
    }

    @Override // d.a.i0.n.i.g.a
    public void onStart() {
        c(new d.a.i0.n.h.a(2000, "send request"), null, null, String.valueOf(this.f47853f.b()));
    }
}
