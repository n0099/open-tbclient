package d.b.g0.l.m.i;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.b.g0.l.m.b {
    @Override // d.b.g0.l.m.b
    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("version", e.b().d());
            jSONObject.put("tipmsgs", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("version", g.a().b());
            jSONObject.put("pkg_preload", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("version", b.b().c());
            jSONObject.put("pkg_clean_strategy", jSONObject4);
        } catch (JSONException e2) {
            if (d.b.g0.l.f.f48888a) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}
