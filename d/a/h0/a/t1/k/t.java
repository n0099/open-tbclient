package d.a.h0.a.t1.k;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class t extends a0 {
    public t(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/performancePanel");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (!d.a.h0.a.z0.f.V().O() && !a0.f44398b) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not debug app model");
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            JSONArray optJSONArray = optParamsAsJo.optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("slaveId");
                        String optString2 = optJSONObject.optString("actionName");
                        long optLong = optJSONObject.optLong("timestamp", -1L);
                        if (a0.f44398b) {
                            Log.i("performancePanel", "slaveId: " + optString + ", actionName: " + optString2 + ", timestamp: " + optLong);
                        }
                        d.a.h0.a.j1.p.d.b().d(optString, optString2, optLong);
                    }
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty data");
            return false;
        }
    }
}
