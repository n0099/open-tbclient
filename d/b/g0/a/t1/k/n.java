package d.b.g0.a.t1.k;

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
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n extends a0 {
    public n(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/openApp4Ad");
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
            if (a0.f46680b) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
            d.b.g0.a.c0.c.g("OpenAdAppAction", "params parse error");
            return false;
        }
        String optString = a2.optString("name");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty package name");
            d.b.g0.a.c0.c.g("OpenAdAppAction", "empty package name");
            return false;
        }
        ResolveInfo j = j(context, optString);
        if (j == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "app not installed");
            d.b.g0.a.c0.c.g("OpenAdAppAction", "app not installed");
            return false;
        }
        k(context, j);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
