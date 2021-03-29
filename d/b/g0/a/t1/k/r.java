package d.b.g0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r extends a0 {
    public r(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/openStatisticFlowJar");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
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
        int hashCode = optString.hashCode();
        if (hashCode != 53647) {
            if (hashCode != 54610) {
                if (hashCode == 55357 && optString.equals("805")) {
                    c2 = 2;
                }
            } else if (optString.equals("772")) {
                c2 = 1;
            }
        } else if (optString.equals("670")) {
            c2 = 0;
        }
        if (c2 == 0) {
            HybridUbcFlow n = d.b.g0.a.j1.i.n();
            n.B(m(optParamsAsJo.optJSONArray("data")));
            n.k();
        } else if (c2 == 1) {
            j(optParamsAsJo.optJSONArray("data"));
        } else if (c2 != 2) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "unknown flowId");
            return false;
        } else {
            k(optParamsAsJo.optJSONArray("data"));
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void j(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        if (a0.f46288b) {
            Log.d("SwanAppAction", "SearchFlowEvent from FE, data: " + jSONArray);
        }
        try {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                String optString2 = optJSONObject.optString("errorType");
                String optString3 = optJSONObject.optString(PmsConstant.Statistic.Key.REV_TIMESTAMP);
                SearchFlowEvent searchFlowEvent = new SearchFlowEvent(optString);
                searchFlowEvent.f12652b = Long.valueOf(optString3).longValue();
                searchFlowEvent.f12653c = optString2;
                searchFlowEvent.f12655e = SearchFlowEvent.EventType.END;
                d.b.g0.a.z1.l.b.a(searchFlowEvent);
            }
        } catch (NumberFormatException e2) {
            if (a0.f46288b) {
                e2.printStackTrace();
            }
        }
    }

    public final void k(JSONArray jSONArray) {
        d.b.g0.a.e0.l.e A = d.b.g0.a.z0.f.V().A();
        if (A == null) {
            return;
        }
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject != null) {
                String string = jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID);
                String optString = jSONObject.optString(PmsConstant.Statistic.Key.REV_TIMESTAMP);
                long j = 0;
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        j = Long.valueOf(optString).longValue();
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
                A.n3(new d.b.g0.a.z1.k.g(string, j));
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public UbcFlowEvent l(JSONObject jSONObject) {
        String optString = jSONObject.optString("actionId");
        long optLong = jSONObject.optLong("timestamp");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(optString);
        ubcFlowEvent.h(optLong);
        return ubcFlowEvent;
    }

    public List<UbcFlowEvent> m(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            UbcFlowEvent l = l(jSONArray.optJSONObject(i));
            if (l != null) {
                l.e("FE");
                arrayList.add(l);
            }
        }
        return arrayList;
    }
}
