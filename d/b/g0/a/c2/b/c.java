package d.b.g0.a.c2.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a0 {
    public c(j jVar) {
        super(jVar, "/swanAPI/stopMediaVolumeListen");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.b.g0.a.c0.c.b("stopMediaVolumeListen", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal swanApp");
            if (a0.f46680b) {
                Log.d("SwanAppAction", "stopMediaVolumeListen --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            d.b.g0.a.c0.c.b("stopMediaVolumeListen", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal context");
            if (a0.f46680b) {
                Log.d("SwanAppAction", "stopMediaVolumeListen --- illegal context");
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.b.g0.a.c0.c.b("stopMediaVolumeListen", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("id");
            if (TextUtils.isEmpty(optString)) {
                d.b.g0.a.c0.c.b("stopMediaVolumeListen", "id is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (!d.e().j(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
    }
}
