package d.a.i0.a.c2.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.storage.PathType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j extends a0 {
    public j(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getLocalImgData");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.i0.a.e0.d.b("GetLocalImgDataAction", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.i0.a.e0.d.b("SwanAppAction", "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("filePath");
        if (TextUtils.isEmpty(optString)) {
            d.a.i0.a.e0.d.b("GetLocalImgDataAction", "GetLocalImgDataAction bdfile path null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (d.a.i0.a.k2.b.s(optString) != PathType.BD_FILE) {
            d.a.i0.a.e0.d.b("GetLocalImgDataAction", "invalid path : " + optString);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(null, 2006, d.a.i0.a.c2.b.a(2006));
            return false;
        } else {
            String M = d.a.i0.a.k2.b.M(optString, eVar.f40575f);
            if (TextUtils.isEmpty(M)) {
                d.a.i0.a.e0.d.b("GetLocalImgDataAction", "GetLocalImgDataAction realPath null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("filePath", M);
                d.a.i0.a.e0.d.g("GetLocalImgDataAction", "getLocalImgData success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException e2) {
                d.a.i0.a.e0.d.b("GetLocalImgDataAction", "getLocalImgData failed");
                if (a0.f40775b) {
                    e2.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
    }
}
