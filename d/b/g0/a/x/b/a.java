package d.b.g0.a.x.b;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a extends a0 {
    public a(j jVar, String str) {
        super(jVar, str);
    }

    public void j(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap, String str) {
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.isEmpty() || hashMap == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e2) {
            if (a0.f46680b) {
                e2.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
        } else {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
        }
    }

    public void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, z ? 0 : -1);
    }

    public String l(UnitedSchemeEntity unitedSchemeEntity) {
        return unitedSchemeEntity.getParams().get("params");
    }
}
