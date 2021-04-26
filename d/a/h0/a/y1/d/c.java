package d.a.h0.a.y1.d;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements a<JSONObject> {

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f45292b;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.f45292b == null) {
                this.f45292b = new JSONArray();
            }
            this.f45292b.put(jSONObject);
            if (a.f45290a) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public void b() {
        this.f45292b = null;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.f45292b);
        } catch (JSONException e2) {
            if (a.f45290a) {
                Log.e("WhiteCollector", Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }
}
