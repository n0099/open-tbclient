package d.a.m0.a.r;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.f.a0;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends c {

    /* loaded from: classes2.dex */
    public class a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48037a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48038b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f48039c;

        public a(CallbackHandler callbackHandler, String str, h hVar) {
            this.f48037a = callbackHandler;
            this.f48038b = str;
            this.f48039c = hVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f48037a.handleSchemeDispatchCallback(this.f48038b, UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            g.this.r(response, this.f48037a, this.f48038b, this.f48039c);
            return response;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48041a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48042b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f48043c;

        public b(CallbackHandler callbackHandler, String str, String str2) {
            this.f48041a = callbackHandler;
            this.f48042b = str;
            this.f48043c = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (c.f48029c) {
                Log.i("CloudUploadAction", "onFailure: ");
            }
            g gVar = g.this;
            CallbackHandler callbackHandler = this.f48041a;
            String str = this.f48042b;
            gVar.s(callbackHandler, str, null, "uploadFile:fail" + exc.getMessage());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            this.f48041a.handleSchemeDispatchCallback(this.f48042b, UnitedSchemeUtility.wrapCallbackParams(d.a.m0.a.r.a.n(this.f48043c, null, "uploadFile:ok"), 0).toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            return response;
        }
    }

    public g(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/cloudUploadFile");
    }

    @Override // d.a.m0.a.r.c, d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            return l(unitedSchemeEntity, 1001, "swanApp is null");
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            return l(unitedSchemeEntity, 202, "illegal params");
        }
        String param = unitedSchemeEntity.getParam("callback");
        if (TextUtils.isEmpty(param)) {
            return l(unitedSchemeEntity, 202, "illegal callback");
        }
        String optString = a2.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return l(unitedSchemeEntity, 202, "illegal cb");
        }
        if (c.f48029c) {
            Log.d("CloudUploadAction", "schema params : " + a2.toString());
            Log.d("CloudUploadAction", "schema cb : " + optString);
        }
        h p = p(a2);
        if (p == null) {
            l(unitedSchemeEntity, 202, "illegal params");
            return false;
        }
        Request c2 = d.a.m0.a.r.a.c(eVar, a2, unitedSchemeEntity);
        if (c2 != null) {
            callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            d.a.m0.a.r.a.p(c2.url().toString(), c2.body(), new a(callbackHandler, optString, p));
            return true;
        }
        callbackHandler.handleSchemeDispatchCallback(param, unitedSchemeEntity.result.toString());
        return false;
    }

    @Override // d.a.m0.a.r.c
    public void j(Response response, CallbackHandler callbackHandler, String str) {
    }

    public h p(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("fileMap");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("stringMap");
        if (optJSONObject == null || optJSONObject2 == null) {
            return null;
        }
        String optString = optJSONObject2.optString("cloudPath");
        if (TextUtils.isEmpty(optString) || optString.startsWith("/") || optString.contains("@")) {
            return null;
        }
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String M = d.a.m0.a.k2.b.M(optJSONObject.optString(keys.next()), d.a.m0.a.a2.e.V());
            if (M != null && !TextUtils.isEmpty(M)) {
                File file = new File(M);
                if (file.exists()) {
                    h hVar = new h(file);
                    u(jSONObject, hVar.contentLength());
                    return hVar;
                }
            }
        }
        return null;
    }

    public final int q(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            if (c.f48029c) {
                e2.printStackTrace();
            }
            return 1001;
        }
    }

    public final void r(Response response, CallbackHandler callbackHandler, String str, RequestBody requestBody) {
        if (!response.isSuccessful()) {
            s(callbackHandler, str, null, null);
            return;
        }
        String header = response.header("Content-Type", "");
        if (header != null && header.contains("application/json")) {
            JSONObject m = d.a.m0.a.r.a.m(response);
            if (m != null && response.isSuccessful()) {
                String optString = m.optString("errno", String.valueOf(0));
                String optString2 = m.optString("errmsg");
                if (d.a.m0.a.r.a.o(optString)) {
                    s(callbackHandler, str, optString, optString2);
                    return;
                }
                String optString3 = m.optString("UploadUrl");
                String optString4 = m.optString("fileID");
                if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                    JSONObject optJSONObject = m.optJSONObject("ExtraHeaders");
                    if (optJSONObject == null) {
                        s(callbackHandler, str, optString, optString2);
                        return;
                    }
                    Map<String, String> t = t(optJSONObject);
                    try {
                        Request build = new Request.Builder().headers(Headers.of(t)).url(optString3).put(requestBody).build();
                        if (d.a.m0.a.a2.e.i() == null) {
                            k(callbackHandler, str, 1001, "uploadFile:fail");
                            return;
                        }
                        d.a.m0.m.d.a aVar = new d.a.m0.m.d.a(build.url().toString(), build.body(), new b(callbackHandler, str, optString4));
                        aVar.f51753c = t;
                        aVar.f51756f = true;
                        aVar.f51757g = false;
                        aVar.f51758h = true;
                        d.a.m0.m.e.a.g().f(aVar);
                        return;
                    } catch (Exception e2) {
                        if (c.f48029c) {
                            e2.printStackTrace();
                        }
                        s(callbackHandler, str, optString, optString2);
                        return;
                    }
                }
                s(callbackHandler, str, optString, optString2);
                return;
            }
            k(callbackHandler, str, 1001, "uploadFile:fail");
            return;
        }
        k(callbackHandler, str, 1001, "uploadFile:fail");
    }

    public final void s(CallbackHandler callbackHandler, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            k(callbackHandler, str, 1001, "uploadFile:fail");
        } else {
            k(callbackHandler, str, q(str2), d.a.m0.a.r.a.k(str3));
        }
    }

    @NonNull
    public final Map<String, String> t(JSONObject jSONObject) {
        ArrayMap arrayMap = new ArrayMap();
        if (jSONObject == null) {
            return arrayMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            arrayMap.put(next, jSONObject.optString(next));
        }
        return arrayMap;
    }

    public final void u(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("stringMap");
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("Content-Length", String.valueOf(j));
            jSONObject2.put("Headers", jSONObject3);
            if (optJSONObject != null) {
                optJSONObject.put("data", jSONObject2);
                jSONObject.put("stringMap", optJSONObject);
            }
        } catch (JSONException e2) {
            if (c.f48029c) {
                e2.printStackTrace();
            }
        }
    }
}
