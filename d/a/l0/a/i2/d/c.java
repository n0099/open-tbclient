package d.a.l0.a.i2.d;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements a<JSONObject> {

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f46704b;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.f46704b == null) {
                this.f46704b = new JSONArray();
            }
            this.f46704b.put(jSONObject);
            if (a.f46702a) {
                Log.d("WhiteCollector", "FEStage: " + jSONObject);
            }
        }
    }

    public void b() {
        this.f46704b = null;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stageError", this.f46704b);
        } catch (JSONException e2) {
            if (a.f46702a) {
                Log.e("WhiteCollector", Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }
}
