package d.a.m0.a.r1;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.m0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements d.a.m0.a.v2.e1.b<HybridUbcFlow> {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48210e = k.f46983a;

    public final JSONObject a(HybridUbcFlow hybridUbcFlow) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (hybridUbcFlow != null && !hybridUbcFlow.f11124f.isEmpty()) {
            jSONObject.put("flowId", hybridUbcFlow.j());
            JSONArray jSONArray = new JSONArray();
            for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.f11124f) {
                if (!ubcFlowEvent.b() && !TextUtils.isEmpty(ubcFlowEvent.f11133a)) {
                    if (f48210e) {
                        Log.i("FlowJarToH5Reporter", "buildJoMsg: event=" + ubcFlowEvent);
                    }
                    jSONArray.put(new JSONObject().put("actionId", ubcFlowEvent.f11133a).put("timestamp", ubcFlowEvent.g()));
                }
            }
            jSONObject.put("data", jSONArray);
        }
        if (f48210e) {
            Log.i("FlowJarToH5Reporter", "buildJoMsg: joMsg=" + jSONObject);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.v2.e1.b
    /* renamed from: b */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        if (f48210e) {
            Log.i("FlowJarToH5Reporter", "report: flow=" + hybridUbcFlow);
        }
        if (d.a.m0.a.g1.f.V().Z()) {
            if (f48210e || d.a.m0.a.g1.f.V().O()) {
                try {
                    j.e().c(a(hybridUbcFlow));
                } catch (JSONException e2) {
                    if (f48210e) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
