package d.a.m0.e.g;

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
import d.a.m0.a.p.c.v;
import d.a.m0.a.s.a.f;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.w;
import d.a.m0.k.o;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class c extends v {

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f50310a;

        public a(o oVar) {
            this.f50310a = oVar;
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
            c.this.t(response, this.f50310a);
            return response;
        }
    }

    @Override // d.a.m0.a.p.c.v, d.a.m0.k.b
    public void c(int i2, List<o> list) {
        super.c(i2, list);
        if (i2 == 12 || i2 == 15 || i2 == 17 || i2 == 18) {
            o(list);
        }
    }

    @Override // d.a.m0.k.b
    public void g(JSONObject jSONObject) {
    }

    @Override // d.a.m0.a.p.c.v, d.a.m0.k.b
    public boolean h(o oVar) {
        if (oVar.c() == 45) {
            q(oVar);
            return true;
        }
        return super.h(oVar);
    }

    @Override // d.a.m0.k.b
    public boolean i(boolean z, int i2) {
        d.a.m0.a.a2.e Q;
        if (q0.P()) {
            Context appContext = AppRuntime.getAppContext();
            if (d.a.m0.a.u.e.a.a.s(appContext) && (Q = d.a.m0.a.a2.e.Q()) != null && Q.j().e(appContext)) {
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
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        w.f(jSONObject, "app_key", Q.getAppId());
        w.f(jSONObject, "srcAppPage", d.a.m0.a.l1.b.c(q0.n()));
        JSONObject jSONObject2 = new JSONObject();
        w.f(jSONObject2, "appKey", "pjwYb22xF6hUcKpZKsiqvnhUhsoUvLfT");
        w.f(jSONObject2, "path", "pages/conversation/index");
        w.f(jSONObject2, PrefetchEvent.EVENT_DATA_EXTRA_DATA, p(Q));
        w.f(jSONObject, "params", jSONObject2);
        String F = d.a.m0.a.c1.a.n().F();
        Request build = new Request.Builder().url(F).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build();
        d.a.m0.m.d.a aVar = new d.a.m0.m.d.a(F, build.body(), new a(oVar));
        aVar.f51756f = true;
        aVar.f51757g = false;
        aVar.f51758h = true;
        d.a.m0.m.e.a.g().e(aVar);
    }

    public final void o(List<o> list) {
        if (list != null && q0.P() && d.a.m0.a.u.e.a.a.s(AppRuntime.getAppContext())) {
            list.add(new o(45, d.a.m0.e.e.aiapp_menu_customer_service, d.a.m0.e.b.aiapp_menu_item_customer_service_selector, true));
        }
    }

    public final JSONObject p(d.a.m0.a.a2.e eVar) {
        JSONObject jSONObject = new JSONObject();
        PMSAppInfo f0 = eVar.L().f0();
        w.f(jSONObject, "appname", f0.appName);
        w.f(jSONObject, "iconUrl", f0.iconUrl);
        w.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0.appKey);
        w.f(jSONObject, com.alipay.sdk.cons.b.k, f0.paNumber);
        w.f(jSONObject, "isBaiduSeries", Boolean.valueOf(f.f48364d.h()));
        w.f(jSONObject, "isOpenCustomerService", Boolean.valueOf(q0.P()));
        return jSONObject;
    }

    public final void q(o oVar) {
        if (d.a.m0.a.a2.e.Q() == null) {
            return;
        }
        n(oVar);
    }

    public final void r() {
    }

    public final void s(o oVar) {
        d.a.m0.a.c1.a.h().d();
        d.a.m0.a.k1.a.j(oVar);
        d.a.m0.a.j1.a.q(LightappBusinessClient.MTD_CUSTOMER_SERVICE, String.valueOf(oVar.e() > 0 ? 1 : 0), PrefetchEvent.STATE_CLICK);
        d.a.m0.a.k1.a.i();
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
