package d.a.m0.a.y0.h;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.g1.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b extends a0 {
    public b(e eVar, String str) {
        super(eVar, str);
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.m0.a.e0.d.b("componentFullScreen", "none swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (a0.f44733b) {
                Log.e("SwanAppAction", "getAutoRotationSync --- illegal swanApp");
            }
            return false;
        } else if (context == null) {
            d.a.m0.a.e0.d.b("componentFullScreen", "none context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
            if (a0.f44733b) {
                Log.e("SwanAppAction", "getAutoRotationSync --- illegal context");
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.m0.a.e0.d.b("componentFullScreen", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString = optParamsAsJo.optString("slaveId");
            JSONArray optJSONArray = optParamsAsJo.optJSONArray("componentId");
            if (!TextUtils.isEmpty(optString) && optJSONArray != null && optJSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString2 = optJSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString2)) {
                        arrayList.add(optString2);
                    }
                }
                if (arrayList.size() == 0) {
                    d.a.m0.a.e0.d.b("componentFullScreen", "empty component id list");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                d.a.m0.a.p.e.d B = f.V().B(optString);
                if (!(B instanceof SwanAppWebViewManager)) {
                    d.a.m0.a.e0.d.b("componentFullScreen", "cant get WebView");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                d.a.m0.a.y0.j.b F0 = ((SwanAppWebViewManager) B).F0();
                if (F0 == null) {
                    d.a.m0.a.e0.d.b("componentFullScreen", "cant get CustomViewHelper");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!j(unitedSchemeEntity, F0, arrayList)) {
                    d.a.m0.a.e0.d.b("componentFullScreen", "custom view handle fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                    return true;
                }
            }
            d.a.m0.a.e0.d.b("componentFullScreen", "param error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
    }

    public abstract boolean j(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull d.a.m0.a.y0.j.b bVar, @NonNull List<String> list);
}
