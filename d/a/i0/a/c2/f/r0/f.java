package d.a.i0.a.c2.f.r0;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.i0.a.c2.f.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.a.p.e.e f41091c;

    public f(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/webviewPostMessage");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.d("WebViewPostMsgAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d.a.i0.a.e0.d.g("webviewPostMsg", "start post webview msg");
        d.a.i0.a.p.e.e eVar2 = this.f41091c;
        if (eVar2 == null) {
            d.a.i0.a.e0.d.b("webviewPostMsg", "none webview widget");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none webview widget");
            return false;
        }
        d params = eVar2.getParams();
        if (params == null) {
            d.a.i0.a.e0.d.b("webviewPostMsg", "none WWWParams");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none WWWParams");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.i0.a.e0.d.b("webviewPostMsg", "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
            return false;
        } else if (!a2.has("data")) {
            d.a.i0.a.e0.d.b("webviewPostMsg", "none param data");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none param data");
            return false;
        } else {
            String optString = a2.optString("data");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", optString);
                jSONObject.put("eventType", "message");
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, params.f40672g);
                jSONObject.put("webviewId", params.f40671f);
            } catch (JSONException e2) {
                if (a0.f40775b) {
                    e2.printStackTrace();
                }
                d.a.i0.a.e0.d.b("webviewPostMsg", "meet json exception");
            }
            d.a.i0.a.w2.g.c.a.c(params.f40672g, params.f40671f, "webview", "message", jSONObject);
            d.a.i0.a.e0.d.g("webviewPostMsg", "post webview msg success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public void j(d.a.i0.a.p.e.e eVar) {
        this.f41091c = eVar;
    }
}
