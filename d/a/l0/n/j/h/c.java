package d.a.l0.n.j.h;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.l0.n.j.b {
    @Override // d.a.l0.n.j.b
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
            if (d.a.l0.n.c.f47984a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}
