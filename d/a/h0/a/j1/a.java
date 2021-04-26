package d.a.h0.a.j1;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements d.a.h0.a.i2.u0.b<HybridUbcFlow> {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f42915e = d.a.h0.a.k.f43101a;

    public final JSONObject a(HybridUbcFlow hybridUbcFlow) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (hybridUbcFlow != null && !hybridUbcFlow.f11906f.isEmpty()) {
            jSONObject.put("flowId", hybridUbcFlow.i());
            JSONArray jSONArray = new JSONArray();
            for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.f11906f) {
                if (!ubcFlowEvent.b() && !TextUtils.isEmpty(ubcFlowEvent.f11915a)) {
                    if (f42915e) {
                        Log.i("FlowJarToH5Reporter", "buildJoMsg: event=" + ubcFlowEvent);
                    }
                    jSONArray.put(new JSONObject().put("actionId", ubcFlowEvent.f11915a).put("timestamp", ubcFlowEvent.g()));
                }
            }
            jSONObject.put("data", jSONArray);
        }
        if (f42915e) {
            Log.i("FlowJarToH5Reporter", "buildJoMsg: joMsg=" + jSONObject);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.i2.u0.b
    /* renamed from: b */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        if (f42915e) {
            Log.i("FlowJarToH5Reporter", "report: flow=" + hybridUbcFlow);
        }
        if (d.a.h0.a.z0.f.V().Z()) {
            if (f42915e || d.a.h0.a.z0.f.V().O()) {
                try {
                    k.e().c(a(hybridUbcFlow));
                } catch (JSONException e2) {
                    if (f42915e) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
