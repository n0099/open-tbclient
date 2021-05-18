package d.a.i0.a.c2.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tbadk.core.util.TbEnum;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q extends a0 {
    public q(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/openStatisticFlowJar");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
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
            if (hashCode == 55357 && optString.equals("805")) {
                c2 = 1;
            }
        } else if (optString.equals("670")) {
            c2 = 0;
        }
        if (c2 == 0) {
            HybridUbcFlow o = d.a.i0.a.r1.h.o();
            o.D(l(optParamsAsJo.optJSONArray("data")));
            o.l();
        } else if (c2 != 1) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "unknown flowId");
            return false;
        } else {
            j(optParamsAsJo.optJSONArray("data"));
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void j(JSONArray jSONArray) {
        d.a.i0.a.h0.g.f J = d.a.i0.a.g1.f.V().J();
        if (J == null) {
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
                J.y3(new d.a.i0.a.j2.p.g(string, j));
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public UbcFlowEvent k(JSONObject jSONObject) {
        String optString = jSONObject.optString("actionId");
        long optLong = jSONObject.optLong("timestamp");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(optString);
        ubcFlowEvent.h(optLong);
        return ubcFlowEvent;
    }

    public List<UbcFlowEvent> l(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            UbcFlowEvent k = k(jSONArray.optJSONObject(i2));
            if (k != null) {
                k.e("FE");
                arrayList.add(k);
            }
        }
        return arrayList;
    }
}
