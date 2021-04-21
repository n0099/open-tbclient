package d.b.h0.a.t1.k.r0;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.a.p.d.e f47283c;

    public f(j jVar) {
        super(jVar, "/swanAPI/webviewPostMessage");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (a0.f47009b) {
            Log.d("WebViewPostMsgAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        d.b.h0.a.c0.c.g("webviewPostMsg", "start post webview msg");
        d.b.h0.a.p.d.e eVar2 = this.f47283c;
        if (eVar2 == null) {
            d.b.h0.a.c0.c.b("webviewPostMsg", "none webview widget");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none webview widget");
            return false;
        }
        d params = eVar2.getParams();
        if (params == null) {
            d.b.h0.a.c0.c.b("webviewPostMsg", "none WWWParams");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none WWWParams");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.b.h0.a.c0.c.b("webviewPostMsg", "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
            return false;
        } else if (!a2.has("data")) {
            d.b.h0.a.c0.c.b("webviewPostMsg", "none param data");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none param data");
            return false;
        } else {
            String optString = a2.optString("data");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", optString);
                jSONObject.put("eventType", "message");
                jSONObject.put("wvID", params.f43835g);
                jSONObject.put("webviewId", params.f43834f);
            } catch (JSONException e2) {
                if (a0.f47009b) {
                    e2.printStackTrace();
                }
                d.b.h0.a.c0.c.b("webviewPostMsg", "meet json exception");
            }
            d.b.h0.a.j2.f.c.a.c(params.f43835g, params.f43834f, "webview", "message", jSONObject);
            d.b.h0.a.c0.c.g("webviewPostMsg", "post webview msg success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public void j(d.b.h0.a.p.d.e eVar) {
        this.f47283c = eVar;
    }
}
