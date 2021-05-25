package d.a.l0.a.i2.d;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements a<JSONObject> {

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f43028b;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.f43028b == null) {
                this.f43028b = new JSONArray();
            }
            this.f43028b.put(jSONObject);
            if (a.f43026a) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public void b() {
        this.f43028b = null;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.f43028b);
        } catch (JSONException e2) {
            if (a.f43026a) {
                Log.e("WhiteCollector", Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }
}
