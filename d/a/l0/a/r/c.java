package d.a.l0.a.r;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.k;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47921c = k.f46875a;

    /* loaded from: classes2.dex */
    public class a extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47922a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47923b;

        public a(CallbackHandler callbackHandler, String str) {
            this.f47922a = callbackHandler;
            this.f47923b = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.f47922a.handleSchemeDispatchCallback(this.f47923b, UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            c.this.j(response, this.f47922a, this.f47923b);
            return response;
        }
    }

    public c(d.a.l0.a.c2.e eVar, String str) {
        super(eVar, str);
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
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
        if (f47921c) {
            Log.d("BaseCloudAction", "schema params : " + a2.toString());
            Log.d("BaseCloudAction", "schema cb : " + optString);
        }
        Request c2 = d.a.l0.a.r.a.c(eVar, a2, unitedSchemeEntity);
        if (c2 != null) {
            callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            d.a.l0.a.r.a.p(c2.url().toString(), c2.body(), new a(callbackHandler, optString));
            return true;
        }
        callbackHandler.handleSchemeDispatchCallback(param, unitedSchemeEntity.result.toString());
        return false;
    }

    public abstract void j(Response response, CallbackHandler callbackHandler, String str);

    public void k(CallbackHandler callbackHandler, String str, int i2, String str2) {
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i2, str2).toString());
    }

    public boolean l(UnitedSchemeEntity unitedSchemeEntity, int i2, String str) {
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i2, str);
        return false;
    }

    public void m(CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
    }
}
