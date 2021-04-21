package d.b.h0.a.j1;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements d.b.h0.a.i2.u0.b<HybridUbcFlow> {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45592e = d.b.h0.a.k.f45772a;

    public final JSONObject a(HybridUbcFlow hybridUbcFlow) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (hybridUbcFlow != null && !hybridUbcFlow.f12065f.isEmpty()) {
            jSONObject.put("flowId", hybridUbcFlow.i());
            JSONArray jSONArray = new JSONArray();
            for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.f12065f) {
                if (!ubcFlowEvent.b() && !TextUtils.isEmpty(ubcFlowEvent.f12073a)) {
                    if (f45592e) {
                        Log.i("FlowJarToH5Reporter", "buildJoMsg: event=" + ubcFlowEvent);
                    }
                    jSONArray.put(new JSONObject().put("actionId", ubcFlowEvent.f12073a).put("timestamp", ubcFlowEvent.g()));
                }
            }
            jSONObject.put("data", jSONArray);
        }
        if (f45592e) {
            Log.i("FlowJarToH5Reporter", "buildJoMsg: joMsg=" + jSONObject);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.i2.u0.b
    /* renamed from: b */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        if (f45592e) {
            Log.i("FlowJarToH5Reporter", "report: flow=" + hybridUbcFlow);
        }
        if (d.b.h0.a.z0.f.V().Z()) {
            if (f45592e || d.b.h0.a.z0.f.V().O()) {
                try {
                    k.e().c(a(hybridUbcFlow));
                } catch (JSONException e2) {
                    if (f45592e) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
