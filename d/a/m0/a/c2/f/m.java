package d.a.m0.a.c2.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.v2.q0;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends a0 {
    public m(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/openApp4Ad");
    }

    public static ResolveInfo j(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        return queryIntentActivities.iterator().next();
    }

    public static void k(Context context, ResolveInfo resolveInfo) {
        if (context == null || resolveInfo == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        try {
            context.startActivity(intent);
        } catch (Exception e2) {
            if (a0.f44733b) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            d.a.m0.a.e0.d.g("OpenAdAppAction", "params parse error");
            return false;
        } else if (!d.a.m0.a.c1.a.a().a()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1003, "Host denied");
            d.a.m0.a.e0.d.g("OpenAdAppAction", "Host denied");
            return false;
        } else {
            String optString = a2.optString("name");
            String optString2 = a2.optString("url");
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty params: Must contain 'url' or 'name' parameter");
                d.a.m0.a.e0.d.g("OpenAdAppAction", "empty params: Must contain 'url' or 'name' parameter");
                return false;
            }
            if (!TextUtils.isEmpty(optString2)) {
                if (q0.T(context, optString2)) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "deeplink launch failed");
                d.a.m0.a.e0.d.g("OpenAdAppAction", "deeplink launch failed");
            }
            if (!TextUtils.isEmpty(optString)) {
                ResolveInfo j = j(context, optString);
                if (j != null) {
                    k(context, j);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "app not installed");
                d.a.m0.a.e0.d.g("OpenAdAppAction", "app not installed");
            }
            if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "launch failed");
                d.a.m0.a.e0.d.g("OpenAdAppAction", "launch failed");
            }
            return false;
        }
    }
}
