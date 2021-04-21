package d.b.h0.l.m.h;

import d.b.h0.l.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.b.h0.l.m.b {
    @Override // d.b.h0.l.m.b
    public JSONObject d() {
        b c2 = b.c();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("version", c2.a());
            jSONObject.put("ceres_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("version", c2.b());
            jSONObject.put("global_info", jSONObject3);
        } catch (JSONException e2) {
            if (f.f49610a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}
