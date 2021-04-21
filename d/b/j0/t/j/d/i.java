package d.b.j0.t.j.d;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.optInt("video_count");
        } catch (Exception unused) {
        }
    }
}
