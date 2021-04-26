package d.a.h0.a.t1.k.f0;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.t1.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends b {
    public c(j jVar) {
        super(jVar, "/swanAPI/isFavor");
    }

    @Override // d.a.h0.a.t1.k.f0.b
    public boolean j(d.a.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            String appId = this.f44422d ? eVar.getAppId() : new JSONObject(param).optString("appid");
            this.f44421c = appId;
            return !TextUtils.isEmpty(appId);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.a.h0.a.t1.k.f0.b
    public void k(d.a.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isFavor", d.a.h0.a.g0.c.a.n(this.f44421c) ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }
}
