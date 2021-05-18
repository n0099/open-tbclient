package d.a.i0.a.r;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends c {
    public f(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/cloudRequest");
    }

    @Override // d.a.i0.a.r.c, d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        return super.d(context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Override // d.a.i0.a.r.c
    public void j(Response response, CallbackHandler callbackHandler, String str) {
        String header = response.header("Content-Type", "");
        if (header == null || !header.contains("application/json")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("statusCode", response.code());
            jSONObject.put("header", d.a.i0.a.n1.a.s(response.headers()));
            jSONObject.put("body", response.body().string());
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("body"));
            String optString = jSONObject2.optString("errno", String.valueOf(0));
            String optString2 = jSONObject2.optString("errmsg");
            if (response.isSuccessful() && !a.o(optString)) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(a.j(optString), a.k(optString2)).toString());
        } catch (Exception e2) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
        }
    }
}
