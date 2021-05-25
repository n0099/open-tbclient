package d.a.l0.e.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidubce.AbstractBceClient;
import d.a.l0.a.p.c.w;
import d.a.l0.a.s.a.f;
import d.a.l0.a.v2.q0;
import d.a.l0.k.o;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class c extends w {

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f46528a;

        public a(o oVar) {
            this.f46528a = oVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            c.this.r();
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            c.this.t(response, this.f46528a);
            return response;
        }
    }

    @Override // d.a.l0.a.p.c.w, d.a.l0.k.b
    public void c(int i2, List<o> list) {
        super.c(i2, list);
        if (i2 == 12 || i2 == 15 || i2 == 17 || i2 == 18) {
            o(list);
        }
    }

    @Override // d.a.l0.k.b
    public void g(JSONObject jSONObject) {
    }

    @Override // d.a.l0.a.p.c.w, d.a.l0.k.b
    public boolean h(o oVar) {
        if (oVar.c() == 45) {
            q(oVar);
            return true;
        }
        return super.h(oVar);
    }

    @Override // d.a.l0.k.b
    public boolean i(boolean z, int i2) {
        d.a.l0.a.a2.e Q;
        if (q0.P()) {
            Context appContext = AppRuntime.getAppContext();
            if (d.a.l0.a.u.e.a.a.s(appContext) && (Q = d.a.l0.a.a2.e.Q()) != null && Q.j().e(appContext)) {
                PMSAppInfo f0 = Q.L().f0();
                return (Q.m0() || f0 == null || TextUtils.isEmpty(f0.paNumber)) ? false : true;
            }
            return false;
        }
        return false;
    }

    public final Uri m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        String schemeHead = SchemeConfig.getSchemeHead();
        if (TextUtils.isEmpty(schemeHead)) {
            schemeHead = BaseWebViewActivity.SHOUBAI_SCHEME;
        }
        buildUpon.scheme(schemeHead);
        return buildUpon.build();
    }

    public final void n(o oVar) {
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        d.a.l0.a.v2.w.f(jSONObject, "app_key", Q.getAppId());
        d.a.l0.a.v2.w.f(jSONObject, "srcAppPage", d.a.l0.a.l1.b.c(q0.n()));
        JSONObject jSONObject2 = new JSONObject();
        d.a.l0.a.v2.w.f(jSONObject2, "appKey", "nGspXF4Smz6B6PIMZdqGOPxQlVmdykOK");
        d.a.l0.a.v2.w.f(jSONObject2, "path", "pages/conversation/index");
        d.a.l0.a.v2.w.f(jSONObject2, PrefetchEvent.EVENT_DATA_EXTRA_DATA, p(Q));
        d.a.l0.a.v2.w.f(jSONObject, "params", jSONObject2);
        String F = d.a.l0.a.c1.a.n().F();
        Request build = new Request.Builder().url(F).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build();
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(F, build.body(), new a(oVar));
        aVar.f47974f = true;
        aVar.f47975g = false;
        aVar.f47976h = true;
        d.a.l0.m.e.a.g().e(aVar);
    }

    public final void o(List<o> list) {
        if (list != null && q0.P() && d.a.l0.a.u.e.a.a.s(AppRuntime.getAppContext())) {
            list.add(new o(45, d.a.l0.e.e.aiapp_menu_customer_service, d.a.l0.e.b.aiapp_menu_item_customer_service_selector, true));
        }
    }

    public final JSONObject p(d.a.l0.a.a2.e eVar) {
        JSONObject jSONObject = new JSONObject();
        PMSAppInfo f0 = eVar.L().f0();
        d.a.l0.a.v2.w.f(jSONObject, "appname", f0.appName);
        d.a.l0.a.v2.w.f(jSONObject, "iconUrl", f0.iconUrl);
        d.a.l0.a.v2.w.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0.appKey);
        d.a.l0.a.v2.w.f(jSONObject, com.alipay.sdk.cons.b.k, f0.paNumber);
        d.a.l0.a.v2.w.f(jSONObject, "isBaiduSeries", Boolean.valueOf(f.f44582d.h()));
        d.a.l0.a.v2.w.f(jSONObject, "isOpenCustomerService", Boolean.valueOf(q0.P()));
        return jSONObject;
    }

    public final void q(o oVar) {
        if (d.a.l0.a.a2.e.Q() == null) {
            return;
        }
        n(oVar);
    }

    public final void r() {
    }

    public final void s(o oVar) {
        d.a.l0.a.c1.a.h().d();
        d.a.l0.a.k1.a.j(oVar);
        d.a.l0.a.j1.a.q(LightappBusinessClient.MTD_CUSTOMER_SERVICE, String.valueOf(oVar.e() > 0 ? 1 : 0), PrefetchEvent.STATE_CLICK);
        d.a.l0.a.k1.a.i();
    }

    public final void t(Response response, o oVar) {
        try {
            if (!response.isSuccessful()) {
                r();
                return;
            }
            JSONObject jSONObject = new JSONObject(response.body().string());
            if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                r();
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                r();
                return;
            }
            Uri m = m(optJSONObject.optString("scheme"));
            if (m == null) {
                r();
            } else if (SchemeRouter.invokeScheme(AppRuntime.getAppContext(), m, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                s(oVar);
            }
        } catch (Exception unused) {
            r();
        }
    }
}
