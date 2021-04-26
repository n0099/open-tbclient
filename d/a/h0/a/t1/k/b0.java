package d.a.h0.a.t1.k;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.heytap.mcssdk.PushManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b0 extends a0 {
    public b0(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/checkAppInstalled");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            d.a.h0.a.c0.c.g("SwanCheckAppInstalledAction", "params parse error");
            return false;
        }
        String optString = a2.optString("name");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parameter error");
            d.a.h0.a.c0.c.g("SwanCheckAppInstalledAction", "packageName empty");
            return false;
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(optString, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            d.a.h0.a.c0.c.c("SwanCheckAppInstalledAction", e2.getMessage(), e2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (packageInfo != null) {
                jSONObject.put("hasApp", true);
                jSONObject.put(PushManager.APP_VERSION_NAME, packageInfo.versionName);
                jSONObject.put(PushManager.APP_VERSION_CODE, packageInfo.versionCode);
            } else {
                jSONObject.put("hasApp", false);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success"));
        } catch (JSONException e3) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e3.getMessage());
            d.a.h0.a.c0.c.c("SwanCheckAppInstalledAction", e3.getMessage(), e3);
        }
        return true;
    }
}
