package d.a.i0.a.c2.f.p0;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidubce.AbstractBceClient;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.v2.q0;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41004a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41005b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f41006c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f41007d;

        public a(String str, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, String str2) {
            this.f41004a = str;
            this.f41005b = callbackHandler;
            this.f41006c = eVar;
            this.f41007d = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f41005b.handleSchemeDispatchCallback(this.f41004a, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            d.a.i0.a.j2.q.a.b(SwanInterfaceType.NAVIGATE, 2101, this.f41007d, null, exc.getMessage());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            f.this.n(response, this.f41004a, this.f41005b, this.f41006c);
            return response;
        }
    }

    public f(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/navigateToProgram");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar.d0()) {
            if (a0.f40775b) {
                Log.d("NavigateToSmartProgram", "NavigateToSmartProgram does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            String D = eVar.D();
            if (!TextUtils.isEmpty(D) && !TextUtils.isEmpty(D.trim())) {
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                } else if (TextUtils.equals(d.a.i0.a.v.a.a(optParamsAsJo.optString("appKey")), D)) {
                    if (callbackHandler != null) {
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(202, "The target program is running now.").toString());
                    }
                    return true;
                } else {
                    String appId = eVar.getAppId();
                    if (!TextUtils.isEmpty(appId) && !TextUtils.isEmpty(appId.trim())) {
                        Request l = l(appId, optParamsAsJo);
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
        if (a0.f40775b) {
            Log.i("NavigateToSmartProgram", buildUpon.build().toString());
        }
        return buildUpon.build();
    }

    public final Request l(String str, JSONObject jSONObject) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            String c2 = d.a.i0.a.l1.b.c(q0.n());
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("app_key", str);
                jSONObject2.put("srcAppPage", c2);
                jSONObject2.put("params", jSONObject);
                String F = d.a.i0.a.c1.a.n().F();
                Request build = new Request.Builder().url(F).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject2.toString())).build();
                if (a0.f40775b) {
                    Log.i("NavigateToSmartProgram", "appId :" + str + "\nrequest params" + jSONObject2.toString());
                }
                return build;
            } catch (Exception e2) {
                if (a0.f40775b) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final void m(RequestBody requestBody, UnitedSchemeEntity unitedSchemeEntity, String str, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        String F = d.a.i0.a.c1.a.n().F();
        d.a.i0.m.d.a aVar = new d.a.i0.m.d.a(F, requestBody, new a(str, callbackHandler, eVar, F));
        aVar.f47798f = true;
        aVar.f47799g = false;
        aVar.f47800h = true;
        d.a.i0.m.e.a.g().e(aVar);
        d.a.i0.a.j2.q.a.a(SwanInterfaceType.NAVIGATE);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public final void n(Response response, String str, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        try {
            if (!response.isSuccessful()) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                d.a.i0.a.j2.q.a.c(SwanInterfaceType.NAVIGATE, 2104, null, response);
                return;
            }
            String string = response.body().string();
            JSONObject jSONObject = new JSONObject(string);
            if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                d.a.i0.a.j2.q.a.c(SwanInterfaceType.NAVIGATE, jSONObject.optInt("errno", 2103), string, response);
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
            if (a0.f40775b) {
                Log.d("NavigateToSmartProgram", e2.getMessage());
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
            d.a.i0.a.j2.q.a.c(SwanInterfaceType.NAVIGATE, 2103, e2.getMessage(), null);
        }
    }
}
