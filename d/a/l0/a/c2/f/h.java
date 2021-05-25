package d.a.l0.a.c2.f;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class h extends a0 {
    public h(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getAppInfoSync");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f40949b) {
            Log.d("GetAppInfoSyncAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar == null) {
            d.a.l0.a.e0.d.b(DI.APP_INFO_NAME, "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        try {
            JSONObject x = d.a.l0.a.u.e.l.b.x(eVar, context);
            if (a0.f40949b && x != null) {
                Log.d("GetAppInfoSyncAction", "data: " + x.toString());
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(x, 0);
            return true;
        } catch (JSONException e2) {
            if (a0.f40949b) {
                Log.d("GetAppInfoSyncAction", Log.getStackTraceString(e2));
            }
            d.a.l0.a.e0.d.b(DI.APP_INFO_NAME, Log.getStackTraceString(e2));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }
}
