package d.b.g0.a.y1.d;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements a<JSONObject> {

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f47136b;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.f47136b == null) {
                this.f47136b = new JSONArray();
            }
            this.f47136b.put(jSONObject);
            if (a.f47134a) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public void b() {
        this.f47136b = null;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.f47136b);
        } catch (JSONException e2) {
            if (a.f47134a) {
                Log.e("WhiteCollector", Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }
}
