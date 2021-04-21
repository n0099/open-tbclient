package d.b.h0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.storage.PathType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends a0 {
    public k(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/getLocalImgData");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (eVar == null) {
            d.b.h0.a.c0.c.b("GetLocalImgDataAction", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.b.h0.a.c0.c.b("SwanAppAction", "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("filePath");
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("GetLocalImgDataAction", "GetLocalImgDataAction bdfile path null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (d.b.h0.a.a2.b.c(optString) != PathType.BD_FILE) {
            d.b.h0.a.c0.c.b("GetLocalImgDataAction", "invalid path : " + optString);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(null, 2006, d.b.h0.a.t1.f.a(2006));
            return false;
        } else {
            String u = d.b.h0.a.a2.b.u(optString, eVar.f46461f);
            if (TextUtils.isEmpty(u)) {
                d.b.h0.a.c0.c.b("GetLocalImgDataAction", "GetLocalImgDataAction realPath null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("filePath", u);
                d.b.h0.a.c0.c.g("GetLocalImgDataAction", "getLocalImgData success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            } catch (JSONException e2) {
                d.b.h0.a.c0.c.b("GetLocalImgDataAction", "getLocalImgData failed");
                if (a0.f47009b) {
                    e2.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
    }
}
