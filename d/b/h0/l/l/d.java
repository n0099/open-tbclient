package d.b.h0.l.l;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import d.b.h0.l.k.h;
import d.b.h0.l.l.f;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class d<T> implements f.a {

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.l.h.g f49653e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.l.l.k.g f49654f;

    /* renamed from: g  reason: collision with root package name */
    public String f49655g;

    public d(d.b.h0.l.h.g gVar, d.b.h0.l.l.k.g gVar2) {
        this.f49653e = gVar;
        this.f49654f = gVar2;
    }

    @Override // d.b.h0.l.l.f.a
    public void a(String str, String str2, JSONObject jSONObject) {
        d.b.h0.l.h.g gVar = this.f49653e;
        if (gVar != null) {
            gVar.H(str, str2, jSONObject);
        }
        this.f49655g = str;
    }

    @Override // d.b.h0.l.l.f.a
    public void b(String str, int i) {
        d.b.h0.l.h.g gVar = this.f49653e;
        if (gVar != null) {
            gVar.G(str, i);
        }
        if (i != 200) {
            d.b.h0.l.k.a aVar = new d.b.h0.l.k.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i);
            this.f49653e.B(aVar);
            c(aVar, str);
            return;
        }
        c a2 = c.a(str);
        if (a2 == null) {
            JSONObject m = d.b.h0.l.r.e.m(str);
            d.b.h0.l.k.a aVar2 = new d.b.h0.l.k.a(2103, "metadata : parse response error - ,errmsg:" + m.toString());
            this.f49653e.B(aVar2);
            c(aVar2, str);
            return;
        }
        int d2 = a2.d();
        if (d2 != 0) {
            d.b.h0.l.k.a aVar3 = new d.b.h0.l.k.a(d2, d.b.h0.l.d.a(d2, "response errorCode with errmsg:" + a2.e()), a2.f());
            this.f49653e.B(aVar3);
            if (a2.d() != 1010) {
                c(aVar3, str);
                return;
            }
            return;
        }
        T m2 = m(a2.c());
        if (m2 == null) {
            d.b.h0.l.k.a aVar4 = new d.b.h0.l.k.a(2102, "response data empty");
            this.f49653e.B(aVar4);
            c(aVar4, str);
        } else if (!d(m2)) {
            d.b.h0.l.k.a aVar5 = new d.b.h0.l.k.a(2103, str);
            this.f49653e.B(aVar5);
            c(aVar5, str);
        } else {
            l(m2);
        }
    }

    public final void c(d.b.h0.l.k.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        if (aVar != null) {
            try {
                if (aVar.f49635a != 0) {
                    i = aVar.f49635a;
                    jSONObject.put("response", str);
                    if (!TextUtils.isEmpty(this.f49655g) && (aVar.f49635a == 1011 || aVar.f49635a == 1012)) {
                        jSONObject.put("request_url", this.f49655g);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.f49654f instanceof d.b.h0.l.l.k.c) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((d.b.h0.l.l.k.c) this.f49654f).g());
        }
        d.b.h0.l.p.a.a(this.f49654f.a(), "cs_protocol", e(), i, jSONObject);
    }

    public abstract boolean d(T t);

    public abstract String e();

    public void f(d.b.h0.l.k.b bVar, d.b.h0.l.r.f fVar) {
        if (bVar == null) {
            return;
        }
        fVar.a(bVar, PMSPkgStatus.WAIT);
    }

    public void g(d.b.h0.l.k.d dVar, d.b.h0.l.r.f fVar) {
        if (dVar == null) {
            return;
        }
        fVar.a(dVar, PMSPkgStatus.WAIT);
    }

    public void h(d.b.h0.l.k.f fVar, d.b.h0.l.r.f fVar2) {
        if (fVar == null) {
            return;
        }
        fVar2.a(fVar, PMSPkgStatus.WAIT);
    }

    public void i(List<d.b.h0.l.k.g> list, d.b.h0.l.r.f fVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (d.b.h0.l.k.g gVar : list) {
            fVar.a(gVar, PMSPkgStatus.WAIT);
        }
    }

    public void j(h hVar, d.b.h0.l.r.f fVar) {
        if (hVar == null) {
            return;
        }
        fVar.a(hVar, PMSPkgStatus.WAIT);
    }

    public void k(PMSAppInfo pMSAppInfo) {
        d.b.h0.l.h.f p;
        if (pMSAppInfo == null || (p = this.f49653e.p()) == null) {
            return;
        }
        p.a(pMSAppInfo);
    }

    public abstract d.b.h0.l.k.a l(T t);

    public abstract T m(JSONObject jSONObject);

    @Override // d.b.h0.l.l.f.a
    public void onFail(Exception exc) {
        d.b.h0.l.k.a aVar = new d.b.h0.l.k.a(2101, Log.getStackTraceString(exc));
        this.f49653e.B(aVar);
        c(aVar, exc.getMessage());
    }
}
