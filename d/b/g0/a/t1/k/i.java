package d.b.g0.a.t1.k;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes2.dex */
public class i extends a0 {
    public i(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/getAppInfoSync");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (a0.f46288b) {
            Log.d("GetAppInfoSyncAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar == null) {
            d.b.g0.a.c0.c.b(DI.APP_INFO_NAME, "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject v = d.b.g0.a.t.c.j.a.v(eVar, context);
            if (a0.f46288b && v != null) {
                Log.d("GetAppInfoSyncAction", "data: " + v.toString());
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(v, 0);
            return true;
        } catch (JSONException e2) {
            if (a0.f46288b) {
                Log.d("GetAppInfoSyncAction", Log.getStackTraceString(e2));
            }
            d.b.g0.a.c0.c.b(DI.APP_INFO_NAME, Log.getStackTraceString(e2));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }
}
