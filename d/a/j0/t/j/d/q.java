package d.a.j0.t.j.d;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class q extends d.a.i0.r.q.o {
    @Override // d.a.i0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject.optInt("open_level", 1);
            jSONObject.optInt("open_status", 2);
        }
    }
}
