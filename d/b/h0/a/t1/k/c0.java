package d.b.h0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class c0 extends a0 {
    public c0(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/ubcFlowJar");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (a0.f47009b) {
            Log.d("SwanAppAction", "start ubc flor jar");
        }
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("flowId");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty flowId");
            return false;
        }
        char c2 = 65535;
        switch (optString.hashCode()) {
            case 53647:
                if (optString.equals("670")) {
                    c2 = 0;
                    break;
                }
                break;
            case 53648:
                if (optString.equals("671")) {
                    c2 = 3;
                    break;
                }
                break;
            case 54610:
                if (optString.equals("772")) {
                    c2 = 1;
                    break;
                }
                break;
            case 55357:
                if (optString.equals("805")) {
                    c2 = 2;
                    break;
                }
                break;
            case 56506:
                if (optString.equals("967")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1508542:
                if (optString.equals("1153")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1529139648:
                if (optString.equals("renderMonitorLog")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                d.b.h0.a.t.c.n.f.u(optParamsAsJo, eVar);
                break;
            case 1:
                d.b.h0.a.t.c.n.f.s(optParamsAsJo.optJSONArray("data"));
                break;
            case 2:
                d.b.h0.a.t.c.n.f.y(optParamsAsJo.optJSONArray("data"));
                break;
            case 3:
                d.b.h0.a.t.c.n.f.x(optParamsAsJo.optJSONArray("data"));
                break;
            case 4:
                d.b.h0.a.t.c.n.f.w(optParamsAsJo);
                break;
            case 5:
                d.b.h0.a.c0.d.d.d.i(optParamsAsJo.optJSONArray("data"));
                break;
            case 6:
                d.b.h0.a.t.c.n.f.v(optParamsAsJo);
                break;
            default:
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "unknown flowId");
                return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
