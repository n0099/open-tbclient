package d.a.m0.a.r;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.k;
import java.io.File;
import java.io.InputStream;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.m0.a.n1.a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48025e = k.f46983a;

    /* loaded from: classes2.dex */
    public class a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48026a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48027b;

        public a(String str, CallbackHandler callbackHandler) {
            this.f48026a = str;
            this.f48027b = callbackHandler;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f48027b.handleSchemeDispatchCallback(this.f48026a, UnitedSchemeUtility.wrapCallbackParams(1001, "request IOException").toString());
            if (b.f48025e) {
                Log.d("aiRequestAction", "response fail : " + UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            b.this.w(response, this.f48026a, this.f48027b);
            return response;
        }
    }

    public b(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/aiRequest");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        String param = unitedSchemeEntity.getParam("callback");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal callback");
            return false;
        }
        if (f48025e) {
            Log.d("aiRequestAction", "schema params : " + a2.toString());
            Log.d("aiRequestAction", "schema cb : " + param);
        }
        Request c2 = d.a.m0.a.r.a.c(eVar, a2, unitedSchemeEntity);
        if (c2 == null) {
            return false;
        }
        if (f48025e) {
            Log.d("aiRequestAction", "build request : " + c2.url().toString());
        }
        d.a.m0.a.r.a.p(c2.url().toString(), c2.body(), new a(param, callbackHandler));
        return true;
    }

    public final void w(Response response, String str, CallbackHandler callbackHandler) {
        try {
            String header = response.header("Content-Type", "");
            if (header != null && header.contains("application/json")) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    jSONObject.put("header", d.a.m0.a.n1.a.s(response.headers()));
                    jSONObject.put("body", response.body().string());
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                    if (f48025e) {
                        Log.d("aiRequestAction", "response json : " + UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                        return;
                    }
                    return;
                } catch (JSONException unused) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "response json error").toString());
                    return;
                }
            }
            String n = d.a.m0.a.k2.b.n(d.a.m0.a.a2.e.V(), String.valueOf(System.currentTimeMillis()), "");
            if (TextUtils.isEmpty(n)) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "bdfile error").toString());
            }
            String J = d.a.m0.a.k2.b.J(n, d.a.m0.a.a2.e.V());
            if (TextUtils.isEmpty(J)) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "bdfile error").toString());
            }
            InputStream byteStream = response.body().byteStream();
            File file = new File(n);
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }
            if (d.a.m0.t.g.a(byteStream, file)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("filePath", J);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("statusCode", response.code());
                jSONObject3.put("header", d.a.m0.a.n1.a.s(response.headers()));
                jSONObject3.put("body", jSONObject2.toString());
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject3, 0).toString());
                if (f48025e) {
                    Log.d("aiRequestAction", "response file : " + UnitedSchemeUtility.wrapCallbackParams(jSONObject3, 0).toString());
                    return;
                }
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "bdfile error").toString());
        } catch (Exception e2) {
            if (f48025e) {
                e2.printStackTrace();
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
        }
    }
}
