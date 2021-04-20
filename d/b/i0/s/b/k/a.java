package d.b.i0.s.b.k;

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
import d.b.g0.a.e1.b;
import d.b.g0.a.i2.k0;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends a0 {

    /* renamed from: d.b.i0.s.b.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1568a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f61397a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f61398b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f61399c;

        public C1568a(String str, CallbackHandler callbackHandler, e eVar) {
            this.f61397a = str;
            this.f61398b = callbackHandler;
            this.f61399c = eVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f61398b.handleSchemeDispatchCallback(this.f61397a, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            a.this.n(response, this.f61397a, this.f61398b, this.f61399c);
            return response;
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/navigateToProgram");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            String T = e.T();
            if (!TextUtils.isEmpty(T) && !TextUtils.isEmpty(T.trim())) {
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString2 = optParamsAsJo.optString("path");
                if (!StringUtils.isNull(optString2) && optString2.contains("/pages/frshistory/frshistory?")) {
                    d.b.i0.s.b.l.e.j(context, unitedSchemeEntity.getParam("params"));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                Request l = l(T, optParamsAsJo);
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
        if (a0.f46680b) {
            Log.i("NavigateToSmartProgram", buildUpon.build().toString());
        }
        return buildUpon.build();
    }

    public final Request l(String str, JSONObject jSONObject) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            String a2 = b.a(k0.n());
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(com.alipay.sdk.cons.b.f1883h, str);
                jSONObject2.put("srcAppPage", a2);
                jSONObject2.put("params", jSONObject);
                String H = d.b.g0.a.w0.a.l().H();
                Request build = new Request.Builder().url(H).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject2.toString())).build();
                if (a0.f46680b) {
                    Log.i("NavigateToSmartProgram", "appId :" + str + "\nrequest params" + jSONObject2.toString());
                }
                return build;
            } catch (Exception e2) {
                if (a0.f46680b) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final void m(RequestBody requestBody, UnitedSchemeEntity unitedSchemeEntity, String str, CallbackHandler callbackHandler, e eVar) {
        d.b.g0.k.d.a aVar = new d.b.g0.k.d.a(d.b.g0.a.w0.a.l().H(), requestBody, new C1568a(str, callbackHandler, eVar));
        aVar.f49276f = true;
        aVar.f49277g = false;
        aVar.f49278h = true;
        d.b.g0.k.e.a.f().e(aVar);
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
            if (a0.f46680b) {
                Log.d("NavigateToSmartProgram", e2.getMessage());
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
        }
    }
}
