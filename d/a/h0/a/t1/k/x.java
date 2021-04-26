package d.a.h0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class x extends a0 {
    public x(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/preventPullDownRefresh");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (a0.f44398b) {
            Log.d("PreventPullDownRefresh", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            d.a.h0.a.c0.c.b("preventPullDownRefresh", "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
            return false;
        }
        String optString = a2.optString("slaveId");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b("preventPullDownRefresh", "slaveId null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "slaveId null");
            return false;
        }
        d.a.h0.a.p.d.d B = d.a.h0.a.z0.f.V().B(optString);
        if (!(B instanceof d.a.h0.a.p.d.b)) {
            d.a.h0.a.c0.c.b("preventPullDownRefresh", "webViewManager not a SwanAppSlaveManager");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "webViewManager not a SwanAppSlaveManager");
            return false;
        }
        boolean optBoolean = a2.optBoolean("prevent", false);
        PullToRefreshBaseWebView f0 = ((d.a.h0.a.p.d.b) B).f0();
        if (f0 != null) {
            f0.setIsPreventPullToRefresh(optBoolean);
            return true;
        }
        return true;
    }
}
