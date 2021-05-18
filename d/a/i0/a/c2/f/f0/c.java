package d.a.i0.a.c2.f.f0;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.v2.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends b {
    public c(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/isFavor");
    }

    @Override // d.a.i0.a.c2.f.f0.b
    public boolean j(d.a.i0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            String D = this.f40816d ? eVar.D() : new JSONObject(param).optString("appid");
            this.f40815c = D;
            return !TextUtils.isEmpty(D);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.a.i0.a.c2.f.f0.b
    public void k(d.a.i0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isFavor", d.a.i0.a.j0.b.a.n(this.f40815c) ? 1 : 0);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }

    @Override // d.a.i0.a.c2.f.f0.b
    public boolean o(UnitedSchemeEntity unitedSchemeEntity) {
        String optString = w.d(unitedSchemeEntity.getParam("params")).optString("invokeFrom");
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        return TextUtils.equals(optString, "boxjs");
    }
}
