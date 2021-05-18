package d.a.i0.a.i2.d;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements a<JSONObject> {

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f42854b;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.f42854b == null) {
                this.f42854b = new JSONArray();
            }
            this.f42854b.put(jSONObject);
            if (a.f42852a) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public void b() {
        this.f42854b = null;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.f42854b);
        } catch (JSONException e2) {
            if (a.f42852a) {
                Log.e("WhiteCollector", Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }
}
