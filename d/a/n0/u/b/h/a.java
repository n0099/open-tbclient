package d.a.n0.u.b.h;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidubce.AbstractBceClient;
import d.a.l0.a.a2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.l1.b;
import d.a.l0.a.v2.q0;
import d.a.n0.u.b.i.g;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends a0 {

    /* renamed from: d.a.n0.u.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1689a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f64986a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f64987b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f64988c;

        public C1689a(String str, CallbackHandler callbackHandler, e eVar) {
            this.f64986a = str;
            this.f64987b = callbackHandler;
            this.f64988c = eVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f64987b.handleSchemeDispatchCallback(this.f64986a, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            a.this.n(response, this.f64986a, this.f64987b, this.f64988c);
            return response;
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/navigateToProgram");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            String V = e.V();
            if (!TextUtils.isEmpty(V) && !TextUtils.isEmpty(V.trim())) {
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString2 = optParamsAsJo.optString("path");
                if (!StringUtils.isNull(optString2) && optString2.contains("/pages/frshistory/frshistory?")) {
                    g.j(context, unitedSchemeEntity.getParam("params"));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                Request l = l(V, optParamsAsJo);
                if (l == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                m(l.body(), unitedSchemeEntity, optString, callbackHandler, eVar);
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    public final Uri k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        String schemeHead = SchemeConfig.getSchemeHead();
        if (TextUtils.isEmpty(schemeHead)) {
            schemeHead = BaseWebViewActivity.SHOUBAI_SCHEME;
        }
        buildUpon.scheme(schemeHead);
        if (a0.f44625b) {
            Log.i("NavigateToSmartProgram", buildUpon.build().toString());
        }
        return buildUpon.build();
    }

    public final Request l(String str, JSONObject jSONObject) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            String c2 = b.c(q0.n());
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("app_key", str);
                jSONObject2.put("srcAppPage", c2);
                jSONObject2.put("params", jSONObject);
                String F = d.a.l0.a.c1.a.n().F();
                Request build = new Request.Builder().url(F).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject2.toString())).build();
                if (a0.f44625b) {
                    Log.i("NavigateToSmartProgram", "appId :" + str + "\nrequest params" + jSONObject2.toString());
                }
                return build;
            } catch (Exception e2) {
                if (a0.f44625b) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final void m(RequestBody requestBody, UnitedSchemeEntity unitedSchemeEntity, String str, CallbackHandler callbackHandler, e eVar) {
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(d.a.l0.a.c1.a.n().F(), requestBody, new C1689a(str, callbackHandler, eVar));
        aVar.f51648f = true;
        aVar.f51649g = false;
        aVar.f51650h = true;
        d.a.l0.m.e.a.g().e(aVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public final void n(Response response, String str, CallbackHandler callbackHandler, e eVar) {
        try {
            JSONObject jSONObject = new JSONObject(response.body().string());
            if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                return;
            }
            Uri k = k(optJSONObject.optString("scheme"));
            if (k == null) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
            } else {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(SchemeRouter.invokeScheme(eVar.getApplicationContext(), k, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE) ? 0 : 1001).toString());
            }
        } catch (Exception e2) {
            if (a0.f44625b) {
                Log.d("NavigateToSmartProgram", e2.getMessage());
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
        }
    }
}
