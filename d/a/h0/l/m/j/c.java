package d.a.h0.l.m.j;

import d.a.h0.l.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.h0.l.m.b {
    @Override // d.a.h0.l.m.b
    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("version", b.b().a());
            jSONObject.put("base_info", jSONObject2);
        } catch (JSONException e2) {
            if (f.f47117a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}
