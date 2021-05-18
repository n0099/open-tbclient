package d.a.i0.a.n2.e.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e0.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(e eVar) {
        super(eVar, "/swanAPI/brightness");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.d("Brightness", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0116  */
    @Override // d.a.i0.a.c2.f.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.d("Brightness", "handleSubAction: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (a0.f40775b) {
            Log.i("Brightness", "handleSubAction params: " + unitedSchemeEntity.getParam("params"));
        }
        JSONObject jSONObject = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            d.b("brightness", "activity is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        int i2 = 1001;
        char c2 = 65535;
        int hashCode = str.hashCode();
        boolean z = true;
        if (hashCode != -1634890823) {
            if (hashCode != 1913219981) {
                if (hashCode == 1913231513 && str.equals("/swanAPI/brightness/set")) {
                    c2 = 0;
                }
            } else if (str.equals("/swanAPI/brightness/get")) {
                c2 = 1;
            }
        } else if (str.equals("/swanAPI/brightness/keepScreenOn")) {
            c2 = 2;
        }
        if (c2 == 0) {
            if (optParamsAsJo == null) {
                d.b("brightness", "paramsJson is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("value");
            float f2 = -1.0f;
            if (!TextUtils.isEmpty(optString)) {
                try {
                    f2 = Float.parseFloat(optString);
                } catch (Exception unused) {
                }
            }
            if (f2 >= 0.0f && f2 <= 1.0f) {
                d.a.i0.a.n2.e.b.a.b().d(activity, f2);
                if (!z) {
                }
                return z;
            }
            i2 = 202;
            z = false;
            if (!z) {
            }
            return z;
        }
        if (c2 != 1) {
            if (c2 == 2) {
                if (optParamsAsJo == null) {
                    d.b("brightness", "paramsJson is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                try {
                    d.a.i0.a.n2.e.b.a.b().e(activity, optParamsAsJo.getBoolean("keepScreenOn"));
                } catch (JSONException unused2) {
                }
            }
            z = false;
        } else {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("value", d.a.i0.a.n2.e.b.a.b().a(activity));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (!z) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i2);
        } else if (jSONObject != null) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
        } else {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        }
        return z;
    }
}
