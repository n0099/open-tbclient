package d.b.h0.a.y1.d;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements a<JSONObject> {

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f47857b;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.f47857b == null) {
                this.f47857b = new JSONArray();
            }
            this.f47857b.put(jSONObject);
            if (a.f47855a) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public void b() {
        this.f47857b = null;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.f47857b);
        } catch (JSONException e2) {
            if (a.f47855a) {
                Log.e("WhiteCollector", Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }
}
