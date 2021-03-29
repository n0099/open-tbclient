package d.b.g0.l.l;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import d.b.g0.l.k.h;
import d.b.g0.l.l.f;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class d<T> implements f.a {

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.l.h.g f48932e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.l.l.k.g f48933f;

    /* renamed from: g  reason: collision with root package name */
    public String f48934g;

    public d(d.b.g0.l.h.g gVar, d.b.g0.l.l.k.g gVar2) {
        this.f48932e = gVar;
        this.f48933f = gVar2;
    }

    @Override // d.b.g0.l.l.f.a
    public void a(String str, String str2, JSONObject jSONObject) {
        d.b.g0.l.h.g gVar = this.f48932e;
        if (gVar != null) {
            gVar.I(str, str2, jSONObject);
        }
        this.f48934g = str;
    }

    @Override // d.b.g0.l.l.f.a
    public void b(String str, int i) {
        d.b.g0.l.h.g gVar = this.f48932e;
        if (gVar != null) {
            gVar.H(str, i);
        }
        if (i != 200) {
            d.b.g0.l.k.a aVar = new d.b.g0.l.k.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
            this.f48932e.C(aVar);
            c(aVar, str);
            return;
        }
        c a2 = c.a(str);
        if (a2 == null) {
            JSONObject m = d.b.g0.l.r.e.m(str);
            d.b.g0.l.k.a aVar2 = new d.b.g0.l.k.a(2103, "metadata : parse response error - ,errmsg:" + m.toString());
            this.f48932e.C(aVar2);
            c(aVar2, str);
            return;
        }
        int d2 = a2.d();
        if (d2 != 0) {
            d.b.g0.l.k.a aVar3 = new d.b.g0.l.k.a(d2, d.b.g0.l.d.a(d2, "response errorCode with errmsg:" + a2.e()), a2.f());
            this.f48932e.C(aVar3);
            if (a2.d() != 1010) {
                c(aVar3, str);
                return;
            }
            return;
        }
        T m2 = m(a2.c());
        if (m2 == null) {
            d.b.g0.l.k.a aVar4 = new d.b.g0.l.k.a(2102, "response data empty");
            this.f48932e.C(aVar4);
            c(aVar4, str);
        } else if (!d(m2)) {
            d.b.g0.l.k.a aVar5 = new d.b.g0.l.k.a(2103, str);
            this.f48932e.C(aVar5);
            c(aVar5, str);
        } else {
            l(m2);
        }
    }

    public final void c(d.b.g0.l.k.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        if (aVar != null) {
            try {
                if (aVar.f48914a != 0) {
                    i = aVar.f48914a;
                    jSONObject.put("response", str);
                    if (!TextUtils.isEmpty(this.f48934g) && (aVar.f48914a == 1011 || aVar.f48914a == 1012)) {
                        jSONObject.put("request_url", this.f48934g);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.f48933f instanceof d.b.g0.l.l.k.c) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((d.b.g0.l.l.k.c) this.f48933f).g());
        }
        d.b.g0.l.p.a.a(this.f48933f.a(), "cs_protocol", e(), i, jSONObject);
    }

    public abstract boolean d(T t);

    public abstract String e();

    public void f(d.b.g0.l.k.b bVar, d.b.g0.l.r.f fVar) {
        if (bVar == null) {
            return;
        }
        fVar.a(bVar, PMSPkgStatus.WAIT);
    }

    public void g(d.b.g0.l.k.d dVar, d.b.g0.l.r.f fVar) {
        if (dVar == null) {
            return;
        }
        fVar.a(dVar, PMSPkgStatus.WAIT);
    }

    public void h(d.b.g0.l.k.f fVar, d.b.g0.l.r.f fVar2) {
        if (fVar == null) {
            return;
        }
        fVar2.a(fVar, PMSPkgStatus.WAIT);
    }

    public void i(List<d.b.g0.l.k.g> list, d.b.g0.l.r.f fVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (d.b.g0.l.k.g gVar : list) {
            fVar.a(gVar, PMSPkgStatus.WAIT);
        }
    }

    public void j(h hVar, d.b.g0.l.r.f fVar) {
        if (hVar == null) {
            return;
        }
        fVar.a(hVar, PMSPkgStatus.WAIT);
    }

    public void k(PMSAppInfo pMSAppInfo) {
        d.b.g0.l.h.f q;
        if (pMSAppInfo == null || (q = this.f48932e.q()) == null) {
            return;
        }
        q.a(pMSAppInfo);
    }

    public abstract d.b.g0.l.k.a l(T t);

    public abstract T m(JSONObject jSONObject);

    @Override // d.b.g0.l.l.f.a
    public void onFail(Exception exc) {
        d.b.g0.l.k.a aVar = new d.b.g0.l.k.a(2101, Log.getStackTraceString(exc));
        this.f48932e.C(aVar);
        c(aVar, exc.getMessage());
    }
}
