package d.a.m0.n.j.j;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.m0.n.j.b {
    @Override // d.a.m0.n.j.b
    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("version", b.c().a());
            jSONObject.put("base_info", jSONObject2);
        } catch (JSONException e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}
