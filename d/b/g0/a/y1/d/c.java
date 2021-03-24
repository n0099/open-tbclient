package d.b.g0.a.y1.d;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements a<JSONObject> {

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f47135b;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.f47135b == null) {
                this.f47135b = new JSONArray();
            }
            this.f47135b.put(jSONObject);
            if (a.f47133a) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public void b() {
        this.f47135b = null;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.f47135b);
        } catch (JSONException e2) {
            if (a.f47133a) {
                Log.e("WhiteCollector", Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }
}
